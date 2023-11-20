import java.util.Objects;

public class Rock implements Sign {
    private String name;

    public Rock(String name) {
        this.name = name;
    }

    public boolean battle(Sign sign){
        if (sign.equals(new Scissors("Scissors"))) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rock rock = (Rock) o;

        return Objects.equals(name, rock.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return ": Rock";
    }
}