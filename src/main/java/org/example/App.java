package org.example;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static String crackImage(String filePath) {
        File imageFile = new File(filePath);
        ITesseract instance = new Tesseract();
        instance.setDatapath(System.getProperty("user.dir")+"/tessdata");
        try {
            String result = instance.doOCR(imageFile);
            return result;
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
            return "Error while reading image";
        }
    }

    public static void main( String[] args )
    {
        String filePath = System.getProperty("user.dir")+"/src/test/resources/testImage2.png";
        System.out.println(crackImage(filePath));
    }
}
