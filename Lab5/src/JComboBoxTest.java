import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JComboBoxTest implements ItemSelectable {
    JComboBox<String> comboBox = new JComboBox<>(new String[]{"C", "Python", "Java"});

    public void setGUI() {
        JFrame frame = new JFrame("Języki programowania");
        JPanel panel = new JPanel();

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedLanguage = (String) comboBox.getSelectedItem();
                    String message = null;
                    if ("Java".equals(selectedLanguage)) {
                        message = "class HelloWorld {\n" +
                                "    public static void main(String[] args) {\n" +
                                "        System.out.println(\"Hello, World!\"); \n" +
                                "    }\n" +
                                "}";
                    }
                    else if("C".equals(selectedLanguage)){
                        message = "#include <stdio.h>\n" +
                                "int main() {\n" +
                                "   // printf() displays the string inside quotation\n" +
                                "   printf(\"Hello, World!\");\n" +
                                "   return 0;\n" +
                                "}";
                    }
                    else{
                        message = "print('Hello, world!')";
                    }
                    System.out.println("Wybrano język: " + selectedLanguage);
                    JOptionPane.showMessageDialog(null, message);
                }
            }
        });

        panel.add(comboBox);

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JComboBoxTest jComboBoxTest = new JComboBoxTest();
        jComboBoxTest.setGUI();
    }

    @Override
    public Object[] getSelectedObjects() {
        return new Object[]{comboBox.getSelectedItem()};
    }

    @Override
    public void addItemListener(ItemListener l) {
        comboBox.addItemListener(l);
    }

    @Override
    public void removeItemListener(ItemListener l) {
        comboBox.removeItemListener(l);
    }
}
