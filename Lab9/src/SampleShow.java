import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SampleShow extends JPanel{
    private short[] signal;
    SampleShow(short[] signal){
        this.signal = signal;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        drawSignal(graphics);
    }
    private void drawSignal(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        int signalLength = signal.length;

        for (int i = 0; i < signalLength - 1; i++) {
            int x1 = i * width / signalLength;
            int y1 = (int) ((signal[i] + Short.MAX_VALUE) * height / (2 * Short.MAX_VALUE));
            int x2 = (i + 1) * width / signalLength;
            int y2 = (int) ((signal[i + 1] + Short.MAX_VALUE) * height / (2 * Short.MAX_VALUE));

            g.drawLine(x1, height - y1, x2, height - y2);
        }
    }
    private static short[] readSignalFromFile(String filePath) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            int signalLength = dis.available() / 2;
            short[] signal = new short[signalLength];

            for (int i = 0; i < signalLength; i++) {
                byte[] bytes_help = new byte[2];
                dis.readFully(bytes_help);
                signal[i] = ByteBuffer.wrap(bytes_help).order(ByteOrder.LITTLE_ENDIAN).getShort();
            }

            return signal;
        } catch (IOException e) {
            e.printStackTrace();
            return new short[0];
        }
    }

    public static void main(String[] args){
        short[] signal = readSignalFromFile("/Users/bartlomiejwozniczka/Desktop/PZ1_java/Lab9/sample.dat");
        SwingUtilities.invokeLater(() ->{
            JFrame frame = new JFrame("Wykres dźwięku");
            SampleShow sampleShow = new SampleShow(signal);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(sampleShow);
            frame.setSize(800,600);
            frame.setVisible(true);
        });
    }
}
