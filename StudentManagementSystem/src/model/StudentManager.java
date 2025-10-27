package model;

import java.io.*;
import java.util.*;

public class StudentManager {
    private List<Student>students=new ArrayList<>();
    private String fileName;

    public StudentManager(String fileName){
        this.fileName = fileName;
        loadFromFile();
    }

    public List<Student> getStudents() {
        return students;
    }

    //file handling
    public void saveToFile(){
        try (BufferedWriter bw =new BufferedWriter(new FileWriter(fileName))) {
            for ( Student s:students){
                bw.write(s.toCSV());
                bw.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();   // hy print error
        }
    }

    private  void loadFromFile(){
        File file =new File(fileName);
        if(!file.exists()){
            return;    // get out
        }

        try(BufferedReader br =new BufferedReader(new FileReader(file)) ){ // hna ba3tna object mn el file msh el file name 5od balek
            String line;
            students.clear(); // 3ashan nbd2 3la ndafa

            while((line= br.readLine())!=null){
               String [] parts = line.split(",");
               if(parts.length==6){
                   int id=Integer.parseInt(parts[0]);
                   String name=parts[1];
                   int age=Integer.parseInt(parts[2]);
                   String gender=parts[3];
                   String department=parts[4];
                   double gpa=Double.parseDouble(parts[5]);
                   students.add(new Student(id,name,age,gender,department,gpa)); // keda 7atena fel arraylist el esmha students object gdeed mn el Student

               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean addStudent(int id , String name , int age , String gender , String department , double gpa){
        Student newStudent = new Student(id,name,age,gender,department,gpa);
        if (!students.contains(newStudent)){
            students.add(newStudent);
            saveToFile();
            return true;
        }

        // gives an error if the student already exists
        else {
            System.out.println("Student already exist!");
            return false;

        }
    }

    public List<Student> searchStudent(String keyword){ //hyrg3 list bs b bel 7agat el el mwgoda fel object el eta5d mn el Student
        List<Student> result=new ArrayList<>();
        keyword=keyword.toLowerCase().trim();
        for(Student s:students){                 // check by name or by id
            if(s.getName().toLowerCase().contains(keyword)||String.valueOf(s.getId()).equals(keyword)){
                             // 5od balak mn 7etet el string.valueof dy
                result.add(s);
            }
        }
        return result;
    }

    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public boolean updateStudent(int id,String name,int age,String gender,String department,double gpa){
        Student s = findStudentById(id);
        if(s != null){
            s.setName(name);
            s.setAge(age);
            s.setGender(gender);
            s.setDepartment(department);
            s.setGpa(gpa);
            saveToFile();
            return true;
        }
        return false;
    }

}







