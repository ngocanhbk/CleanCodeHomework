
public class Main {

    public static void main(String[] args) throws Exception {

        GraphicsEditor graphicsEditor = new GraphicsEditor();
        //bmp
        File bmp = graphicsEditor.createTypeGraphics("bmp");
        bmp.openFile("abc.bmg");
        //png
        File png = graphicsEditor.createTypeGraphics("png");
        png.openFile("abc.png");
    }

}
