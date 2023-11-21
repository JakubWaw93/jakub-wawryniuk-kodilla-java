import java.util.Objects;

public class Paper implements Sign {
    private String name;

    public Paper( ) {
    }

    public boolean battle(Sign sign){
        if (sign.equals(new Rock())){
            System.out.println("Paper covers Stone!");
            return true;
        }else if (sign.equals(new Spock())) {
            System.out.println("Paper disproves Spock!");
            return true;
        }else {
            return false;
        }
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
