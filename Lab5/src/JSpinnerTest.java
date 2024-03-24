import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSpinnerTest implements ChangeListener {

    JSpinner jSpinner = new JSpinner();
    JLabel jLabel = new JLabel();

    public void setGUI() {
        JFrame frame = new JFrame("Liczba do kwadratu");
        JPanel panel = new JPanel();

        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setSize(250, 100);

        panel.add(jSpinner);
        panel.add(jLabel);

        jSpinner.addChangeListener(this);

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JSpinnerTest jSpinnerTest = new JSpinnerTest();
        jSpinnerTest.setGUI();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int liczba = (int) jSpinner.getValue();
        int potega = liczba * liczba;
        jLabel.setText("Wynik: " + potega);

    }
}
