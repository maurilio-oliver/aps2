package view;

import java.awt.Font;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.StyledEditorKit.FontSizeAction;


public class HomeView extends JFrame {

    private static final long serialVersionUID = 1L;
    JButton btnPlay = new JButton("iniciar");
    JButton btnCredit = new JButton("creditos");
    JLabel title = new JLabel("APS 2");
   

    public HomeView() {
        setResizable(false);
        setLayout(null);
        loadingComponents();
        loadingActionLiestenners();
        setDefaultCloseOperation(HomeView.EXIT_ON_CLOSE);
    }

    private void loadingComponents() {

        add(title);
       add(btnPlay);
       add(btnCredit);
        
        title.setBounds(300,10,100,200);
        title.setFont(new Font("Serif", Font.PLAIN, 30));
        
        btnPlay.setBounds(50, 700, 90, 20);
        btnCredit.setBounds(650, 700, 100, 20);
        setSize(800, 800);
        setVisible(true);
    }
    private void loadingActionLiestenners() {
        btnPlay.addActionListener(l->{
                dispose();
                new GameView();
                System.out.println("play");
            }
        );
        btnCredit.addActionListener(l->{
                dispose();
                new CreditView();
                System.out.println("cridtos");
            }
        );
       
    }
}