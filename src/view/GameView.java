package view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Business.CreditController;
import controller.Business.GameController;
import controller.service.QuestService;

public class GameView extends JFrame {

    private GameController gameController = new GameController();
    private static final long serialVersionUID = 1L;
    private QuestService service = new QuestService();
    int i = 0;
    int points = 0;

    JButton a = new JButton("A");
    JButton b = new JButton("B");
    JButton c = new JButton("C");
    JButton d = new JButton("D");
    JButton e = new JButton("E");

    JLabel la = new JLabel();
    JLabel lb = new JLabel();
    JLabel lc = new JLabel();
    JLabel ld = new JLabel();
    JLabel le = new JLabel();
    JLabel intro = new JLabel();

    JPanel panelContent = new JPanel();
    
    public GameView() {
        gameController.loadingQList();
        setSize(800, 800);
        setName("GameView");
        setTitle("unip quiz");
        loadComponets();
        loandActions();
        loadText(i);
        setVisible(true);
        
    }
    
    private void loadComponets() {
        JPanel line0 = new JPanel();
        JPanel line1 = new JPanel();
        JPanel line2 = new JPanel();
        JPanel line3 = new JPanel();
        JPanel line4 = new JPanel();
        JPanel line5 = new JPanel();

        
        panelContent.setLayout((LayoutManager) new BoxLayout(panelContent, BoxLayout.Y_AXIS));
        line0.add(intro);
        line1.add(a);
        line1.add(la);
        line2.add(b);
        line2.add(lb);
        line3.add(c);
        line3.add(lc);
        line4.add(d);
        line4.add(ld);
        line5.add(e);
        line5.add(le);


        panelContent.add(line0);
        panelContent.add(line1);
        panelContent.add(line2);
        panelContent.add(line3);
        panelContent.add(line4);
        panelContent.add(line5);
        
       
        add(panelContent);

    }

    public void loandActions(){
        a.addActionListener(l->{
            run(i, "A"); 
           
            i++;
           loadText(i);
           System.out.println(i+"cliskc");
           
         }
        );
       
        b.addActionListener(l->{
                    run(i, "B"); 
                i++;
                loadText(i);
            }
             );
        
        c.addActionListener(l->{ 
                run(i, "C"); 
                i++;
                loadText(i);
            }
             );
        
        d.addActionListener(l->{ 
            run(i, "D"); 
            i++;
            loadText(i);
        }
         );
        
        e.addActionListener(l->{ 
            run(i, "E"); 
           i++;
           loadText(i);
        }
         );
    }

    

    public void loadText(int i){
       
       if (i<=9) {
           
           intro.setText(service.getLegends(i).getIntro());
           la.setText(service.getLegends(i).getLabel_A());
           lb.setText(service.getLegends(i).getLabel_B());
           lc.setText(service.getLegends(i).getLabel_C());
           ld.setText(service.getLegends(i).getLabel_D());
           le.setText(service.getLegends(i).getLabel_E());
          
          
        }
    }
    
    private void run(int i, String palpite){
        if (i<=9) {
            boolean acert = gameController.checkResponse(i, palpite);

            if (acert) 
                points++;
                
        }  if (service.getLegends(i).getIntro().equals(10+""))  {
            dispose();
            CreditController.setPoints(points);
            new CreditView();
        }
    }
}
