import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * GUI component that can show image
 * 
 */
public class PicturePanel extends JPanel implements MouseMotionListener {

	private JLabel lblImage;
	private JLabel lblPosition;

	private BufferedImage picture;

	public PicturePanel() {
		initComponents();

	}

	private void initComponents() {

		lblImage = new JLabel("");
		lblPosition = new JLabel("(x=0, y=0)");
		lblPosition.setBounds(0, 0, 80, 25);
		addMouseMotionListener(this);
		setLayout(new BorderLayout());
		add(lblImage, BorderLayout.CENTER);
		lblImage.add(lblPosition);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = e.getPoint();
		if (e.getClickCount() > 0) {
			lblPosition.setBounds((int) p.getX(), (int) p.getY(), 110, 25);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Point p = e.getPoint();
		if (e.getClickCount() > 0) {
			lblPosition.setBounds((int) p.getX(), (int) p.getY(), 110, 25);
		}
		lblPosition.setText("(x=" + (int) p.getX() + ", y=" + (int) p.getY() + ")");
	}

	/**
	 * Changes picture that panel shows
	 * 
	 * @param bi - new image to be displayed
	 * 
	 */
	public void setPicture(BufferedImage bi) {
		lblPosition.setBounds(0, 0, 110, 25);
		picture = bi;
		lblImage.setIcon(new ImageIcon(picture));
		repaint();
	}

}
