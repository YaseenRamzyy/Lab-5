package model;

public class Student extends Person {  // Student inherits from Person
    private String gender;
    private String department;
    private double gpa;

    public Student(int id, String name, int age, String gender, String department, double gpa) {
        super(name, id, age);
        this.gender = gender;
        this.department = department;
        this.gpa = gpa;
    }

    //setters
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setGpa(double gpa) { // bos el validation test dy
        if(gpa <0|| gpa>4 ){
            throw new IllegalArgumentException("Invalid GPA");
        }
        this.gpa = gpa;
    }

    //getters
    public String getGender() {
        return gender;
    }
    public String getDepartment() {
        return department;
    }
    public double getGpa(){
        return gpa;
    }

    @Override
    public String toCSV(){   //comma seperated values
        return id + ","+name+","+age+","+gender+","+department+","+gpa;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



}
