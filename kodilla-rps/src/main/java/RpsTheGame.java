import java.util.*;
import java.util.random.RandomGenerator;

public class RpsTheGame {
    private String playerName;
    private Sign computerSign;
    private Sign playerSign;
    private int playerPoints =0;
    private int computerPoints =0;
    private int pointsToWin;
    private int round =1 ;
    private boolean end = false;
    private String playerChoice;


    public void setPlayerSign(int n) {
        List<Sign> signs = new ArrayList<>();
        signs.add(new Rock());
        signs.add(new Paper());
        signs.add(new Scissors());
        signs.add(new Lizard());
        signs.add(new Spock());
        this.playerSign = signs.get(n-1);
    }

    public void setComputerSign(){
        RandomGenerator random = new Random();
        int n = random.nextInt(5);
        List<Sign> signs = new ArrayList<>();
        signs.add(new Rock());
        signs.add(new Paper());
        signs.add(new Scissors());
        signs.add(new Lizard());
        signs.add(new Spock());
        this.computerSign = signs.get(n);
    }

    Scanner input = new Scanner(System.in);

    public void setNameAndPointsToWin(){
        playerPoints=0;
        computerPoints=0;
        round=1;

        System.out.println("What is Your name?");
        playerName = input.nextLine();
        System.out.println("Welcome " + playerName);
        System.out.println("How many points will be needed to win?");
        if (input.hasNextInt()){
        pointsToWin = input.nextInt();
            input.nextLine();
            if (pointsToWin>0){
        System.out.println("Excellent! Our battle will continue until someone gets " + pointsToWin + " point(s).");
            } else {
                System.out.println("Choose number bigger than zero, let's try again.");
                theGame();
            }
        } else {
            input.nextLine();
            System.out.println("Choose a number, lets start form the beginning.");
            theGame();
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
        if (playerChoice.equals("1")|| playerChoice.equals("2")|| playerChoice.equals("3")|| playerChoice.equals("4")|| playerChoice.equals("5")) {
            setPlayerSign(Integer.parseInt(playerChoice));
            setComputerSign();
            System.out.println("Round: "+round);
            System.out.println(playerName + " choose" + playerSign + "!");
            System.out.println("I choose" + computerSign + "!");
        } else if (playerChoice.equals("x")){
            System.out.println("Are You sure You want to leave? Y/N");
            String confirmation = input.next();
            if (confirmation.equals("Y")){
                end = true;
                System.out.println("Until next time.");
            }else if(confirmation.equals("N")){
                theGameLoop();
            }else{
                System.out.println("Choose correct option!");
                setUpForBattle();
            }
        } else if (playerChoice.equals("n")){
            System.out.println("Are You sure You want to start over again? Y/N");
            String confirmation2 = input.next();
            input.nextLine();
            if (confirmation2.equals("Y")){
                round=1;
                theGame();
            } else if (confirmation2.equals("N")){
                end=true;
            } else{
                System.out.println("Choose correct option!");
                setUpForBattle();
            }
        }else{
            System.out.println("Choose correct option!");
            instructions();
            theGameLoop();
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

                    if (playerSign.battle(computerSign)) {
                        playerPoints++;
                        System.out.println("You Win!");
                    } else if (computerSign.battle(playerSign)) {
                        computerPoints++;
                        System.out.println("You Loose!");
                    } else if (playerSign.equals(computerSign)) {
                        System.out.println("We have a draw...");
                    }
                    System.out.println("Player  " + playerName + " points: " + playerPoints);
                    System.out.println("Computer points: " + computerPoints);
                    round++;
                }
            } endGame();
        }
    }
    public void theGame(){
        setNameAndPointsToWin();
        instructions();
        theGameLoop();
    }

}
