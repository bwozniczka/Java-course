import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSliderTest implements ChangeListener {

    JSlider jSlider = new JSlider();
    JLabel label = new JLabel("Wartość: " + jSlider.getValue());

    public void setGUI() {
        JFrame frame = new JFrame("Suwak");
        JPanel panel = new JPanel();

        jSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        jSlider.addChangeListener(this);

        panel.add(jSlider);
        panel.add(label);

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JSliderTest jSliderTest = new JSliderTest();
        jSliderTest.setGUI();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == jSlider) {
            int sliderValue = jSlider.getValue();
            label.setText("Wartość: " + sliderValue);
            System.out.println("Wartość suwaka: " + sliderValue);
        }
    }
}
