public class GraphicsEditor {
    
    public <E extends File> E createTypeGraphics(String extension) throws Exception {
        switch (extension) {
        case "bmp":
            return (E) new Bmp();
        case "gif":
            return (E) new Gif();
        case "png":
            return (E) new Png();
        case "jpg":
            return (E) new Jpg();
        default:
            throw (new Exception("Unknown file type"));
        
        }
    }
}
