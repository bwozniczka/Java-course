import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPasswordFieldTest implements ActionListener {

    JPasswordField passwordField = new JPasswordField();
    JLabel label = new JLabel("Wprowadź hasło:");
    public void setGUI(){
        JFrame frame = new JFrame("Hasło");
        JPanel panel = new JPanel();
        passwordField.setBounds(100, 30,100,30);
        panel.add(label);

        passwordField.addActionListener(this);
        frame.add(passwordField);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        JPasswordFieldTest jPasswordField = new JPasswordFieldTest();
        jPasswordField.setGUI();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
        label.setText("Twoje hasło zostało zapisane");
        System.out.println("Wprowadzone hasło: " + password);
    }
}
