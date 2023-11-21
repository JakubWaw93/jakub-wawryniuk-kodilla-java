import java.util.Objects;

public class Scissors implements Sign {
    private String name;

    public Scissors( ) {
    }

    public boolean battle(Sign sign){
        if (sign.equals(new Paper())) {
            System.out.println("Scissors cuts Paper!");
            return true;
        }else if (sign.equals(new Lizard())){
            System.out.println("Scissors decapitates Lizard!");
            return true;
        }else {
            return false;
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Scissors scissors = (Scissors) o;

        return Objects.equals(name, scissors.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return ": Scissors";
    }
}
