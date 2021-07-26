package stockmarket;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class StockMarket extends javax.swing.JFrame {

    DecimalFormat df = new DecimalFormat("0.00");
    static String[] columns = {"Stocks:", "Price:", "Total:"};
    String Recent;
    static int sized = 1,picked=0;
    public static String[][] data = new String[sized][3];
    public static boolean recentup = false;

    public StockMarket() {
        initComponents();
    }

    public void expand() {
        String[][] newArray = new String[sized + 1][3];
        System.arraycopy(data, 0, newArray, 0, data.length);
        data = newArray;
        sized++;
    }

    public void logRecent(double stock, double price, double total) {
        data[sized - 1][0] = Double.toString(stock);
        data[sized - 1][1] = Double.toString(price);
        data[sized - 1][2] = Double.toString(total);
        data[StockMarket.sized-1][picked]+="   <--";
        expand();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jStocksText = new javax.swing.JTextField();
        jPriceText = new javax.swing.JTextField();
        jTotalText = new javax.swing.JTextField();
        jStocksButton = new javax.swing.JButton();
        jPriceButton = new javax.swing.JButton();
        jTotalButton = new javax.swing.JButton();
        jStocksLabel = new javax.swing.JLabel();
        jPriceLabel = new javax.swing.JLabel();
        jTotalLabel = new javax.swing.JLabel();
        jAboutButton = new javax.swing.JButton();
        jClearButton = new javax.swing.JButton();
        jCloseButton = new javax.swing.JButton();
        jRecentButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jStocksButton.setText("Calculate stocks");
        jStocksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStocksButtonActionPerformed(evt);
            }
        });

        jPriceButton.setText("Calculate price");
        jPriceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPriceButtonActionPerformed(evt);
            }
        });

        jTotalButton.setText("Calculate total");
        jTotalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTotalButtonActionPerformed(evt);
            }
        });

        jStocksLabel.setText("Amount of stocks");

        jPriceLabel.setText("Price for stock");

        jTotalLabel.setText("Amount paid in total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jStocksButton, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(jStocksText)
                    .addComponent(jStocksLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPriceText)
                    .addComponent(jPriceButton, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTotalText)
                    .addComponent(jTotalButton, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(jTotalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPriceLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jStocksLabel)
                        .addComponent(jTotalLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jStocksText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTotalText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPriceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jStocksButton)
                    .addComponent(jPriceButton)
                    .addComponent(jTotalButton))
                .addContainerGap())
        );

        jAboutButton.setText("About");
        jAboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAboutButtonActionPerformed(evt);
            }
        });

        jClearButton.setText("Clear");
        jClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClearButtonActionPerformed(evt);
            }
        });

        jCloseButton.setText("Close");
        jCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCloseButtonActionPerformed(evt);
            }
        });

        jRecentButton.setText("Recent transactions");
        jRecentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRecentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jAboutButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jClearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRecentButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCloseButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAboutButton)
                    .addComponent(jClearButton)
                    .addComponent(jCloseButton)
                    .addComponent(jRecentButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAboutButtonActionPerformed
        JOptionPane.showMessageDialog(null, "This program was made by . \nCreated specifically for the Stock Market Game.", "StockMarket Game Info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jAboutButtonActionPerformed

    private void jClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClearButtonActionPerformed
        jStocksText.setText("");
        jPriceText.setText("");
        jTotalText.setText("");
        jStocksText.setBackground(new java.awt.Color(255,255,255));
        jPriceText.setBackground(new java.awt.Color(255,255,255));
        jTotalText.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_jClearButtonActionPerformed

    private void jStocksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStocksButtonActionPerformed
        try {
            double price = Double.parseDouble(jPriceText.getText());
            jPriceText.setBackground(new java.awt.Color(255,255,255));
            double total = Double.parseDouble(jTotalText.getText());
            jPriceText.setBackground(new java.awt.Color(255,255,255));
            double stock = Double.parseDouble(df.format(total / price));
            jStocksText.setBackground(new java.awt.Color(153,255,153));
            jStocksText.setText("" + stock);
            picked=0;
            logRecent(stock, price, total);
        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(null, "Please only enter numbers", "Error Dialog", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jStocksButtonActionPerformed

    private void jPriceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPriceButtonActionPerformed
        try {
            double stock = Double.parseDouble(jStocksText.getText());
            jStocksText.setBackground(new java.awt.Color(255,255,255));
            double total = Double.parseDouble(jTotalText.getText());
            jTotalText.setBackground(new java.awt.Color(255,255,255));
            double price = Double.parseDouble(df.format(total / stock));
            jPriceText.setBackground(new java.awt.Color(153,255,153));
            jPriceText.setText("" + price);
            picked=1;
            logRecent(stock, price, total);
        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(null, "Please only enter numbers", "Error Dialog", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jPriceButtonActionPerformed

    private void jTotalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTotalButtonActionPerformed
        try {
            double stock = Double.parseDouble(jStocksText.getText());
            jStocksText.setBackground(new java.awt.Color(255,255,255));
            double price = Double.parseDouble(jPriceText.getText());
            jPriceText.setBackground(new java.awt.Color(255,255,255));
            double total = Double.parseDouble(df.format(stock * price));
            jTotalText.setBackground(new java.awt.Color(153,255,153));
            jTotalText.setText("" + total);
            picked=2;
            logRecent(stock, price, total);
        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(null, "Please only enter numbers", "Error Dialog", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jTotalButtonActionPerformed

    private void jCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCloseButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jCloseButtonActionPerformed

    private void jRecentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRecentButtonActionPerformed
        if (!recentup) {
            recentup=true;
            NewClass.main(null);
        }
    }//GEN-LAST:event_jRecentButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockMarket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAboutButton;
    private javax.swing.JButton jClearButton;
    private javax.swing.JButton jCloseButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jPriceButton;
    private javax.swing.JLabel jPriceLabel;
    private javax.swing.JTextField jPriceText;
    private javax.swing.JButton jRecentButton;
    private javax.swing.JButton jStocksButton;
    private javax.swing.JLabel jStocksLabel;
    private javax.swing.JTextField jStocksText;
    private javax.swing.JButton jTotalButton;
    private javax.swing.JLabel jTotalLabel;
    private javax.swing.JTextField jTotalText;
    // End of variables declaration//GEN-END:variables
}
