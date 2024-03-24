import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JTextFieldTest implements ActionListener{
    JTextField jTextField = new JTextField();
    JLabel jLabel = new JLabel("Wprowadź liczbę pi (x.yz)");
    JFrame frame = new JFrame("Liczba pi");
    public void setGUI(){
        JPanel panel = new JPanel();

        jTextField.setBounds(100, 30,100,30);

        panel.add(jTextField);
        jTextField.addActionListener(this);

        panel.add(jLabel);
        frame.add(jTextField);
        panel.add(jLabel);

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        JTextFieldTest jTextFieldTest = new JTextFieldTest();
        jTextFieldTest.setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pi = jTextField.getText();
        if(pi.equals("3.14")){
            JOptionPane.showMessageDialog(frame, "Podano dobre przybliżenie!");
            System.out.println("Użytkownik podał prawidłowe przybliżenie");
        }
        else{
            JOptionPane.showMessageDialog(frame, "Podano złe przybliżenie");
            System.out.println("Użytkownik podał złe przybliżenie");
        }
    }
}
