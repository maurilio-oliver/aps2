package view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Business.GameController;
import controller.service.QuestService;

public class GameView extends JFrame {

    private GameController gameController = new GameController();
    private static final long serialVersionUID = 1L;
    private QuestService service = new QuestService();
    int i = 0;

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

    JPanel jp = new JPanel();
    JPanel jp2 = new JPanel();

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
        jp.setLayout((LayoutManager) new BoxLayout(jp, BoxLayout.Y_AXIS));
        jp.add(a);
        jp.add(lb);
        jp.add(lb);
        jp2.add(intro);
        jp2.add(e);
       
        add(jp);
        jp.add(jp2);



    }

    public void loandActions(){
        a.addActionListener(l->{
           boolean acert = gameController.checkResponse(i, "A");
           System.out.println(acert);
            i++;
            loadText(i);});
       
        b.addActionListener(l->{});
        
        c.addActionListener(l->{});
        
        d.addActionListener(l->{});
        
        e.addActionListener(l->{});
    }

    public void loadText(int i){
       
       if (i<2) {
           
           intro.setText(service.getLegends(i).getIntro());
           la.setText(service.getLegends(i).getLabel_A());
           lb.setText(service.getLegends(i).getLabel_B());
           lc.setText(service.getLegends(i).getLabel_C());
           ld.setText(service.getLegends(i).getLabel_D());
           le.setText(service.getLegends(i).getLabel_E());
           System.out.println(service.getLegends(i).toString());
        }
    }
    
}
