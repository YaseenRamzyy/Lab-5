package frame;

import model.Student;
import model.StudentManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Delete extends JFrame {

    private JTable studentTable;
    private JButton deleteButton;
    private JButton refreshButton;
    private JPanel mainPanel;

    private StudentManager studentManager;
    private DefaultTableModel tableModel;

    public Delete(StudentManager studentManager) {
        this.studentManager = studentManager;


        setContentPane(mainPanel);
        setTitle("Delete Student");
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

        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No students found in the system.",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void setupListeners() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedStudent();
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadStudents();
                JOptionPane.showMessageDialog(Delete.this,
                        "Table refreshed successfully!",
                        "Refreshed",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private void deleteSelectedStudent() {
        int selectedRow = studentTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                    "Please select a student to delete.",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int studentId = (int) tableModel.getValueAt(selectedRow, 0);
        String studentName = (String) tableModel.getValueAt(selectedRow, 1);

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this student?\n\n" +
                        "Student ID: " + studentId + "\n" +
                        "Name: " + studentName,
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = studentManager.deleteStudent(studentId);

            if (success) {
                JOptionPane.showMessageDialog(this,
                        "Student deleted successfully!\n" +
                                "Student ID: " + studentId + "\n" +
                                "Name: " + studentName,
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);

                tableModel.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Failed to delete student. Student not found.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void refreshTable() {
        loadStudents();
    }
}