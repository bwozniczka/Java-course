import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonTest implements ActionListener {
    JButton button = new JButton("Kliknij!");
    JFrame frame = new JFrame();

    public void setGUI() {
        JPanel panel = new JPanel();

        button.addActionListener(this);
        panel.add(button);

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JButtonTest jButtonTest = new JButtonTest();
        jButtonTest.setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            JOptionPane.showMessageDialog(frame, "Witam w nowym oknie :)");
            System.out.println("Przycisk został kliknięty!");
        }
    }
}
