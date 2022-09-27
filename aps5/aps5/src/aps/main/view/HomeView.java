package aps.main.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class HomeView extends JFrame {
JButton loginBtn = new JButton();
JLabel emailLabel = new JLabel();
JLabel passWordLabel = new JLabel();
JTextField emailField = new JTextField();
JTextField passWordField = new JTextField();
    HomeView(){
        this.setLayout(null);
        this.setSize(800,800);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("aps V");
        this.loadComponents();
        this.setVisible(true);
    }

    public void loadComponents(){
        //btn
        this.loginBtn.setText("entrar");
        this.emailLabel.setText("email:");
        this.passWordLabel.setText("senha:");


        this.emailLabel.setBounds(50,100,100,30);
        this.passWordLabel.setBounds(50,200,100,30);
        this.loginBtn.setBounds(400,700,60,30);
        this.passWordField.setBounds(110,200,200,40);
        this.emailField.setBounds(110,100,200,40);

        this.add(this.loginBtn);
        this.add(this.emailField);
        this.add(this.emailLabel);
        this.add(this.passWordField);
        this.add(this.passWordLabel);



    }





}
