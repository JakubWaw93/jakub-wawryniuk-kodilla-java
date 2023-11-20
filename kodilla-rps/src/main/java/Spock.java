import java.util.Objects;

public class Spock implements Sign{
    private String name;

    public Spock(String name) {
        this.name = name;
    }

    @Override
    public boolean battle(Sign sign) {
        if (sign.equals(new Scissors("Scissors"))){
            System.out.println("Spock smashes Scissors!");
            return true;
        }else if(sign.equals(new Rock("Rock"))) {
            System.out.println("Spock vaporizes Rock!");
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spock spock = (Spock) o;

        return Objects.equals(name, spock.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return ": Spock";
    }
}
