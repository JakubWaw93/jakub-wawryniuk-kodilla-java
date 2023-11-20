import java.util.*;
import java.util.random.RandomGenerator;

public class RpsTheGame {
    private String playerName;
    private Sign computerSign;
    private Sign playerSign;
    private int playerPoints;
    private int computerPoints;
    private int pointsToWin;
    private int round =1 ;
    private boolean end = false;
    private int playerChoice;


    public void setPlayerSign(int n) {
        List<Sign> signs = new ArrayList<>();
        signs.add(new Rock("Rock"));
        signs.add(new Paper("Paper"));
        signs.add(new Scissors("Scissors"));
        this.playerSign = signs.get(n-1);
    }

    public void setComputerSign(){
        RandomGenerator random = new Random();
        int n = random.nextInt(3);
        List<Sign> signs = new ArrayList<>();
        signs.add(new Rock("Rock"));
        signs.add(new Paper("Paper"));
        signs.add(new Scissors("Scissors"));
        this.computerSign = signs.get(n);
    }

    Scanner input = new Scanner(System.in);

    public void setNameAndPointsToWin(){

        System.out.println("Choose your name.");
        playerName = input.nextLine();
        playerPoints =0;
        System.out.println("Welcome " + playerName);
        computerPoints = 0;

        System.out.println("How many points will be needed to win?");
        pointsToWin = input.nextInt();
        input.nextLine();
        System.out.println("Excellent! Our battle will continue until someone gets " + pointsToWin + " point(s).");

    }

    public void instructions(){
        System.out.println("Before we start You need to learn a few things:");
        System.out.println("Key 1 - You play rock");
        System.out.println("Key 2 - You play paper");
        System.out.println("Key 3 - You play scissors");
        System.out.println("Key 4 - You leave the game, \nbut I will ask You if You are sure about that");
        System.out.println("Key 5 - Our game will start from the beginning, \nyet again, i will ask if You want to leave current game");
        System.out.println();
        System.out.println("Let us begin!");
    }

    public void makeAWeaponChoice(){
        System.out.println("Choose Your weapon");
        playerChoice = input.nextInt();
    }

    public void setUpForBattle(){
        if (playerChoice ==1|| playerChoice ==2|| playerChoice ==3) {
            setPlayerSign(playerChoice);
            setComputerSign();
            System.out.println("Round: "+round);
            System.out.println(playerName + " choose" + playerSign + "!");
            System.out.println("I choose" + computerSign + "!");
        } else if (playerChoice==4){
            System.out.println("Are You sure You want to leave? Y-1/N-2");
            int confirmation = input.nextInt();
            if (confirmation==1){
                end = true;
            }else {
                theGameLoop();
            }
        } else if (playerChoice==5){
            System.out.println("Are You sure You want to start over again? Y-1/N-2");
            int confirmation2 = input.nextInt();
            if (confirmation2==1){
                round=1;
                playerPoints=0;
                computerPoints=0;
                theGame();
            } else{
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
            System.out.println("Do You want to fight me one more time ('1'), or leave ('2')?");
            int finalDecision = input.nextInt();
            if (finalDecision==1) {
                System.out.println("How many points will be needed to win?");
                pointsToWin = input.nextInt();
                round = 1;
                playerPoints = 0;
                computerPoints = 0;
                theGameLoop();
            } else {
                end = true;
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


        System.out.println("Until next time.");
    }

}
