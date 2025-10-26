package frame;

import model.Student;
import model.StudentManager;
import model.Validations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateStudent extends JFrame {
    private JLabel studentManagementSystemLabel;
    private JLabel updateStudentInfoLabel;
    private JLabel studentIdLabel;
    private JTextField idTextField;
    private JButton searchButton;
    private JLabel fullNameLabel;
    private JTextField fullNameTextField;
    private JTextField ageTextField;
    private JLabel ageLabel;
    private JLabel genderLabel;
    private JTextField departementTextField;
    private JTextField gpaTextField;
    private JLabel departementLabel;
    private JLabel gpaLabel;
    private JComboBox genderComboBox;
    private JButton updateButton;
    private JButton backButton;
    private JPanel updatePanel;

    StudentManager std = new StudentManager("Students.txt");

    public UpdateStudent() {
        // title of the screen
        // setContentPane 3l4an el screen tzhar
        // setDefaultCloseOperation 3l4an lma n2fl el window y stop
        // pack tban so8ayara
        // setLocationRelativeTo(null) 3l4an tb2a felnos
        setTitle("Update Student");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(updatePanel);
        pack();
        setLocationRelativeTo(null);

        //  3l4an el preselection beta3 el gender
        genderComboBox.addItem("Select Gender");
        genderComboBox.addItem("Male");
        genderComboBox.addItem("Female");
        genderComboBox.setSelectedIndex(0);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idTextField.getText().trim());
                // backend logic in Student Manager
                Student s = std.findStudentById(id);
                if (s != null) {
                    fullNameTextField.setText(s.getName());
                    ageTextField.setText(String.valueOf(s.getAge()));
                    genderComboBox.setSelectedItem(s.getGender());
                    departementTextField.setText(s.getDepartment());
                    gpaTextField.setText(String.valueOf(s.getGpa()));
                } else {
                    JOptionPane.showMessageDialog(UpdateStudent.this, "Student not found", "Search", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Validations
                if(!Validations.idValidation(idTextField.getText().trim())) {
                    JOptionPane.showMessageDialog(UpdateStudent.this,"Please enter valid ID","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(!Validations.nameValidation(fullNameTextField.getText().trim())) {
                    JOptionPane.showMessageDialog(UpdateStudent.this,"Please enter valid name","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(!Validations.ageValidation(ageTextField.getText().trim())) {
                    JOptionPane.showMessageDialog(UpdateStudent.this,"Please enter valid age","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(!Validations.gendervalidation(genderComboBox.getSelectedItem().toString().trim())) {
                    JOptionPane.showMessageDialog(UpdateStudent.this,"Please enter valid gender","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(!Validations.departmentValidation(departementTextField.getText().trim())) {
                    JOptionPane.showMessageDialog(UpdateStudent.this,"Please enter valid department","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(!Validations.gpaValidation(gpaTextField.getText().trim())) {
                    JOptionPane.showMessageDialog(UpdateStudent.this,"Please enter valid gpa","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(UpdateStudent.this,"Are you sure nigga?","Confirm",JOptionPane.YES_NO_OPTION);
                if(confirm != JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(UpdateStudent.this,"Update Student details cancelled","Cancellation",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                int id = Integer.parseInt(idTextField.getText().trim());
                String name = fullNameTextField.getText().trim();
                int age = Integer.parseInt(ageTextField.getText().trim());
                String gender = genderComboBox.getSelectedItem().toString();
                String department = departementTextField.getText().trim();
                double gpa = Double.parseDouble(gpaTextField.getText().trim());

                // backend logic in Student Manager
                boolean updated = std.updateStudent(id, name, age, gender, department, gpa);

                if (updated) {
                    JOptionPane.showMessageDialog(UpdateStudent.this, "Student updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(UpdateStudent.this, "Student ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // 3l4an tzhar
        setVisible(true);
    }


    public static void main(String[] args) {
        UpdateStudent up = new UpdateStudent();
    }
}