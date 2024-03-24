import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class JRadioButtonTest implements ActionListener{
    JFrame frame = new JFrame("2+2 = ");
    JRadioButton b1 = new JRadioButton("5");
    JRadioButton b2 = new JRadioButton("4");
    JRadioButton b3 = new JRadioButton("3");

    public void setGUI(){
        JPanel panel = new JPanel();
        JButton button = new JButton("Potwierdz");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(b1);
        buttonGroup.add(b2);
        buttonGroup.add(b3);

        button.addActionListener(this);

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(button);

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        JRadioButtonTest jRadioButtonTest = new JRadioButtonTest();
        jRadioButtonTest.setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (b1.isSelected() || b3.isSelected()) {
            JOptionPane.showMessageDialog(frame, "Zła odpowiedź");
            System.out.println("Zła odpowiedź");
        } else {
            JOptionPane.showMessageDialog(frame, "Dobra odpowiedź");
            System.out.println("Dobra odpowiedź!");
        }
    }


}
