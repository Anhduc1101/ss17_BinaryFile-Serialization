import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Skill> skills=new ArrayList<>();
        skills.add(new Skill("java",2));
        skills.add(new Skill("C++",1));
        skills.add(new Skill("Python",1));
        Skill selectSkill=skills.get(0);

        Employee employee=new Employee(1,"duc",true,selectSkill);

        File file=new File("src/employee.dat");
        file.createNewFile();
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(employee);
        objectOutputStream.close();

        FileInputStream fileInputStream=new FileInputStream(file);
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        objectInputStream.readObject();
        System.out.println(employee.toString());
        objectOutputStream.close();

    }
}
