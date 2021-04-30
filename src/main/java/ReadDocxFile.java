import java.io.*;
import java.util.List;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class ReadDocxFile
{
//  public static final String WORD_FILE = "C:\\Study\\English\\Vocabulary_2.docx";
public static final String WORD_FILE =
		"C:\\Study\\Programming\\PC projects\\Everyday learning\\EnglishWordRandomizer\\data\\docx files\\Test file.docx";
  public static void readDocxFile(String docxFileName) {
	try {
	  File file = new File(docxFileName);
	  FileInputStream fis = new FileInputStream(file.getAbsolutePath());
	  
	  XWPFDocument document = new XWPFDocument(fis);
	  
	  List<XWPFParagraph> paragraphs = document.getParagraphs();
	  
	  
	  for (XWPFParagraph paragraph : paragraphs) {
		System.out.println(paragraph.getParagraphText());
	  }
	  fis.close();
	} catch (Exception e) {
	  e.printStackTrace();
	}
  }
  public static void main(String[] args)
  {
	readDocxFile(WORD_FILE);
  }
}