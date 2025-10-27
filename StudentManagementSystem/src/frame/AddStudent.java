package frame;

import model.StudentManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudent extends JFrame {
    private JButton addStudentButton;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField IdField;
    private JTextField departmentField;
    private JTextField GPAfield;
    private JRadioButton male;
    private JRadioButton female;
    private JPanel add;

    public AddStudent(StudentManager newStudent) {

        setVisible(true);
        setSize(500,500);
        setTitle("Add student");
        setContentPane(add);

        String department = departmentField.getText();
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();
                    String department = departmentField.getText();
                    String gender = "";
                    if (male.isSelected()) gender = "male";
                    else if (female.isSelected()) gender = "female";
                    else {
                        JOptionPane.showMessageDialog(null, "Please select a gender!");
                    }
                    int id = Integer.parseInt(IdField.getText());
                    int age = Integer.parseInt(ageField.getText());
                    double gpa = Double.parseDouble(GPAfield.getText());

                    if (name.isEmpty() || department.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please fill all fields.");
                        return;
                    }
                    if (age<16){
                        JOptionPane.showMessageDialog(null, "Age mus be in range 16-30");
                        return;
                    }
                    if (gpa>4){
                        JOptionPane.showMessageDialog(null, "GPA should be less than or equal 4");
                        return;
                    }
                    else {
                        boolean x = newStudent.addStudent(id,name,age,gender,department,gpa);
                        if (x){
                            JOptionPane.showMessageDialog(null, "Student is added successfully!");
                            dispose();

                        }

                        else {
                            JOptionPane.showMessageDialog(null, "Student with this ID already exists");
                        }
                    }


                }
                //for invalid inputs in numeric fields
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                }

            }
        });

    }
    public static void main (String[] args){
        StudentManager s = new StudentManager("Students.txt");
        AddStudent addpage = new AddStudent(s);
    }

}


