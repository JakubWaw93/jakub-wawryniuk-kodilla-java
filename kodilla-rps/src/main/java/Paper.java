import java.util.Objects;

public class Paper implements Sign {
    private String name;

    public Paper(String name) {
        this.name = name;
    }

    public boolean battle(Sign sign){
        if (sign.equals(new Rock("Rock"))) {
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

        Paper paper = (Paper) o;

        return Objects.equals(name, paper.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return ": Paper";
    }
}
