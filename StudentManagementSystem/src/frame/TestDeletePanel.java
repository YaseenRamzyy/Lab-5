package frame;

import model.StudentManager;
import javax.swing.*;

public class TestDeletePanel {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentManager studentManager = new StudentManager("students.txt");
            Delete deleteFrame = new Delete(studentManager);
            deleteFrame.setVisible(true);
        });
    }
}
