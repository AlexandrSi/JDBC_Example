import java.util.*;

public class DBtoList {
    private int id;    private String name;
    private String subname;
    private int age;

    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubName(String subname) {
        this.subname = subname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + subname + " " + age;
    }
}