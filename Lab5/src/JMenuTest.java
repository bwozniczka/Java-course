import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class JMenuTest implements ActionListener{
    JMenu jMenu = new JMenu("Menu");
    public void setGUI(){
        JFrame frame = new JFrame("Menu restauracji");
        JPanel panel = new JPanel();

        JMenuItem m1 = new JMenuItem("Przystawki");
        JMenuItem m2 = new JMenuItem("Dania główne");
        JMenuItem m3 = new JMenuItem("Napoje");

        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);

        JMenuBar menuBar = new JMenuBar();
        jMenu.add(m1);
        jMenu.add(m2);
        jMenu.add(m3);

        menuBar.add(jMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        JMenuTest jMenuTest = new JMenuTest();
        jMenuTest.setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String category = e.getActionCommand();
        switch (category) {
            case "Przystawki" -> {
                JOptionPane.showMessageDialog(null, "1. Sałatka grecka\n2. Bruschetta");
                System.out.println("Wybrano przystawki");
            }
            case "Dania główne" -> {
                JOptionPane.showMessageDialog(null, "1. Kotlet schabowy\n2. Filet z kurczaka");
                System.out.println("Wybrano dania główne");
            }
            case "Napoje" -> {
                JOptionPane.showMessageDialog(null, "1. Herbata \n2. Kawka");
                System.out.println("Wybrano napoje");
            }
        }
    }
}

