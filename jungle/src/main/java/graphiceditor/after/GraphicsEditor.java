package graphiceditor.after;

import graphiceditor.after.Bmp;
import graphiceditor.after.Gif;
import graphiceditor.after.Jpg;
import graphiceditor.after.Png;

public class GraphicsEditor {

    public void openFile(String fileName) throws Exception {
        String extension = fileName.substring(fileName.length() - 3);
        if ("bmp".equals(extension)) {
            Bmp bmp = new Bmp();
            bmp.openFile(fileName);
        } else if ("gif".equals(extension)) {
            Gif gif = new Gif();
            gif.openFile(fileName);
        } else if ("png".equals(extension)) {
            Png png = new Png();
            png.openFile(fileName);
        } else if ("jpg".equals(extension)) {
            Jpg jpg = new Jpg();
            jpg.openFile(fileName);
        } else {
            throw (new Exception("Unknown file type"));
        }
    }
}
