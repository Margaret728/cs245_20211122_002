import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Used for writing data in the file and returns boolean value to indicate
 * operation success.
 */
public class PictureDataWriter {

	private final String FILENAME;

	public PictureDataWriter() {
		this.FILENAME = "descriptions.txt";
	}

	/**
	 * Writes all objects from received list in file.
	 * 
	 * @param list - list of PictureData to be written
	 * @return boolean value to indicate write operation success
	 * 
	 */
	public boolean writePictureDataInFile(List<PictureData> list) {
		try {
			FileWriter writer = new FileWriter(FILENAME, false);
			for (PictureData data : list) {
				writer.write(data.getFilename() + "\t" + data.getDate() + "\t" + data.getDescription() + "\n");
			}
			writer.close();
			return true;
		} catch (IOException ex) {
//            Logger.getLogger(PictureDataWriter.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

}
