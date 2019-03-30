import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpFrame extends JFrame implements ActionListener {

    private Registeration registeration = null;
    private JPanel panel = null;
    private JTextField username = null;
    private JTextField password = null;
    private JTextField re_password = null;
    private JTextField errorText = null;
    private JButton button = null;
    private boolean checked = false;

    public SignUpFrame() {
        panel = new JPanel();
        panel.setLayout(null);
        username = new JTextField("enter username");
        password = new JTextField("enter password");
        re_password = new JTextField("enter password again");
        errorText = new JTextField();
        button = new JButton("save");
        button.addActionListener(this);

        username.setBounds(260, 0, 120, 20);
        password.setBounds(260, 30, 120, 20);
        re_password.setBounds(260, 60, 120, 20);
        button.setBounds(260, 90, 120, 20);
        errorText.setBounds(260, 120, 120, 20);
        errorText.setVisible(false);

        panel.add(username);
        panel.add(password);
        panel.add(re_password);
        panel.add(button);
        panel.add(errorText);

        getContentPane().add(panel);
        setSize(640, 360);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            if (!(password.getText().toString().equals(re_password.getText().toString()))) {
                errorText.setText("The password does not match!");
                errorText.setVisible(true);
            } else if (password.getText().toString().contains("{") || password.getText().toString().contains(" ") || password.getText().toString().contains("}")) {
                errorText.setText("The password cannot include ' ', '}' or '{'");
                errorText.setVisible(true);
            } else {
                errorText.setVisible(false);
                dispose();
                addUser(username.getText().toString(), password.getText().toString());
            }
        }
    }

    public void addUser(String user, String pass) {
        registeration = new Registeration();
        registeration.signUp(user, pass);
    }
}
