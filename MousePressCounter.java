import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Lab 5 demo of mouse events.
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @author Ben, Freya
 * @version Spring 2025
 */
public class MousePressCounter extends MouseAdapter implements Runnable, ActionListener {

    private int clickTracker = 0;
    private String toDisplay;
    private JPanel panel;
    private JButton button;


	/**
	 * The run method to set up the graphical user interface
	 */
	@Override
	public void run() {

		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("MouseDemo");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// construct an anonymous class that extends JPanel,
		// for which we override the paintComponent method
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {

				super.paintComponent(g);

				FontMetrics fm = g.getFontMetrics();
				toDisplay = "Mouse press count: " + clickTracker;
				int stringWidth = fm.stringWidth(toDisplay);
				int stringAscent = fm.getAscent();

				int xStart = getWidth() / 2 - stringWidth / 2;
				int yStart = getHeight() / 2 + stringAscent / 2;

				g.drawString(toDisplay, xStart, yStart);
			}
		};

        JPanel panelTWOOOOO = new JPanel(new BorderLayout());


        button = new JButton("Reset");
        panelTWOOOOO.add(panel, BorderLayout.CENTER);
        panelTWOOOOO.add(button, BorderLayout.SOUTH);        
        button.addActionListener(this);
        frame.add(panelTWOOOOO);
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		panel.addMouseWheelListener(this);

		// display the window we've created
		frame.pack();
		frame.setVisible(true);
	}



	@Override
	public void mousePressed(MouseEvent e) {
		clickTracker++;
        panel.repaint();
	}
	
    @Override
    public void actionPerformed(ActionEvent e) {
        // if button 1 is clicked, Print pressed A and increment the A label number
        if (e.getSource() == button) {
            clickTracker = 0;
            panel.repaint();
        }
    }

	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new MousePressCounter());
	}
}
