//package shubham.random;
//
//import net.sourceforge.tess4j.ITesseract;
//import net.sourceforge.tess4j.Tesseract;
//import net.sourceforge.tess4j.TesseractException;
//import org.apache.pdfbox.io.MemoryUsageSetting;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.rendering.ImageType;
//import org.apache.pdfbox.rendering.PDFRenderer;
//
//import javax.imageio.ImageIO;
//import java.io.File;
//import java.io.IOException;
//
//public class PDFOCRReader {
//    public static void main(String[] args) throws IOException {
//        File imageFile = new File(filePath);
//        ITesseract instance = new Tesseract();
//        try {
//
//            File file = new File(path);
//            PDDocument document = PDDocument.load(file, MemoryUsageSetting.setupTempFileOnly());
//            PDFRenderer pdfRenderer = new PDFRenderer(document);
//            File outPutFile = new PDFRenderer(s"$filePath/${pathPrefix}_$in.jpg");
//            ImageIO.write(pdfRenderer.renderImageWithDPI(in, 300, ImageType.RGB), "jpg", outPutFile);
//            String result = instance.doOCR(imageFile);
//            System.out.println(result);
//        } catch (TesseractException e) {
//            System.err.println(e.getMessage());
//
//        }
//
//    }
//}
