package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Business.CreditController;

public class CreditView extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    CreditView() {
        setSize(800,800);
        loadingComponents();
        setVisible(true);
    }

   private void loadingComponents(){
       JPanel container = new JPanel();
       JLabel points = new JLabel();
       points.setText(CreditController.getPoints()+" pontos");
       container.add(points);
       add(container);
   }
    
}
