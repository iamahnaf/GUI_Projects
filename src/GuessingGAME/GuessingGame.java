package com.game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

public class GuessingGame implements WindowListener, ActionListener {
    Frame frame,win,lost;
    Button door,door2,door3;
    Label l1,live,winL,lostL;

    Font custom;
    Random random;
    int game,randomIDX;

    int count=3;
    GuessingGame(){
        frame=new Frame("GuessTheGame");
        win=new Frame();
        lost=new Frame();

        door=new Button("Door 1");
        door2=new Button("Door 2");
        door3=new Button("Door 3");

        l1=new Label();
        live=new Label();
        winL=new Label();
        lostL=new Label();

        custom=new Font("Arial",Font.BOLD,20);
        random=new Random();
    }
    void launch(){
        frame.setVisible(true);
        frame.setSize(600,550);
        frame.addWindowListener(this);
        frame.setBackground(Color.cyan); frame.setLayout(new FlowLayout());
        frame.add(l1); l1.setText("Please Choose a door"); l1.setFont(custom);
        frame.add(live); live.setText("Lives left: 3"); live.setFont(custom);

        //win.setVisible(true);
        win.setBackground(Color.green);
        win.addWindowListener(this); win.setSize(600,550);
        win.add(winL); winL.setText("YOU WON!!"); win.setLayout(new FlowLayout()); winL.setFont(custom);


        //lost.setVisible(true);
        lost.setBackground(Color.red);
        lost.setSize(600,550); lost.addWindowListener(this);
        lost.add(lostL); lostL.setText("YOU LOST!!"); lost.setLayout(new FlowLayout()); lostL.setFont(custom);


        //Button
        frame.add(door); frame.add(door2); frame.add(door3);
        door.addActionListener(this); door2.addActionListener(this); door3.addActionListener(this);

        randomIDX=random.nextInt(3);
        game=randomIDX;
        System.out.println(game);
    }

    public static void main(String[] args) {
        GuessingGame gg=new GuessingGame();
        gg.launch();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        count=count-1;
        if(count==0){
            frame.setVisible(false); win.setVisible(false);
            lost.setVisible(true);
        }
            if(e.getSource()==door){
                if(game==0){
                    frame.setVisible(false); win.setVisible(true); lost.setVisible(false);
                }
                else {
                    live.setText("Lives left: "+count);
                    l1.setText("Opps! Wrong guess");
                    game=random.nextInt(3);
                    System.out.println(game);
                }
            }
           else if(e.getSource()==door2){
                if(game==1){
                    frame.setVisible(false); win.setVisible(true); lost.setVisible(false);
                }else {
                    live.setText("Lives left: "+count);
                    l1.setText("Opps! Wrong guess");
                    game=random.nextInt(3);
                    System.out.println(game);
                }
            }
       else if(e.getSource()==door3){
            if(game==2){
                frame.setVisible(false); win.setVisible(true); lost.setVisible(false);
            }else {
                live.setText("Lives left: "+count);
                l1.setText("Opps! Wrong guess");
                game=random.nextInt(3);
                System.out.println(game);
            }
        }

    }



























    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
       System.exit(1);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
