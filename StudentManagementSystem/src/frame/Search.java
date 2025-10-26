package frame;

import model.Student;
import model.StudentManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Search {
    private JTextField textField1;
    private JButton searchButton;
    private JPanel searchPanel;
    JPanel mainPanel;


    private StudentManager manager;

    public Search() {
        manager= new StudentManager("Students.txt");
        searchButton.addActionListener(new ActionListener() {
            String keyword = textField1.getText().trim();    // kda 5dna mn el textbox
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keyword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a name or ID to search.");
                    return;
                }

                List<Student> results= manager.searchStudent(keyword);
                if (results.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No student found for: " + keyword);
                }
                else {
                    StringBuilder sb = new StringBuilder("Found " + results.size() + " student(s):\n\n");
                    for (Student s : results) {
                        sb.append(s.toCSV()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                }

            }
        });
    }


    // Needed to show in a JFrame (if you're using IntelliJ GUI designer)
    public JPanel getMainPanel() {

        return mainPanel;
    }

    // For standalone testing:
    public static void main(String[] args) {
        JFrame frame = new JFrame("Search Students");
        frame.setContentPane(new Search().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
