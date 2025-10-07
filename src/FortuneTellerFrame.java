import javax.swing.*;
import java.awt.*;

public class FortuneTellerFrame extends JFrame {

    JPanel mainPnl;
    JPanel topPnl;
    JPanel midPnl;
    JPanel bottomPnl;

    JLabel label;
    ImageIcon image;

    JTextField textField;
    JScrollPane scrollPane;

    JButton readFortune;
    JButton quitBtn;

    public FortuneTellerFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        add(mainPnl);

        setTitle("Fortune Teller");
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createTopPnl(){
        topPnl = new JPanel();
        image = new ImageIcon("fortune.jpg");
        label = new JLabel("Fortune Teller", image, JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 36));
    }
}
