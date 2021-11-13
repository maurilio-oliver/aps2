package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IntroView extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public IntroView() {
       setSize(800, 800);
       loadingComponents();
       setVisible(true);
   }

   private void loadingComponents(){
       JPanel container = new JPanel();
       JLabel intro = new JLabel();
       JButton back = new JButton("back");
       loadingActionLiestenners(back);
       
       intro.setText("para jogar aperte o play \n e boa sorte");
       container.add(intro);
       container.add(back);
       add(container);

   }

   void loadingActionLiestenners(JButton back){
        back.addActionListener(l->{
            dispose();
            new HomeView();
        });
   }
    
}
