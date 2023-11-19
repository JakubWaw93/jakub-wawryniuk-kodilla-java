import java.util.ArrayList;
import java.util.List;

public class HumanPlayer {

    private String name;
    private Sign playerSign;

    public HumanPlayer(String name, Sign playerSign) {
        this.name = name;
        this.playerSign = playerSign;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayerSign(int n) {
        List<Sign> signs = new ArrayList<>();
        signs.add(new Rock("Rock"));
        signs.add(new Paper("Paper"));
        signs.add(new Scissors("Scissors"));
        this.playerSign = signs.get(n-1);
    }

    public String getName() {
        return name;
    }


    public Sign getPlayerSign() {
        return playerSign;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HumanPlayer{");
        sb.append("name='").append(name).append('\'');
        sb.append(", playerSign=").append(playerSign);
        sb.append('}');
        return sb.toString();
    }
}
