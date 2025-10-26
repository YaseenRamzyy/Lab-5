package frame;

import model.Student;
import model.StudentManager;

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
    private JButton clearButton;
    private JPanel updatePanel;

    public UpdateStudent() {
        setTitle("Login Screen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(updatePanel);
        pack();
        setLocationRelativeTo(null);

       /* searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idTextField.getText().trim());
                boolean found = false;

                for (Student s : StudentManager.studentList) {
                        if (s.getId() == id) {
                        fullNameTextField.setText(s.getName());
                        ageTextField.setText(String.valueOf(s.getAge()));
                        genderComboBox.setSelectedItem(s.getGender());
                        departementTextField.setText(s.getDepartment());
                        gpaTextField.setText(String.valueOf(s.getGpa()));
                        found = true;
                        break;
                    }
                }
                 if (!found) {
                    JOptionPane.showMessageDialog(this, "Student not found!", "Search", JOptionPane.WARNING_MESSAGE);
                    }

            }
        });*/

        /*updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idTextField.getText().trim());
                String name = fullNameTextField.getText().trim();
                int age = Integer.parseInt(ageTextField.getText().trim());
                String gender = genderComboBox.getSelectedItem().toString();
                String department = departementTextField.getText().trim();
                double gpa = Double.parseDouble(gpaTextField.getText().trim());

                boolean updated = false;

                for (Student s : StudentData.studentList) {
                    if (s.getId() == id) {
                        s.setName(name);
                        s.setAge(age);
                        s.setGender(gender);
                        s.setDepartment(department);
                        s.setGpa(gpa);
                        updated = true;
                        break;
                    }
                }

                if (updated) {
                    JOptionPane.showMessageDialog(this, "Student updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Optionally, refresh the table or save to file
                } else {
                    JOptionPane.showMessageDialog(this, "Student ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });*/

        setVisible(true);
    }



    public static void main(String[] args) {
        UpdateStudent up = new UpdateStudent();
    }
}