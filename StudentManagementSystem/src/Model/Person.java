package Model;
// abstract class
public abstract class Person {
    protected String name;
    protected int id;
    protected int age;

    public Person(String name, int id, int age) {     //constructor
        this.name = name;
        this.id = id;
        this.age = age;
    }

    // getters
    public int getId() {
        return id;
    }
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setAge(int age) {
        if(age < 0) {
            throw new IllegalArgumentException("Age cannot be negative"); // A built-in exception meaning “you gave a bad argument.”
        }
        this.age = age;
    }

    public abstract String toCSV();



}
