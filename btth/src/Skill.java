import java.io.Serializable;

public class Skill implements Serializable {
    private String name;
    private int yoe;

    public Skill() {
    }

    public Skill(String name, int yoe) {
        this.name = name;
        this.yoe = yoe;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                ", yoe=" + yoe +
                '}';
    }
}
