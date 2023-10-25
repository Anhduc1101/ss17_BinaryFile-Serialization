import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable {
    private int id;
    private String name;
    private boolean status;
    List<Skill> skill;
    Skill selecSkill;

    public Employee() {
    }

    public Employee(int id, String name, boolean status, Skill selecSkill) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.selecSkill = selecSkill;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", skill=" + selecSkill +
                '}';
    }
}
