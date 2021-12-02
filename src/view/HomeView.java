package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomeView extends JFrame {

    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JButton btnPlay = new JButton("iniciar");
    JButton btnCredit = new JButton("creditos");
    JButton btnIntro = new JButton("introdução");

    public HomeView() {
        
        /*
        * loading functions
        */
        
        /*
        * loading windons atributtes
        */
        loadingComponents();
        loadingActionLiestenners();
        
        setDefaultCloseOperation(HomeView.EXIT_ON_CLOSE);
    }

    private void loadingComponents() {
        JPanel container = new JPanel();

        container.add(btnPlay);
        container.add(btnCredit);
        container.add(btnIntro);
        add(container);
        setSize(500, 500);
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
        btnIntro.addActionListener(l->{
                dispose();
                new IntroView();
                System.out.println("intro");
            }
        );
    }
}