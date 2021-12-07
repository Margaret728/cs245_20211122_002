/**
 * Used for storing data about photos
 */
public class PictureData {
	private String filename;
	private String date;
	private String description;

	public PictureData() {
	}

	public PictureData(String filename, String date, String description) {
		this.filename = filename;
		this.date = date;
		this.description = description;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "PictureData{" + "filename=" + filename + ", date=" + date + ", description=" + description + '}';
	}

}
