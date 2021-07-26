/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randommusicframev2;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author someone
 */
public class RandomMusicFrameV2 extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    static Scanner input = new Scanner(System.in);
    static String url = null;
    static String reg = ("(HREF=\"https:)(.+?)(youtube.com)(.+?\")");
    static File impor = new File("C:/Users/someone/Desktop/Unused/bookmarks_5_2_15.html");
    static File f2 = new File("C:/Users/someone/Desktop/Unused/javafileoperations/bookmarks.txt");
    //static String[] blacklist = new String[300];
    static ArrayList<String> blacklisted=new ArrayList<String>();
    private static PrintStream out;
    static Random rand = new Random();
    static File f1 = new File("C:\\Users\\someone\\Desktop\\Unused\\javafileoperations\\blacklist.txt");
    
    public RandomMusicFrameV2() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jURL = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        jLabel1.setText("Music last selected:");
        
        jURL.setText("-");
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel1).addGap(0, 0, Short.MAX_VALUE)).addComponent(jURL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jURL).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        jButton1.setText("Select new random song");
        jButton1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed();
            }
        });
        
        jButton2.setText("BlackList current song");
        jButton2.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed();
            }
        });
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jButton1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE).addComponent(jButton2).addContainerGap()));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton1).addComponent(jButton2)).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(178, Short.MAX_VALUE)));
        
        pack();
    }// </editor-fold>                        

    private static void jButton1ActionPerformed() {        
        loop();
    }    
    
    private static void jButton2ActionPerformed() {        
        blackList(url);
        loop();
    }    
    
    @SuppressWarnings("resource")
    public static void loop() {
        boolean use_file = true;// if QylRixqRIU pops up, there is a problem with the blacklist still
        String[] countd = count(use_file);
        int r = rand.nextInt(Integer.parseInt(countd[0]));
        boolean ok = false;
        int c = 0;
        if (use_file) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream("C:/Users/someone/Desktop/Unused/javafileoperations/bookmarks.txt");
            } catch (FileNotFoundException e1) {
            }
            Scanner Input = new Scanner(fis);
            while (!ok) {
                while (Input.hasNext()) {
                    if (c == r) {
                        url = Input.nextLine();
                        ok = true;
                    }
                    Input.nextLine();
                    c++;
                }
            }
        } else {
            if (r == 0) {
                r++;
            }
            url = countd[r];
        }
        System.out.println("Opening url, Number: " + r + " : " + url);
        jURL.setText("- " + url);
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI(url);
            desktop.browse(oURL);
        } catch (URISyntaxException e) {
        } catch (IOException e) {
        }
    }
    
    public static void blackList(String URL) {
        try {
            ArrayList<String> blacklistedfiles=new ArrayList<String>();
            //String[] blacklist = new String[100];
            FileInputStream black = new FileInputStream("C:/Users/someone/Desktop/Unused/javafileoperations/blacklist.txt");
            Scanner Input = new Scanner(black);
            int x = 0;
            while (Input.hasNext()) {
                blacklistedfiles.add(Input.nextLine());
                x++;
            }
            out = new PrintStream(new FileOutputStream(f1));
            for(String s:blacklistedfiles){
                out.println(s);
            }
            //for (int d = 1; d <= x; d++) {
            //    out.append(blacklist[d] + "\n");
            //}
            out.append(URL);
            out.close();
        } catch (Exception e) {
            
        }
        System.out.println("Blacklisted: " + URL);
    }
    
    @SuppressWarnings({"resource", "null"})
    public static String[] count(boolean file) {
//        System.out.println("Please wait");
        String PATH = impor.toString();
        String PATHp = ("C:/Users/someone/Desktop/Unused/javafileoperations/Blacklist.txt");
        String[] books = new String[400];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(PATHp);
        } catch (FileNotFoundException e) {
        }
        Scanner Input = new Scanner(fis);
        int blackcount = 0;
        while (Input.hasNextLine()) {
            blacklisted.add(Input.nextLine());
            blackcount++;
        }
        int x = 1;
        try {
            fis.close();
            fis = new FileInputStream(PATH);
        } catch (IOException e) {
        }
        try {
            out = new PrintStream(new FileOutputStream(f2));
        } catch (FileNotFoundException e) {
        }
        Input = new Scanner(fis);
        
        CharSequence r;
        boolean dod;
        while (Input.hasNext()) {
            CharSequence d = Input.nextLine();
            for (int c = 0; c < d.length() - 50; c++) {
                r = d.subSequence(c, c + 50);
                if (c >= 80) {
                    c = d.length() - 49;
                }
                if (Pattern.matches("(HREF=\"https:)(.+?)(youtube.com)(.+?\")", r)) {
                    dod = true;
                    if(blacklisted.contains(((String)r).substring(6, 49))){
                        dod=false;
                    }
                    //for (int q = 0; q < blackcount; q++) {
                    //    if ((((String) r).substring(6, 49)).equals(blacklist[q])) {
                    //        dod = false;
                    //    }
                    //}
                    if (dod) {
                        String l = (r.toString()).substring(6, 49);
                        //							System.out.println(l);
                        if (file) {
                            out.println(l);
                        } else {
                            books[x] = l;
                        }
                        c = d.length() - 49;
                        x++;
                    }
                }
            }
        }
        System.out.println("Found all songs: " + (x - blackcount) + ", Blacklisted: " + blackcount);
        books[0] = Integer.toString(x);
        return books;
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new RandomMusicFrameV2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel jURL;
    // End of variables declaration                   
}
