import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class JListTest implements ListSelectionListener {

    JList<String> list;

    public void setGUI(){
        JFrame frame = new JFrame("Lista zakupów");
        list = new JList<>(new String[]{"Pieczywo", "Masło", "Woda", "Ziemniaki", "Przyprawy","Mięso", "Ogórek", "Czkolada", "Herabta"});
        list.addListSelectionListener(this);

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setViewportView(list);

        frame.getContentPane().add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        JListTest jListTest = new JListTest();
        jListTest.setGUI();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()){
            ListModel<String> model = list.getModel();
            int Index = list.getSelectedIndex();
            String value = model.getElementAt(Index);
            System.out.println("Wybrano: " + value);
        }
    }
}
