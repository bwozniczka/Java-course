import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JCheckBoxTest implements ActionListener {

    JCheckBox checkbox = new JCheckBox("Włącznik");
    JPanel panel = new JPanel();
    public void setGUI() {
        JFrame frame = new JFrame("Włącznik światła");

        checkbox.addActionListener(this);
        panel.add(checkbox);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JCheckBoxTest checkBoxTest = new JCheckBoxTest();
        checkBoxTest.setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == checkbox) {
            if(checkbox.isSelected()) {
                System.out.println("Światło zostało włączone");
                panel.setBackground(Color.WHITE);
            }
            else{
                System.out.println(("Światło zostało wyłączone"));
                panel.setBackground(Color.DARK_GRAY);
            }
        }
    }
}
