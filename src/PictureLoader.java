import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Used for getting all images. 
 * 
 */
public class PictureLoader {
    List<BufferedImage> images;
    
    /**
     * Loads images from that locations in memory.
     * 
     */
    public void loadImagesFromPictureData(List<PictureData> list) {
        images = new ArrayList<>();
        for (PictureData data : list) {
            try {
                images.add(ImageIO.read(new File(data.getFilename())));
            } catch (IOException ex) {
                Logger.getLogger(PictureLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @return List of all images
     * 
     */
    public List<BufferedImage> getImages() {
        return images;
    }
    
}
