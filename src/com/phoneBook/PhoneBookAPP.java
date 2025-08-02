package com.phoneBook;

import javax.sound.midi.Soundbank;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookAPP implements WindowListener, ActionListener{
    Frame frame;
    Label Lname,Ladress,Lnumber;
    TextField Tname,Tadress,Tnumber,Tsearch;

    TextArea textArea;
    PrintWriter pp;
    Scanner ss;
    Button Badd,show,clear,search;
    File inffile;
    BufferedWriter bw;

    public PhoneBookAPP() throws FileNotFoundException {
        this.frame = new Frame("PhoneBooK APP");
        Lname = new Label("Name");
        Ladress = new Label("Adress");
        Lnumber = new Label("Number");
        Tname = new TextField();
        Tadress = new TextField();
        Tnumber = new TextField();
        Tsearch = new TextField();
        this.textArea =new TextArea();
        Badd =new Button("Add new Person");
        show=new Button("Show Numbers");
        clear=new Button("Clear");
        search=new Button("Search");

        launch();
        memory();

    }
    public void launch(){
        frame.setVisible(true);
        frame.setBackground(Color.ORANGE);
        frame.setSize(430,700);
        frame.addWindowListener(this);
        frame.setLayout(new FlowLayout());

        frame.add(Lname);
        frame.add(Tname);
        Tname.setPreferredSize(new Dimension(300,30));

        frame.add(Ladress);
        frame.add(Tadress);
        Tadress.setPreferredSize(new Dimension(300,30));

        frame.add(Lnumber);
        frame.add(Tnumber);
        Tnumber.setPreferredSize(new Dimension(300,30));

        frame.add(Badd); Badd.addActionListener(this);
        frame.add(show); show.addActionListener(this);
        frame.add(clear); clear.addActionListener(this);
        frame.add(search); search.addActionListener(this);

        frame.add(Tsearch);
        Tsearch.setPreferredSize(new Dimension(300,30));


        frame.add(textArea);
        textArea.setEditable(false);
        textArea.setColumns(35);
        textArea.setRows(25);


    }
    ArrayList <PhoneBook> ph=new ArrayList<>();
    void memory(){
        inffile=new File("data.txt");  //Project Folder e File, not in src
        try {
            ss=new Scanner(inffile);
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
        }
        while (ss.hasNextLine()){
            String information=ss.nextLine();
            String[] arr=information.split("-");
            if(arr.length==3){
                ph.add(new PhoneBook(arr[0],arr[1],arr[2]));
            }
        }

    }
    int minDistance(String word1, String word2) {
        final int m=word1.length();
        final int n=word2.length();
        int[][] arr=new int[m+1][n+1];

        for(int i=1;i<=m;i++)
        {
            arr[i][0]=i;
        }
        for(int j=1;j<=n;j++){
            arr[0][j]=j;
        }

        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){

                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    arr[i][j]=arr[i-1][j-1];
                }else {
                    int corner=arr[i-1][j-1];
                    int left=arr[i][j-1];
                    int top=arr[i-1][j];
                    arr[i][j]=Math.min(corner,Math.min(left,top))+1;
                }

            }
        }
        return arr[m][n];
    }



    public static void main(String[] args) throws FileNotFoundException {
        PhoneBookAPP app=new PhoneBookAPP();

    }


    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==Badd){

            String nam=Tname.getText();
           String ad=Tadress.getText();
           String num=Tnumber.getText();


            if(!nam.isBlank() && !ad.isBlank() && !num.isBlank()){

                PhoneBook phoneBook=new PhoneBook(nam,ad,num);
                ph.add(phoneBook);

                //writing in file
                try {
                    bw=new BufferedWriter(new FileWriter(inffile,true));
                    bw.newLine();
                    bw.write(nam+"-"+ad+"-"+num);
                    bw.close();
                } catch (IOException ex) {
                    System.out.println("FILE NOT FOUND TO WRITE");
                }
            }


       } else if (e.getSource()==show) {
             textArea.setText(ph.toString());

       }else if (e.getSource()==clear){
           textArea.setText("");
           Tname.setText("");
           Tadress.setText("");
           Tsearch.setText("");
           Tnumber.setText("");
       }else if(e.getSource()==search){

           String nameFromSeach=Tsearch.getText();

           for(PhoneBook value:ph) {
               if (nameFromSeach.toLowerCase().equals(value.name.toLowerCase())) {

                   textArea.setText(value.toString());
                   break;
               }
               int editDistanceSize=minDistance(nameFromSeach.toLowerCase(),value.name.toLowerCase());
               System.out.println(editDistanceSize);
               if(editDistanceSize<3){
                   textArea.setText(value.toString());
                   break;
               }else {
                   textArea.setText("NO ONE FOUND");
               }
           }

        }
       }













    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);

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
    @Override
    public void windowOpened(WindowEvent e) {

    }

}
