import com.mysql.jdbc.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {

    private Registeration registeration = null;
    private String username = null;
    private String password = null;
    private JPanel panel = null;
    private JButton loginButton = null;
    private JButton signupButton = null;
    private JButton updateButton = null;
    private JTextField textField = null;
    private JTextField passwordField = null;
    private JTextField error = null;
    private boolean isLogined = false;

    public LoginFrame() {
        registeration = new Registeration();
        JPanel panel = new JPanel();
        loginButton = new JButton("login");
        loginButton.addActionListener(this);
        signupButton = new JButton("sign up");
        signupButton.addActionListener(this);
        updateButton = new JButton("change password");
        updateButton.addActionListener(this);
        textField = new JTextField("username");
        passwordField = new JTextField("password");
        error = new JTextField();
        error.setVisible(false);

        panel.setLayout(null);

        setBorders(textField, 260, 0, 120, 20);
        setBorders(passwordField, 260, 30, 120, 20);
        setBorders(loginButton, 260, 60, 120, 20);
        setBorders(signupButton, 260, 90, 120, 20);
        setBorders(error, 260, 120, 120, 20);
        setBorders(updateButton, 260, 150, 120, 20);

        panel.add(loginButton);
        panel.add(textField);
        panel.add(passwordField);
        panel.add(signupButton);
        panel.add(error);
        panel.add(updateButton);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 360);
        setVisible(true);
    }

    public static void setBorders(Component c, int x, int y, int width, int height) {
        c.setBounds(x, y, width, height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            username = textField.getText().toString();
            password = passwordField.getText().toString();
            if (!(isLogined = registeration.login(username, password))) {
                error.setText("no record, sign up pls");
                error.setVisible(true);
            }

        } else if (e.getSource() == signupButton) {
            new SignUpFrame();
        } else if (e.getSource() == updateButton) {
            new UpdateClass();
        } else {

        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
