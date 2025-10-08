import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.System.*;

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

    ArrayList<String> fortunes = new ArrayList<>();
    Random rnd = new Random();
    int lastFortune = -1;

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
        textArea = new JTextArea(10,25);
        scrollPane = new JScrollPane(textArea);

        textArea.setEditable(false);
        textArea.setFont(new Font("Serif", Font.PLAIN, 16));
        midPnl.add(scrollPane);
    }

    private void createBottomPnl(){
        bottomPnl = new JPanel();
        bottomPnl.setLayout(new GridLayout(1,2));

        readFortune = new JButton("Read My Fortune!");
        readFortune.setFont(new Font("Dialog", Font.BOLD, 16));

        fortunes.add("Worry about the future, but only after your first coffee.");
        fortunes.add("Today is a good day to leave your laundry on the floor.");
        fortunes.add("Your procrastination will be rewarded... later.");
        fortunes.add("The key to happiness is forgetting the key to happiness.");
        fortunes.add("A startling new realization will hit you during a boring meeting.");
        fortunes.add("The person who most annoys you is secretly your twin.");
        fortunes.add("Expect an important call... from a telemarketer.");
        fortunes.add("You'll finally learn what that weird noise in your car is.");
        fortunes.add("Your next great idea appears when you're trying to sleep.");
        fortunes.add("You're a great conversationalist, on the topic of your dog.");
        fortunes.add("The shortest answer is doing the dishes yourself.");
        fortunes.add("A valuable lesson will be learned after stepping in something wet.");

        readFortune.addActionListener((ActionEvent ae) -> {
            int nextFortune = lastFortune;

            while (nextFortune == lastFortune) {
                nextFortune = rnd.nextInt(fortunes.size());
            }

            textArea.append(fortunes.get(nextFortune) + "\n");

            lastFortune = nextFortune;
        });

        quitBtn = new JButton("Quit");
        quitBtn.setFont(new Font("Dialog", Font.BOLD, 16));
        quitBtn.addActionListener((ActionEvent ae) -> exit(0));

        bottomPnl.add(readFortune);
        bottomPnl.add(quitBtn);
    }

}
