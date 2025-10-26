package frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton buttonLogin;
    private JButton buttonQuit;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JPanel loginPanel;



    public LoginScreen(){
        setTitle("Login Screen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(loginPanel);
        pack();
        setLocationRelativeTo(null);

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();

                if(username.isEmpty()||password.isEmpty()){
                    JOptionPane.showMessageDialog(LoginScreen.this,"Please fill all the fields!","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (!username.matches("[a-zA-Z0-9_]+")) {
                    JOptionPane.showMessageDialog(LoginScreen.this,"Username can contain letters, numbers and underscores only!","Invalid Username",JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (username.equals("admin") && password.equals("1234")) {
                    JOptionPane.showMessageDialog(LoginScreen.this,"Login Successfully","Welcome",JOptionPane.INFORMATION_MESSAGE);
                } else if (password.length() < 4) {
                    JOptionPane.showMessageDialog(LoginScreen.this,"Password must be at least 4 characters","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (!password.matches(".*\\d.*")) {
                    JOptionPane.showMessageDialog(LoginScreen.this, "Password must contain at least one number.", "Invalid Password", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                else {
                    JOptionPane.showMessageDialog(LoginScreen.this,"Invalid username or password. please try again!","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        });

        setVisible(true);
        buttonQuit.addActionListener(e -> System.exit(0));
    }




    public static void main(String[] args) {
        LoginScreen login = new LoginScreen();
    }
}
