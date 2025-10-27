package frame;

import model.Student;
import model.StudentManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DisplayAllStudents extends JFrame {

    private JTable studentTable;
    private JButton refreshButton;
    private JButton closeButton;
    private JPanel mainPanel;
    private JLabel totalStudentsLabel;

    private StudentManager studentManager;
    private DefaultTableModel tableModel;

    public DisplayAllStudents(StudentManager studentManager) {
        this.studentManager = studentManager;

        setContentPane(mainPanel);
        setTitle("All Registered Students");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        initializeTable();
        loadStudents();
        setupListeners();
    }

    private void initializeTable() {
        String[] columnNames = {"Student ID", "Full Name", "Age", "Gender", "Department", "GPA"};

        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        studentTable.setModel(tableModel);
        studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentTable.setRowHeight(25);
        studentTable.getTableHeader().setReorderingAllowed(false);

        studentTable.getColumnModel().getColumn(0).setPreferredWidth(80);
        studentTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        studentTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        studentTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        studentTable.getColumnModel().getColumn(4).setPreferredWidth(120);
        studentTable.getColumnModel().getColumn(5).setPreferredWidth(60);
    }

    private void loadStudents() {
        tableModel.setRowCount(0);

        List<Student> students = studentManager.getAllStudents();

        for (Student student : students) {
            Object[] rowData = {
                    student.getId(),
                    student.getName(),
                    student.getAge(),
                    student.getGender(),
                    student.getDepartment(),
                    student.getGpa()
            };
            tableModel.addRow(rowData);
        }

        // Update the total students label
        totalStudentsLabel.setText("Total Students: " + students.size());

        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No students found in the system.",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void setupListeners() {
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentManager.loadFromFile(); // Reload from file
                loadStudents();
                JOptionPane.showMessageDialog(DisplayAllStudents.this,
                        "List refreshed successfully!",
                        "Refreshed",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        StudentManager s = new StudentManager("Students.txt");
        DisplayAllStudents displayFrame = new DisplayAllStudents(s);
        displayFrame.setVisible(true);
    }
}

