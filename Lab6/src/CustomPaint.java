import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.geom.*;

public class CustomPaint {

    public static void main(String[] args) {
        new CustomPaint();
    }

    public CustomPaint() {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                     UnsupportedLookAndFeelException ignored) {
            }

            JFrame frame = new JFrame("MyPaint");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            MyPane myPane = new MyPane();
            frame.setJMenuBar(myPane.createMenuBar());
            frame.setLayout(new BorderLayout());
            frame.add(myPane.getPaintPane());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public static class MyPane {
        private final PaintPane paintPane;
        private final JComboBox<SizeName> brushSizeBox;
        private final JComboBox<ShapeItem> brushShapeBox;

        public MyPane() {
            paintPane = new PaintPane();
            JPanel optionsPanel = new JPanel();

            brushSizeBox = new JComboBox<>(new SizeName[]{
                    new SizeName("Mały", 10),
                    new SizeName("Średni", 20),
                    new SizeName("Duży", 30),
            });
            brushSizeBox.setSelectedIndex(1);
            brushSizeBox.addActionListener(e -> {
                        SizeName selectedSize = (SizeName) brushSizeBox.getSelectedItem();
                        paintPane.setBrushSize(selectedSize.getSize());
                    });

            optionsPanel.add(new JLabel("Rozmiar: "));
            optionsPanel.add(brushSizeBox);

            brushShapeBox = new JComboBox<>(new ShapeItem[]{
                    new ShapeItem("Koło", new Ellipse2D.Double(0, 0, 20, 20)),
                    new ShapeItem("Kwadrat", new Rectangle2D.Double(0, 0, 15, 15)),
                    new ShapeItem("Trójkąt", createTriangle(25))
            });
            brushShapeBox.setSelectedIndex(0);
            brushShapeBox.addActionListener(e ->
                    paintPane.setBrushShape(brushShapeBox.getItemAt(brushShapeBox.getSelectedIndex()).getShape()));
            optionsPanel.add(new JLabel("Kształt: "));
            optionsPanel.add(brushShapeBox);

            JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            bottomPanel.add(optionsPanel);
            bottomPanel.add(new ColorsPane(paintPane));

            paintPane.add(bottomPanel);
        }

        public JMenuBar createMenuBar() {
            JMenuBar jMenuBar = new JMenuBar();
            JMenu jMenuFile = new JMenu("Plik");
            JMenu jMenuInfo = new JMenu("Info");
            JMenuItem save = new JMenuItem("Zapisz");
            JMenuItem load = new JMenuItem("Wczytaj");
            JMenuItem resize = new JMenuItem("Zmień wielkość");
            JMenuItem exit = new JMenuItem("Wyjście");
            JMenuItem about = new JMenuItem("About");

            save.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveImage();
                }
            });

            load.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    loadImage();
                }
            });

            about.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null,
                            "Program napisany przez Bartłomieja Woźniczkę na zajęcia PZ1",
                            "About",
                            JOptionPane.PLAIN_MESSAGE);
                }
            });

            resize.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTextField width = new JTextField();
                    JTextField height = new JTextField();
                    JLabel widthLabel = new JLabel("Szerokość");
                    JLabel heightLabel = new JLabel("Wysokość");
                    JButton confirm = new JButton("Potwierdź");

                    JFrame frame = new JFrame("Zmiana rozmiaru");
                    frame.setLayout(new GridLayout(3, 2));

                    frame.add(widthLabel);
                    frame.add(width);
                    frame.add(heightLabel);
                    frame.add((height));
                    frame.add(confirm);

                    frame.setSize(200, 100);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);

                    confirm.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        }
                    });
                }
            });

            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            jMenuFile.add(save);
            jMenuFile.add(load);
            jMenuFile.add(resize);
            jMenuFile.add(exit);
            jMenuInfo.add(about);
            jMenuBar.add(jMenuFile);
            jMenuBar.add(jMenuInfo);
            return jMenuBar;
        }

        public PaintPane getPaintPane() {
            return paintPane;
        }

        private void saveImage() {
            BufferedImage bi = paintPane.background;
            try {
                File outputfile = new File("Zapisany_rysunek.png");
                ImageIO.write(bi, "png", outputfile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private void loadImage() {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    File selectedFile = fileChooser.getSelectedFile();
                    BufferedImage img = ImageIO.read(selectedFile);

                    BufferedImage convertedImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
                    convertedImg.getGraphics().drawImage(img, 0, 0, null);

                    paintPane.background = convertedImg;
                    paintPane.setSize(convertedImg.getWidth(), convertedImg.getHeight());
                    paintPane.repaint();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public class ColorsPane extends JPanel {

            private final PaintPane paintPane;

            public ColorsPane(PaintPane paintPane) {
                this.paintPane = paintPane;

                JButton chooseColorButton = new JButton("Choose Color");
                chooseColorButton.addActionListener(e -> chooseColor());
                add(chooseColorButton);
            }

            private void chooseColor() {
                Color selectedColor = JColorChooser.showDialog(this, "Choose Color", paintPane.getForeground());
                if (selectedColor != null) {
                    paintPane.setForeground(selectedColor);
                }
            }
        }

        private Polygon createTriangle(int size) {
            int[] xPoints = {0, size / 2, size};
            int[] yPoints = {size, 0, size};
            return new Polygon(xPoints, yPoints, 3);
        }
    }

    public static class PaintPane extends JPanel {

        private BufferedImage background;
        private int brushSize;
        private int width = 600;
        private int height = 400;
        private Shape brushShape;

        public void setHeight(int height) {
            this.height = height;
        }
        public void setWidth(int width) {
            this.width = width;
        }
        public PaintPane() {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
            brushSize = 10;
            brushShape = new Ellipse2D.Double(0, 0, 10, 10);

            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    updateBuffer();
                }
            });

            MouseAdapter handler = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    drawDot(e.getPoint());
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    drawDot(e.getPoint());
                }
            };
            addMouseListener(handler);
            addMouseMotionListener(handler);
        }

        public void setBrushSize(int size) {
            this.brushSize = size;
            repaint();
        }

        public void setBrushShape(Shape shape) {
            this.brushShape = shape;
        }

        private void updateBrushShape(Shape shape) {
            brushShape = new Ellipse2D.Double((double) brushSize / 2, (double) brushSize / 2, brushSize, brushSize);
        }

        protected void drawDot(Point p) {
            if (background == null) {
                updateBuffer();
            }

            if (background != null) {
                Graphics2D g2d = background.createGraphics();
                g2d.setColor(getForeground());
                AffineTransform affineTransform = g2d.getTransform();
                g2d.translate(p.x - brushSize / 2, p.y - brushSize / 2);

                g2d.fill(brushShape);
                repaint();
                g2d.setTransform(affineTransform);
                g2d.dispose();
            }
            repaint();
        }

        @Override
        public void invalidate() {
            super.invalidate();
            updateBuffer();
        }

        protected void updateBuffer() {
            int width = getWidth();
            int height = getHeight();

            if (width > 0 && height > 0) {
                BufferedImage newBuffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = newBuffer.createGraphics();
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0, 0, width, height);
                if (background != null) {
                    g2d.drawImage(background, 0, 0, this);
                }
                g2d.dispose();
                background = newBuffer;
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(width, height);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (background == null) {
                updateBuffer();
            }
            g2d.drawImage(background, 0, 0, this);
            g2d.dispose();
        }
    }
}
