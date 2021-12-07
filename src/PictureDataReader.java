
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Used for reading data from the file and return.
 */
public class PictureDataReader {

	private final String FILENAME; // name of file where data is stored

	public PictureDataReader() {
		this.FILENAME = "descriptions.txt";
	}

	/**
	 * Reads data from the file and return.
	 * 
	 * @return List<PictureData>
	 */
	public List<PictureData> readPictureDataFromFile() {
		List<PictureData> list = new ArrayList<>();
		try {
			Scanner sc = new Scanner(new File(FILENAME));
			while (sc.hasNext()) {
				String line = sc.nextLine();
				String[] data = line.split("\t");
				list.add(new PictureData(data[0], data[1], data[2]));
			}
			sc.close();
		} catch (FileNotFoundException ex) {
//            Logger.getLogger(PictureDataWriter.class.getName()).log(Level.SEVERE, null, ex);
		}
		return list;
	}

}
