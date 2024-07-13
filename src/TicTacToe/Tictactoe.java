package com.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Tictactoe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame("TicTacToe");
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel label = new JLabel();
    JButton[] buttons = new JButton[9];

    boolean p1turn;

    Tictactoe() throws InterruptedException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setVisible(true);

        label.setBackground(Color.black);
        label.setForeground(Color.gray);
        label.setFont(new Font("Ink free", Font.BOLD, 70));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Tic Tac Toe");
        label.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 700, 100);
        title_panel.add(label);
        frame.add(title_panel, BorderLayout.NORTH);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(Color.lightGray);
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            //buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        frame.add(button_panel);

        firstTurn();


    }

    void firstTurn() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (random.nextInt(2) == 0) {
            p1turn = true;
            label.setText("X turn");
        } else {
            p1turn = false;
            label.setText("O turn");
        }
    }
   public void check(){
       if((buttons[0].getText()=="X") &&
               (buttons[1].getText()=="X") &&
                       (buttons[2].getText()=="X"))
       {
                  xwins(0,1,2);
        }
       if((buttons[3].getText()=="X") &&
               (buttons[4].getText()=="X") &&
               (buttons[5].getText()=="X"))
       {
           xwins(3,4,5);
       }
       if((buttons[6].getText()=="X") &&
               (buttons[7].getText()=="X") &&
               (buttons[8].getText()=="X"))
       {
           xwins(6,7,8);
       }
       if((buttons[0].getText()=="X") &&
               (buttons[3].getText()=="X") &&
               (buttons[6].getText()=="X"))
       {
           xwins(0,3,6);
       }
       if((buttons[1].getText()=="X") &&
               (buttons[4].getText()=="X") &&
               (buttons[7].getText()=="X"))
       {
           xwins(1,4,7);
       }
       if((buttons[2].getText()=="X") &&
               (buttons[5].getText()=="X") &&
               (buttons[8].getText()=="X"))
       {
           xwins(2,5,8);
       }
       if((buttons[0].getText()=="X") &&
               (buttons[4].getText()=="X") &&
               (buttons[8].getText()=="X"))
       {
           xwins(0,4,8);
       }
       if((buttons[2].getText()=="X") &&
               (buttons[4].getText()=="X") &&
               (buttons[6].getText()=="X"))
       {
           xwins(2,4,6);
       }
       //for O
       if((buttons[0].getText()=="O") &&
               (buttons[1].getText()=="O") &&
               (buttons[2].getText()=="O"))
       {
           owins(0,1,2);
       }
       if((buttons[3].getText()=="O") &&
               (buttons[4].getText()=="O") &&
               (buttons[5].getText()=="O"))
       {
           owins(3,4,5);
       }
       if((buttons[6].getText()=="O") &&
               (buttons[7].getText()=="O") &&
               (buttons[8].getText()=="O"))
       {
           owins(6,7,8);
       }
       if((buttons[0].getText()=="O") &&
               (buttons[3].getText()=="O") &&
               (buttons[6].getText()=="O"))
       {
           owins(0,3,6);
       }
       if((buttons[1].getText()=="O") &&
               (buttons[4].getText()=="O") &&
               (buttons[7].getText()=="O"))
       {
           owins(1,4,7);
       }
       if((buttons[2].getText()=="O") &&
               (buttons[5].getText()=="O") &&
               (buttons[8].getText()=="O"))
       {
           owins(2,5,8);
       }
       if((buttons[0].getText()=="O") &&
               (buttons[4].getText()=="O") &&
               (buttons[8].getText()=="O"))
       {
           owins(0,4,8);
       }
       if((buttons[2].getText()=="O") &&
               (buttons[4].getText()=="O") &&
               (buttons[6].getText()=="O"))
       {
           owins(2,4,6);
       }

    }
    void xwins(int a,int b,int c){
           buttons[a].setBackground(Color.GREEN);
           buttons[b].setBackground(Color.GREEN);
           buttons[c].setBackground(Color.GREEN);
           for(int i=0;i<9;i++){
               buttons[i].setEnabled(false);
           }
           label.setText("X wins! Bingo!");
    }
    void owins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        label.setText("O wins! Bingo!");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if(e.getSource()==buttons[i]){
                if(p1turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(Color.green);
                        buttons[i].setText("X");
                        p1turn=false;
                        label.setText("O turn");
                        check();
                    }
                }else {
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(Color.blue);
                        buttons[i].setText("O");
                        p1turn=true;
                        label.setText("X turn");
                        check();
                    }
                }
            }
        }
    }
}