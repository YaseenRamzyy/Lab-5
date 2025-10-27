package frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.StudentManager;

public class HomeScreen extends JFrame {
    private JPanel Home;
    private JButton addANewStudentButton;
    private JButton displayAllRegisteredStudentsButton;
    private JButton updateStudentDetailsButton;
    private JButton deleteStudentRecordButton;
    private JButton searchForAStudentButton;
    private JLabel studentManagementSystemLabel;
    private JButton backButton;
    private StudentManager studentManager;



    public HomeScreen() {

        // Initialize the StudentManager
        studentManager = new StudentManager("Students.txt");

        setTitle("Home Screen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(Home);
        pack();
        setLocationRelativeTo(null);
        addANewStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddStudent(studentManager).setVisible(true);
            }
        });


        displayAllRegisteredStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        updateStudentDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateStudent().setVisible(true);
                HomeScreen.this.dispose();
            }
        });


        deleteStudentRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        searchForAStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame searchFrame = new JFrame("Search Students");
                Search searchPanel = new Search();
                searchFrame.setContentPane(searchPanel.getMainPanel());
                searchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                searchFrame.pack();
                searchFrame.setLocationRelativeTo(null);
                searchFrame.setVisible(true);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // return to the login screen
            }
        });

        setVisible(true);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginScreen().setVisible(true);
                HomeScreen.this.dispose();
            }
        });
    }
    public static void main (String[]args){
        HomeScreen home = new HomeScreen();
    }
}
