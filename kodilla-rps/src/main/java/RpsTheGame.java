import java.util.*;
import java.util.random.RandomGenerator;

public class RpsTheGame {
    private String playerName;
    private Sign computerSign;
    private Sign playerSign;
    private int playerPoints;
    private int computerPoints;
    private int numberOfRounds;
    private int round =1 ;
    boolean end = false;


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
    public void theGame(){
        Scanner input = new Scanner(System.in);

        System.out.println("Choose your name.");
        playerName = input.nextLine();
        playerPoints =0;
        System.out.println("Welcome " + playerName);
        computerPoints = 0;

        System.out.println("How many rounds would You like to play?");
        numberOfRounds = input.nextInt();
        input.nextLine();
        System.out.println("Excellent! Our battle will take " + numberOfRounds + " rounds.");

        System.out.println("Before we start You need to learn a few things:");
        System.out.println("Key 1 - You play rock");
        System.out.println("Key 2 - You play paper");
        System.out.println("Key 3 - You play scissors");
        System.out.println("Key x - You leave the game, \nbut I will ask You if You are sure about that");
        System.out.println("Key n - Our game will start from the beginning, \nyet again, i will ask if You want to leave current game");
        System.out.println();

        System.out.println("Let us begin!");

        while (!end) {

            System.out.println("Choose Your weapon");


            String playerChoice = input.nextLine();
            if (Integer.parseInt(playerChoice)==1||Integer.parseInt(playerChoice)==2||Integer.parseInt(playerChoice)==3) {
                setPlayerSign(Integer.parseInt(playerChoice));
                setComputerSign();
                System.out.println("Round "+round+" of "+numberOfRounds);
                System.out.println(playerName + " choose" + playerSign + "!");
                System.out.println("I choose" + computerSign + "!");
                if (playerSign.battle(computerSign)) {
                    playerPoints++;
                    System.out.println("You Win!");
                }else if (computerSign.battle(playerSign)) {
                    computerPoints++;
                    System.out.println("You Loose!");
                }else if (playerSign.equals(computerSign)){
                    System.out.println("We have a draw...");
                }
                System.out.println("Player  "+playerName+" points: "+playerPoints);
                System.out.println("Computer points: "+computerPoints);
                round++;
                    if (round>numberOfRounds){
                        if (playerPoints>computerPoints){
                            System.out.println("You are the winner!");
                        } else if (playerPoints<computerPoints){
                            System.out.println("You are the loser!");
                        }else{
                            System.out.println("We end this duel with a draw.");
                        }
                        System.out.println("Do You want to fight me one more time ('n'), or leave ('x')?");
                        String finalDecision = input.nextLine();
                        if (finalDecision.equals("n")){
                            System.out.println("How many rounds would You like to play?");
                            numberOfRounds=input.nextInt();
                            round=1;
                            playerPoints=0;
                            computerPoints=0;
                        } else {
                            end=true;
                        }

                    }

            } else if (playerChoice.equals("x")){
                System.out.println("Are You sure You want to leave? Y/N");
                String confirmation = input.nextLine();
                if (confirmation.equals("Y")){
                    end = true;
                }
            } else if (playerChoice.equals("n")){
                System.out.println("Are You sure You want to start over again? Y/N");
                String confirmation = input.nextLine();
                if (confirmation.equals("Y")){
                    round=1;
                    playerPoints=0;
                    computerPoints=0;
                }
            } else {
                System.out.println("Check out possible options and Try again");
            }



        }
        System.out.println("Until next time.");
    }

}
