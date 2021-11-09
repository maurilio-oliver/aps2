package view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameView extends JFrame {

    private static final long serialVersionUID = 1L;

    JButton a = new JButton();
    JButton b = new JButton();
    JButton c = new JButton();
    JButton d = new JButton();
    JButton e = new JButton();

    JLabel la = new JLabel();
    JLabel lb = new JLabel();
    JLabel lc = new JLabel();
    JLabel ld = new JLabel();
    JLabel le = new JLabel();

    JPanel jp = new JPanel();
    JPanel jp2 = new JPanel();

    public GameView() {
        setSize(800, 800);
        setName("GameView");
        setTitle("unip quiz");
        loadComponets();
        loandActions();
        setVisible(true);

    }

    private void loadComponets() {
        jp.setLayout((LayoutManager) new BoxLayout(jp, BoxLayout.Y_AXIS));
        jp.add(a);
        jp.add(b);
        jp.add(c);
        jp2.add(d);
        jp2.add(e);

        add(jp);
        jp.add(jp2);



    }

    public void loandActions(){
        a.addActionListener(l->{});
        b.addActionListener(l->{});
        c.addActionListener(l->{});
        d.addActionListener(l->{});
        e.addActionListener(l->{});
    }
    
}
