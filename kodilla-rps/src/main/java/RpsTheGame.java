import java.util.*;
import java.util.random.RandomGenerator;

public class RpsTheGame {
    private String playerName;
    private String computerSign;
    private String playerSign;
    private int playerPoints =0;
    private int computerPoints =0;
    private int pointsToWin;
    private int round =1 ;
    private boolean end = false;
    private String playerChoice;

    Scanner input = new Scanner(System.in);

    public List<String> makeListWithSigns(){
        List<String> listWithSigns = new ArrayList<>();
        listWithSigns.add("Rock");
        listWithSigns.add("Paper");
        listWithSigns.add("Scissors");
        listWithSigns.add("Lizard");
        listWithSigns.add("Spock");
        return listWithSigns;
    }
    public void setPlayerSign(int n) {
        List<String> signs = makeListWithSigns();
        this.playerSign = signs.get(n-1);
    }

    public void setComputerSign(){
        RandomGenerator random = new Random();
        int n = random.nextInt(5);
        List<String> signs = makeListWithSigns();
        this.computerSign = signs.get(n);
    }

    public boolean battle(String sign1, String sign2){
        if (sign1.equals("Rock") && sign2.equals("Scissors")){
            System.out.println("The Rock crushes Scissors!");
            return true;
        }else if (sign1.equals("Rock") && sign2.equals("Lizard")){
            System.out.println("The Rock crushes Lizard!");
            return true;
        }else if (sign1.equals("Paper") && sign2.equals("Rock")){
            System.out.println("Paper covers Rock!");
            return true;
        }else if (sign1.equals("Paper") && sign2.equals("Spock")) {
            System.out.println("Paper disproves Spock!");
            return true;
        } else if (sign1.equals("Scissors") && sign2.equals("Paper")) {
            System.out.println("Scissors cuts Paper!");
            return true;
        }else if (sign1.equals("Scissors") && sign2.equals("Lizard")){
            System.out.println("Scissors decapitates Lizard!");
            return true;
        }else if (sign1.equals("Lizard") && sign2.equals("Paper")){
            System.out.println("Lizard eats Paper!");
            return true;
        }else if(sign1.equals("Lizard") && sign2.equals("Spock")) {
            System.out.println("Lizard poisons Spock!");
            return true;
        }else if (sign1.equals("Spock") && sign2.equals("Scissors")){
            System.out.println("Spock smashes Scissors!");
            return true;
        }else if(sign1.equals("Spock") && sign2.equals("Rock")) {
            System.out.println("Spock vaporizes Rock!");
            return true;
        } else {
        return false;
        }
    }

    public void setName(){
        System.out.println("What is Your name?");
        playerName = input.nextLine();
        System.out.println("Welcome " + playerName);
        }
    public void setPointsToWin(){
        playerPoints=0;
        computerPoints=0;
        round=1;
        end=false;

        System.out.println("How many points to win?");
        if (input.hasNextInt()){
        pointsToWin = input.nextInt();

            if (pointsToWin>0){
        System.out.println("Excellent! Our battle will continue until someone gets " + pointsToWin + " point(s).");
            } else {
                System.out.println("Choose number bigger than zero, let's try again.");

            }
        } else {
            input.nextLine();
            System.out.println("Choose a number!");
            setPointsToWin();
        }
    }

    public void instructions(){
        System.out.println("Before we start You need to learn a few things:");
        System.out.println("Key 1 - You play Rock");
        System.out.println("Key 2 - You play Paper");
        System.out.println("Key 3 - You play Scissors");
        System.out.println("Key 4 - You play Lizard");
        System.out.println("Key 5 - You play Spock");
        System.out.println("Key x - You leave the game, \nbut I will ask You if You are sure about that");
        System.out.println("Key n - Our game will start from the beginning, \nyet again, i will ask if You want to leave current game");
        System.out.println();
    }

    public void makeAWeaponChoice(){
        System.out.println("Choose Your weapon");
        playerChoice = input.next();
    }

    public void setUpForBattle(){
        switch (playerChoice) {
            case "1", "2", "3", "4", "5" -> {
                setPlayerSign(Integer.parseInt(playerChoice));
                setComputerSign();
                System.out.println("Round: " + round);
                System.out.println(playerName + " choose: " + playerSign + "!");
                System.out.println("I choose: " + computerSign + "!");
            }
            case "x" -> {
                System.out.println("Are You sure You want to leave? Y/N");
                String confirmation = input.next();
                if (confirmation.equals("Y")) {
                    end = true;
                    System.out.println("Until next time.");
                } else if (confirmation.equals("N")) {
                    theGameLoop();
                } else {
                    System.out.println("Choose correct option!");
                    setUpForBattle();
                }
            }
            case "n" -> {
                System.out.println("Are You sure You want to start over again? Y/N");
                String confirmation2 = input.next();
                input.nextLine();
                if (confirmation2.equals("Y")) {
                    end=true;
                    theGame();
                } else if (confirmation2.equals("N")) {
                    theGameLoop();
                } else {
                    System.out.println("Choose correct option!");
                    setUpForBattle();
                }
            }
            default -> {
                System.out.println("Choose correct option!");
                instructions();
                theGameLoop();
            }
        }
    }

    public void endGame(){
        if (playerPoints == pointsToWin || computerPoints == pointsToWin) {
            if (playerPoints == pointsToWin) {
                System.out.println("You are the winner!");
            } else {
                System.out.println("You are the loser!");
            }
            System.out.println("Do You want to fight me one more time ('Y'), or leave ('N')?");
            String finalDecision = input.next();
            input.nextLine();
            if (finalDecision.equals("Y")) {
                System.out.println("Tell me one more time...");
                theGame();
            } else if (finalDecision.equals("N")){
                end = true;
                System.out.println("Until next time.");
            }else{
                System.out.println("Choose correct option!");
                endGame();
            }
        }
    }

    public void theGameLoop() {

        while (!end) {
            makeAWeaponChoice();
            if (!end) {
                setUpForBattle();
                if (!end) {

                    if (battle(playerSign,computerSign)) {
                        playerPoints++;
                        System.out.println("You Win!");
                    } else if (battle(computerSign,playerSign)) {
                        computerPoints++;
                        System.out.println("You Loose!");
                    } else if (playerSign.equals(computerSign)) {
                        System.out.println("We have a draw...");
                    }
                    System.out.println("Player  " + playerName + " points: " + playerPoints);
                    System.out.println("Computer points: " + computerPoints);
                    round++;
                    endGame();
                }
            }

        }
    }
    public void theGame(){
        setName();
        setPointsToWin();
        instructions();
        theGameLoop();
    }

}
