import java.awt.*;
import javax.swing.*;

/**
 * Lab 6 Color changing file
 * 
 * @author Freya Downey and Benjamin Antoniuk
 * @version Spring 2025
 */

// a class that extends JPanel to override the paintComponent method,
// allowing us to interact with Java's graphics system
class GraphicsPanel extends JPanel {


    @Override
    public void paintComponent(Graphics g) {


        // first, we should call the paintComponent method we are
        // overriding in JPanel
        super.paintComponent(g);
       
        // the Graphics object passed to this method has many methods
        // we can use to draw in the area of the panel, one of which
        // allows us to draw a String at a given x,y position
        
        g.setColor(Color.BLUE);
        g.fillOval(100,100,100,50);
        g.fillOval(300,100,100,50);
        g.setColor(Color.green);
        g.fillRect(175,300,150,100);
        g.setColor(Color.BLACK);
        g.drawLine(250,175,250,250);
        g.drawArc(20, 170, 450, 100, -180, 150);
    }
}


public class ArtProject implements Runnable {


    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {


        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("ArtProject");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // construct JPanel with a custom paintComponent method
        JPanel panel = new GraphicsPanel();
        panel.setBackground(Color.magenta);
        frame.add(panel);


        // display the window we've created
        frame.pack();
        frame.setVisible(true);
       
    }


    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new ArtProject());
    }
}
