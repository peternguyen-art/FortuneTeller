import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FortuneTellerFrame extends JFrame {

    JPanel mainPnl;
    JPanel topPnl;
    JPanel midPnl;
    JPanel bottomPnl;

    JLabel label;
    ImageIcon srcImage;

    JTextArea textArea;
    JScrollPane scrollPane;

    JButton readFortune;
    JButton quitBtn;

    public FortuneTellerFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTopPnl();
        mainPnl.add(topPnl, BorderLayout.NORTH);

        createMidPnl();
        mainPnl.add(midPnl, BorderLayout.CENTER);

        createBottomPnl();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        add(mainPnl);

        setTitle("Fortune Teller");
        setSize(400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createTopPnl(){
        topPnl = new JPanel();
        srcImage = new ImageIcon("src/fortune.png");
        Image image = srcImage.getImage();
        Image resizedImage = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        srcImage = new ImageIcon(resizedImage);

        label = new JLabel("Fortune Teller", srcImage, JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 36));

        topPnl.add(label);
    }

    private void createMidPnl(){
        midPnl = new JPanel();
        textArea = new JTextArea(8,20);
        scrollPane = new JScrollPane(textArea);

        textArea.setEditable(false);
        textArea.setFont(new Font("Serif", Font.PLAIN, 20));
        midPnl.add(scrollPane);
    }

    private void createBottomPnl(){
        bottomPnl = new JPanel();
        bottomPnl.setLayout(new GridLayout(1,2));

        readFortune = new JButton("Read My Fortune!");
        readFortune.setFont(new Font("Dialog", Font.BOLD, 16));

        quitBtn = new JButton("Quit");
        quitBtn.setFont(new Font("Dialog", Font.BOLD, 16));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        bottomPnl.add(readFortune);
        bottomPnl.add(quitBtn);
    }
}
