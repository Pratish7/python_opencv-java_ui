import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class ui {
    public static String a;
    public static void main(String[] agrs) throws IOException {

        JFrame window = new JFrame("window");
        window.setSize(500, 500);
        window.setLayout(new GridLayout());
        JLabel label = new JLabel();
        label.setIcon(null);
        window.add(label);
        window.setVisible(true);

        ProcessBuilder pb = new ProcessBuilder("python3", "opencv.py");
        Process p = pb.start();
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        
        while (true) {
            a = in.readLine();
            if (a!=null){
            Base64.getDecoder().decode(a);
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(Base64.getDecoder().decode(a)));
            label.setIcon(new ImageIcon(image));
            }
            else{
                label.setIcon(null);
                System.exit(1);
            }
        }
    }
}