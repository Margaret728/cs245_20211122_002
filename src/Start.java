/**
 * Start this application
 * 
 */
public class Start {

	public static void main(String[] args) {
		PictureDataReader r = new PictureDataReader();
		PictureDataWriter w = new PictureDataWriter();
		PictureLoader l = new PictureLoader();
		new PictureFrame(r, w, l).setVisible(true);
	}
}
