import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyWebBrowser{

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moja przeglądarka");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        frame.add(tabbedPane, BorderLayout.CENTER);

        addNewTab(tabbedPane);

        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void addNewTab(JTabbedPane tabbedPane) {
        JTextPane content = new JTextPane();
        content.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(content);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(10);

        JPanel tabPanel = new JPanel(new BorderLayout());

        content.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    String url = e.getURL().toString();
                    try {
                        content.setPage(url);
                    } catch (IOException ex) {
                        content.setContentType("text/html");
                        content.setText("<html>Nie udało załadować się strony</html>");
                    }
                }
            }
        });

        JButton refreshButton = new JButton("Odśwież");
        JTextField urlTextField = new JTextField(25);
        JButton addButton = new JButton("+");
        JButton closeButton = new JButton("-");

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = urlTextField.getText();
                try {
                    content.setPage(url);
                    int selectedIndex = tabbedPane.getSelectedIndex();
                    tabbedPane.setTitleAt(selectedIndex, url);
                } catch (IOException ex) {
                    content.setContentType("text/html");
                    content.setText("<html>Nie udało załadować się strony</html>");
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewTab(tabbedPane);
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = tabbedPane.getSelectedIndex();
                int tabCount = tabbedPane.getTabCount();
                if (tabCount > 1) {
                    tabbedPane.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(null, "Nie można zamknąć ostatniej karty");
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("URL: "));
        inputPanel.add(urlTextField);
        inputPanel.add(refreshButton);
        inputPanel.add(addButton);
        inputPanel.add(closeButton);

        tabPanel.add(inputPanel, BorderLayout.NORTH);
        tabPanel.add(scrollPane, BorderLayout.CENTER);

        tabbedPane.addTab("Nowa karta", tabPanel);
    }
}