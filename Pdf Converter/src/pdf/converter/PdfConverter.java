/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.converter;
import java.io.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.util.*;

/**
 *
 * @author sim
 */
public class PdfConverter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PDDocument pd;
        BufferedWriter wr;
        try {
            File input = new File("/Users/sim/Desktop/abc.pdf");  // The PDF file from where you would like to extract
            File output = new File("/Users/sim/Desktop/test.txt"); // The text file where you are going to store the extracted data
            pd = PDDocument.load(input);
            System.out.println(pd.getNumberOfPages());
            System.out.println(pd.isEncrypted());
            pd.save("CopyOfInvoice.pdf"); // Creates a copy called "CopyOfInvoice.pdf"
            PDFTextStripper stripper = new PDFTextStripper();
            wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
            stripper.writeText(pd, wr);
            if (pd != null) {
                pd.close();
            }
            // I use close() to flush the stream.
            wr.close();
        } 
        catch (Exception e){
            e.printStackTrace();
        } 
     }
    
    
}
