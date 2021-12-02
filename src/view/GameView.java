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

    public GameView() {
        setDefaultCloseOperation(GameView.EXIT_ON_CLOSE);
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
        

            organizeLayout();
        
       add(a);
       add(b);
       add(c);
       add(d);
       add(e);

       add(la);
       add(lb);
       add(lc);
       add(ld);
       add(le);

       add(intro);



        setLayout(null);

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

    void organizeLayout(){
        la.setBounds(100, 300, 100, 20);
        lb.setBounds(100, 400, 100, 20);
        lc.setBounds(100, 500, 100, 20);
        ld.setBounds(100, 600, 100, 20);
        le.setBounds(100, 700, 100, 20);
        intro.setBounds(50, 50, 800, 50);

        a.setBounds(10, 300,  60, 20);
        b.setBounds(10, 400,  60, 20);
        c.setBounds(10, 500,  60, 20);
        d.setBounds(10, 600,  60, 20);
        e.setBounds(10, 700,  60, 20);

    }
}
