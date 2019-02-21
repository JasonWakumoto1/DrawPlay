import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

public class Cat {
	// drawing constants are private - noone needs to know what we're doing
	// pick a head dimension
	private static final int HEAD_DIMENSION = 100;
	// eyes will be about 1/4 from top of head and 1/4 from left
	private static final int EYE_Y = HEAD_DIMENSION / 4;
	private static final int EYE_X = HEAD_DIMENSION / 4;
	private static final int EYE_SEPARATION = HEAD_DIMENSION / 3;
	// pick eye dimensions
	private static final int EYE_HEIGHT = 20;
	private static final int EYE_WIDTH = 10;
	// pick mouth height, width is based on head dimension
	private static final int MOUTH_HEIGHT = 50;
	private static final int MOUTH_WIDTH = HEAD_DIMENSION / 4;
	// mouth starts about 40% from left edge of head
	private static final int MOUTH_X = HEAD_DIMENSION / 5 * 2;
	private static final int MOUTH_Y = HEAD_DIMENSION / 5 * 3;

	// Eyebrow starts above the eye
	private static final int EYEBROW_OFFSET_LEFT = 5;
	private static final int EYEBROW_OFFSET_RIGHT = 0;

	// Hat
	// pick hat height, width is based on head dimension
	private static final int HAT_HEIGHT = 20;
	private static final int HAT_WIDTH = (int) Math.round(HEAD_DIMENSION * 0.8);
	// hat starts above the head aligned with the center
	private static final int HAT_X = -HAT_WIDTH / 2 + HEAD_DIMENSION / 2;
	private static final int HAT_Y = 0;
	
	// gat starts in the bottom right hand corner of the head
    private static final int GAT_WIDTH = 30;
    private static final int GAT_HEIGHT = 30;

	// draw will render the Cat on the Graphics object
	public void draw(Graphics g, int catX, int catY) {
		Graphics2D g2 = (Graphics2D) g;

		// Enable Antialiasing:
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.setRenderingHints(rh);
		rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHints(rh);

		int x = catX;
		int y = catY;
		// Clear the last animation
		// Draw the head
		g2.setColor(Color.white);
		g2.fillOval(x, y, HEAD_DIMENSION, HEAD_DIMENSION);
		// Draw the eyes
		g2.setColor(Color.green);
		x = catX + EYE_X;
		y = catY + EYE_Y;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		x += EYE_SEPARATION;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		// Draw the mouth
		g2.setColor(Color.pink);
		x = catX + MOUTH_X;
		y = catY + MOUTH_Y;
		g2.fillOval(x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
		// Draw the eyebrows
		g2.setColor(Color.GRAY);
		x = catX + EYE_X;
		y = catY + EYE_Y;
		g2.drawLine(x, y - EYEBROW_OFFSET_LEFT, x + EYE_WIDTH, y - EYEBROW_OFFSET_RIGHT);
		x += EYE_SEPARATION;
		g2.drawLine(x, y - EYEBROW_OFFSET_RIGHT, x + EYE_WIDTH, y - EYEBROW_OFFSET_LEFT);

		// Draw the hat
		g2.setColor(Color.black);
		x = catX + HAT_X;
		y = catY + HAT_Y;
		g2.fillOval(x, y, HAT_WIDTH, HAT_HEIGHT);

		// Draw the gat (starting with the body)
				x = (int) catX + HEAD_DIMENSION/2 + HEAD_DIMENSION/4;
				y = (int) catY + HEAD_DIMENSION/2 + HEAD_DIMENSION/4;
				g2.fillRect(x, y, GAT_WIDTH, GAT_HEIGHT);
				
				// Draw Left aiming implement
				x = (int) catX + HEAD_DIMENSION/2 + HEAD_DIMENSION/4 + GAT_WIDTH/4;
				y = (int) catY + HEAD_DIMENSION/2 + HEAD_DIMENSION/4 - GAT_HEIGHT/4;
				g2.fillRect(x, y, GAT_WIDTH/8, GAT_HEIGHT);
				
				// Draw Right aiming implement
				x = (int) catX + HEAD_DIMENSION/2 + HEAD_DIMENSION/4 + GAT_WIDTH/4 + GAT_WIDTH/2; //
				y = (int) catY + HEAD_DIMENSION/2 + HEAD_DIMENSION/4 - GAT_HEIGHT/4;
				g2.fillRect(x, y, GAT_WIDTH/8, GAT_HEIGHT);
				
				// Draw Handle
				g2.setColor(Color.DARK_GRAY);
				x = (int) catX + HEAD_DIMENSION/2 + HEAD_DIMENSION/4 + GAT_WIDTH/4;
				y = (int) catY + HEAD_DIMENSION/2 + HEAD_DIMENSION/4 + GAT_HEIGHT;
				g2.fillRect(x, y, GAT_WIDTH / 2, GAT_HEIGHT);
				
				// Draw Magazine
				g2.setColor(Color.GRAY);
				x = (int) catX + HEAD_DIMENSION/2 + HEAD_DIMENSION/4 + GAT_WIDTH/4 + GAT_WIDTH/8 + GAT_WIDTH/16;
				y = (int) catY + HEAD_DIMENSION/2 + HEAD_DIMENSION/4 + GAT_HEIGHT + GAT_HEIGHT;
				g2.fillRect(x, y, GAT_WIDTH / 4, GAT_HEIGHT);
				
				// Draw Barrel
				g2.setColor(Color.yellow); 
				x = (int) catX + HEAD_DIMENSION/2 + HEAD_DIMENSION/4 + GAT_WIDTH/4;
				y = (int) catY + HEAD_DIMENSION/2 + HEAD_DIMENSION/4 + GAT_HEIGHT/4;
				g2.fillOval(x, y, GAT_WIDTH / 2, GAT_HEIGHT / 2); 
				
				
				
				// Meow text appears below cat head, +10 places below 
				// so it doesn't overlap the drawing
				g2.setColor(Color.black);
				g2.drawString("The Cat in the Hat with the Gat wants the Stacks, Stat!", 15, 15);
				g2.setColor(Color.black);
				g2.drawString("Meow!", catX + HEAD_DIMENSION, catY+10);
				g2.setColor(Color.RED);
				g2.drawString("Translation: Hand over the cash!", catX + HEAD_DIMENSION, catY+(10 * 3));
	}
}
