/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatastarter;

import utils.CardSwitcher;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author michael.roy-diclemen
 */
public class IntroPanel extends javax.swing.JPanel {
    public static final String CARD_NAME = "intro";
    int infoGrid[][] = new int[11][75];
    String coordinates = "[3][2], [3][3], [3][4], [3][5], [3][16], [3][32], [3][44], [3][45], [3][46], [3][47], [3][64], [4][2], [4][6], [4][32], [4][44], [4][48], [5][2], [5][6], [5][8], [5][10], [5][11], [5][12], [5][14], [5][15], [5][16], [5][20], [5][21], [5][22], [5][23], [5][26], [5][27], [5][28], [5][29], [5][32], [5][35], [5][36], [5][37], [5][38], [5][44], [5][48], [5][50], [5][52], [5][53], [5][54], [5][56], [5][57], [5][58], [5][59], [5][62], [5][63], [5][64], [5][68], [5][69], [5][70], [5][71], [6][2], [6][3], [6][4], [6][5], [6][8], [6][9], [6][16], [6][24], [6][26], [6][30], [6][34], [6][44], [6][45], [6][46], [6][47], [6][50], [6][51], [6][60], [6][64], [6][68], [6][72], [7][2], [7][6], [7][8], [7][16], [7][21], [7][22], [7][23], [7][24], [7][26], [7][30], [7][35], [7][36], [7][37], [7][44], [7][48], [7][50], [7][57], [7][58], [7][59], [7][60], [7][64], [7][68], [7][72], [8][2], [8][6], [8][8], [8][16], [8][20], [8][24], [8][26], [8][30], [8][38], [8][44], [8][48], [8][50], [8][56], [8][60], [8][64], [8][68], [8][72], [9][2], [9][3], [9][4], [9][5], [9][8], [9][14], [9][15], [9][16], [9][17], [9][18], [9][21], [9][22], [9][23], [9][24], [9][26], [9][30], [9][34], [9][35], [9][36], [9][37], [9][44], [9][45], [9][46], [9][47], [9][50], [9][57], [9][58], [9][59], [9][60], [9][62], [9][63], [9][64], [9][65], [9][66], [9][68], [9][72]";
    
    CardSwitcher switcher = null;
    /**
     * Creates new form IntroPanel
     */
    public IntroPanel(CardSwitcher p) {
        initComponents();
        switcher = p;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GameButton = new javax.swing.JButton();
        infoButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        GameButton.setText("Game");
        GameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GameButtonActionPerformed(evt);
            }
        });

        infoButton.setText("I don't know why I'm here");
        infoButton.setToolTipText("");
        infoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(GameButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(infoButton)))
                        .addGap(0, 98, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(GameButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void GameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GameButtonActionPerformed
       switcher.switchToCard(GamePanel.CARD_NAME);
    }//GEN-LAST:event_GameButtonActionPerformed

    private void infoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoButtonActionPerformed
        switcher.switchToCard(InfoPanel.CARD_NAME);
    }//GEN-LAST:event_infoButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GameButton;
    private javax.swing.JButton infoButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
