import java.util.*;

public class RpsTheGame {
    private HumanPlayer player;
    private ComputerPlayer computerPlayer;
    private int playerPoints;
    private int computerPoints;
    private int numberOfRounds;
    private int round =1 ;
    boolean end = false;

    public void theGame(){
        Scanner input = new Scanner(System.in);

        System.out.println("Choose your name.");
        String name = input.nextLine();
        playerPoints =0;
        player = new HumanPlayer(name, null);
        System.out.println("Welcome " + player.getName());
        computerPoints = 0;
        computerPlayer = new ComputerPlayer(null);

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
                player.setPlayerSign(Integer.parseInt(playerChoice));
                computerPlayer.setComputerSign();
                System.out.println("Round "+round+" of "+numberOfRounds);
                System.out.println(player.getName() + " choose" + player.getPlayerSign() + "!");
                System.out.println("I choose" + computerPlayer.getComputerSign() + "!");
                if (player.getPlayerSign().battle(computerPlayer.getComputerSign())) {
                    playerPoints++;
                    System.out.println("You Win!");
                }
                if (computerPlayer.getComputerSign().battle(player.getPlayerSign())) {
                    computerPoints++;
                    System.out.println("You Loose!");
                }
                if (player.getPlayerSign().equals(computerPlayer.getComputerSign())){
                    System.out.println("We have a draw...");
                }
                System.out.println("Player  "+name+" points: "+playerPoints);
                System.out.println("Computer points: "+computerPoints);

                round++;
            }
            if (playerChoice.equals("x")){
                System.out.println("Are You sure You want to leave? Y/N");
                String confirmation = input.nextLine();
                if (confirmation.equals("Y")){
                    end = true;
                }
            }
            if (playerChoice.equals("n")){
                System.out.println("Are You sure You want to start over again? Y/N");
                String confirmation = input.nextLine();
                if (confirmation.equals("Y")){
                    round=1;
                    playerPoints=0;
                    computerPoints=0;
                }
            }
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


        }
    }

}
