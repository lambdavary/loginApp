import javax.swing.*;
import java.util.ArrayList;

public class WelcomeFrame extends JFrame {

    private Registeration registeration = null;
    private JPanel panel = null;
    private JTextArea textArea = null;
    private ArrayList<String> users = null;

    public WelcomeFrame(){
        panel = new JPanel();
        panel.setLayout(null);
        textArea = new JTextArea();
        textArea.setBounds(80,60,480,240);

        panel.add(textArea);
        getUsers();

        getContentPane().add(panel);
        setSize(640,360);
        setVisible(true);
    }

    public void getUsers(){
        registeration = new Registeration();
        users = registeration.getUsers();
        for (String user : users){
            textArea.append(user);
            textArea.append("\n");
        }
    }
}
