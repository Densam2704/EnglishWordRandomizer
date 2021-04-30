import java.io.*;
import java.util.List;

import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class ReadDocxFile
{
  public static final String WORD_FILE = "C:\\Study\\English\\Vocabulary_2.docx";
//public static final String WORD_FILE =
//		"C:\\Study\\Programming\\PC projects\\Everyday learning\\EnglishWordRandomizer\\data\\docx files\\Test file.docx";
//
  public static void main(String[] args)
  {
	readDocxFile(WORD_FILE);
  }
  
  private static void readDocxFile(String docxFileName) {
	try {
	  File file = new File(docxFileName);
	  FileInputStream fis = new FileInputStream(file.getAbsolutePath());
	  
	  XWPFDocument document = new XWPFDocument(fis);
	  readParagraphsInXWPFDocument(document);
	  readTableInXWPFDocument(document);
	  
	 
	  fis.close();
	} catch (Exception e) {
	  e.printStackTrace();
	}
  }
  
  private static void readParagraphsInXWPFDocument(XWPFDocument document){
	List<XWPFParagraph> paragraphs = document.getParagraphs();
 
	for (XWPFParagraph paragraph : paragraphs) {
	  System.out.println(paragraph.getParagraphText());
	}
  }
  
  private static void readTableInXWPFDocument(XWPFDocument document){
	List<XWPFTable> tables = document.getTables();
	
	for (XWPFTable table : tables) {
	  System.out.println(table.getText());
//	  for (XWPFTableRow row:rows){
//		System.out.println(row.);
	}
	
  }
}