/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatastarter;

import java.awt.Color;
import utils.CardSwitcher;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author michael.roy-diclemen
 */
public class GamePanel extends javax.swing.JPanel implements MouseListener {
    
    /**
     * Assign name to the game panel.
     */
    public static final String CARD_NAME = "game";

    CardSwitcher switcher; // This is the parent panel
    Timer animTimer;

    //variables to control your animation elements
    boolean isEdit = false;
    int cellSize;
    
    /**
     * Creates new form GamePanel. 
     * @param p
     */
    public GamePanel(CardSwitcher p) {
        initComponents();

        this.setFocusable(true);

        // tell the program we want to listen to the mouse
        addMouseListener(this);
        
        //tells us the panel that controls this one
        switcher = p;
        
        //create and start a Timer for animation
        animTimer = new Timer(100, new AnimTimerTick());

        //set up the key bindings
//        setupKeys();
        BriansBrain.initializeGrid();
    }

    private void setupKeys() {
        //these lines map a physical key, to a name, and then a name to an 'action'.  You will change the key, name and action to suit your needs
        this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftKey");
        this.getActionMap().put("leftKey", new Move("LEFT"));

        this.getInputMap().put(KeyStroke.getKeyStroke("W"), "wKey");
        this.getActionMap().put("wKey", new Move("w"));

        this.getInputMap().put(KeyStroke.getKeyStroke("D"), "dKey");
        this.getActionMap().put("dKey", new Move("d"));

        this.getInputMap().put(KeyStroke.getKeyStroke("X"), "xKey");
        this.getActionMap().put("xKey", new Move("x"));
    }

    /**
     * Update labels and the grid to the panel. 
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // get frame for game
        FrameForGame f = (FrameForGame)(SwingUtilities.getWindowAncestor(this));
        
        // update counts on the frame
        f.generationCountLabel.setText("Generation: " + BriansBrain.generationCount);
        f.onCellsLabel.setText("On Cells: " + BriansBrain.countOnCells());
        f.dyingCellsLabel.setText("Dying Cells: " + BriansBrain.countDyingCells());
        f.offCellsLabel.setText("Off Cells: " + BriansBrain.countOffCells());

        // find the maximum sidelenth of the cell
        int width, height;
        width = getWidth() / BriansBrain.cols;
        height = getHeight() / BriansBrain.rows;
        cellSize = Math.min(width, height);
        for (int r = 0; r < BriansBrain.rows; r++){
            for (int c = 0; c < BriansBrain.cols; c++){
                switch (BriansBrain.grid[r][c]) {
                    // set color white for on cells
                    case 2 -> g.setColor(Color.white);
                    
                    // set color blue for dying cells
                    case 1 -> g.setColor(Color.blue);
                    
                    // set color black for off cells
                    default -> g.setColor(Color.black);
                }
                // draw each cell
                g.fillRect(c * cellSize, r * cellSize, cellSize, cellSize);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel1)
                .addContainerGap(234, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel1)
                .addContainerGap(168, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
//        lineX = 0;
//        animTimer.start();
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    /**
     * This event captures a click which is defined as pressing and releasing in
     * the same area. 
     *
     * @param me
     */
    public void mouseClicked(MouseEvent me) {
        // check if the customize setup toggle button is clicked
        if (isEdit){
            // get the row and column of cell toggled
            int row = me.getY() / cellSize;
            int col = me.getX() / cellSize;
            if (BriansBrain.grid[row][col] == 2){
                BriansBrain.grid[row][col] = 0;
            }
            else {
                BriansBrain.grid[row][col]++;
            }
            repaint();
        }
    }

    /**
     * When the mountain is pressed
     *
     * @param me
     */
    public void mousePressed(MouseEvent me) {
        System.out.println("Press: " + me.getX() + ":" + me.getY());
    }

    /**
     * When the mouse button is released
     *
     * @param me
     */
    public void mouseReleased(MouseEvent me) {
        System.out.println("Release: " + me.getX() + ":" + me.getY());
    }

    /**
     * When the mouse enters the area
     *
     * @param me
     */
    public void mouseEntered(MouseEvent me) {
        System.out.println("Enter: " + me.getX() + ":" + me.getY());
    }

    /**
     * When the mouse exits the panel
     *
     * @param me
     */
    public void mouseExited(MouseEvent me) {
        System.out.println("Exit: " + me.getX() + ":" + me.getY());
    }

    /**
     * Everything inside here happens when you click on a captured key.
     */
    private class Move extends AbstractAction {

        String key;

        public Move(String akey) {
            key = akey;
        }

        public void actionPerformed(ActionEvent ae) {            
        }

    }

    /**
     * Everything inside this actionPerformed will happen every time the
     * animation timer clicks.
     */
    private class AnimTimerTick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            BriansBrain.updateGrid();

            //force redraw
            repaint();
        }
    }
}
