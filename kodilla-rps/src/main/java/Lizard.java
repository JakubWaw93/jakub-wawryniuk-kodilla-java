import java.util.Objects;

public class Lizard implements Sign{
    private String name;

    public Lizard(String name) {
        this.name = name;
    }

    @Override
    public boolean battle(Sign sign) {
        if (sign.equals(new Paper("Paper"))){
            System.out.println("Lizard eats Paper!");
            return true;
        }else if(sign.equals(new Spock("Spock"))) {
            System.out.println("Lizard poisons Spock!");
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lizard lizard = (Lizard) o;

        return Objects.equals(name, lizard.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return ": Lizard";
    }
}
