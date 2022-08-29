package shubham.random;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class PDFUtils {
    public static void main(String[] args) throws Exception {
//        String baseDir = "C:\\Users\\sverma2\\SHUBHAM\\junk\\Study-CSPU\\books\\ToPrint";
        String baseDir = "C:\\Users\\sverma2\\Downloads\\keps2dd";
//        FileOutputStream os = new FileOutputStream(baseDir+"\\single-upsc-file-os.pdf");
        File base = new File(baseDir);
        List<File> baseD = new ArrayList();
        baseD.add(base);
        List<File> pdfFiles = getPdfFiles(new ArrayList<File>(), baseD);
        PDDocument loaded = null;
        File finalFile = null;
        PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
       try{
           for (int i = 0; i < pdfFiles.size(); i++) {
               pdfMergerUtility.addSource(pdfFiles.get(i));
//               if(i == 0){
//                   finalFile = pdfFiles.get(0);
//                   loaded = PDDocument.load(pdfFiles.get(i));
//               } else {
//                   PDDocument newLoad = PDDocument.load(pdfFiles.get(i));
//
//                   Iterator<PDPage> iterator = newLoad.getPages().iterator();
//
//                   while (iterator.hasNext()){
//                       loaded.addPage(iterator.next());
//                   }
//                   loaded.save(os);
//                   os.flush();
//                   newLoad.close();
//               }
           }
           pdfMergerUtility.setDestinationFileName(baseDir+"\\india-constitution-at-work.pdf");
           MemoryUsageSetting memoryUsageSetting = MemoryUsageSetting.setupTempFileOnly();
           pdfMergerUtility.mergeDocuments(memoryUsageSetting);
           System.out.println("New Total pages"+ loaded.getPages().getCount());
//           os.flush();
//           os.close();
           System.out.println(loaded.getPages().getCount());
       } catch (Exception ex){

       }

        Integer reduce = pdfFiles.stream()
                .map(PDFUtils::countPages)
                .collect(Collectors.toList())
                .stream().reduce(0, Integer::sum);
        System.out.println("Total pages in all books are " + reduce);
    }

    static Integer countPages(File pdfFile) {
        Integer numPages = 0;
        try {
            PDDocument load = PDDocument.load(pdfFile);
            numPages = load.getPages().getCount();
            load.close();
            System.out.println("\nNumber of page in " + pdfFile.getName() + " are " + numPages);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return numPages;
    }

    static List<File> getPdfFiles(List<File> files, List<File> directories) {
        if (directories.isEmpty()) {
            System.out.printf("Total files are " + files.size());
            return files;
        } else {
            File head = directories.get(0);
            directories.remove(0);
            head.listFiles();
            List<File> newFiles = Arrays.stream(head.listFiles()).filter(File::isFile).filter(f -> f.getName().contains(".pdf")).collect(Collectors.toList());
            List<File> newDirs = Arrays.stream(head.listFiles()).filter(File::isDirectory).collect(Collectors.toList());
            files.addAll(newFiles);
            directories.addAll(newDirs);
            return getPdfFiles(files, directories);
        }
    }
}
