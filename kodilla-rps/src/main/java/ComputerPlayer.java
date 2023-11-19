import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.random.RandomGenerator;

public class ComputerPlayer {

    private Sign computerSign;

    public ComputerPlayer(Sign computerSign){
        this.computerSign = computerSign;
    }

    public void setComputerSign(){
        RandomGenerator random = new Random();
        int n = random.nextInt(3)+1;
        List<Sign> signs = new ArrayList<>();
        signs.add(new Rock("Rock"));
        signs.add(new Paper("Paper"));
        signs.add(new Scissors("Scissors"));
        this.computerSign = signs.get(n);
    }


    public Sign getComputerSign() {
        return computerSign;
    }


}
