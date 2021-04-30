import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class ReadDocxFile
{
  public static final String WORD_FILE = "C:\\Study\\English\\Vocabulary_2.docx";
  public static final int NUMBER_OF_WORDS = 10;
  
  public static  ArrayList<String> wordsAndTranslations = new ArrayList<String>();
  public static  ArrayList<String>randomWordsList = new ArrayList<String>();
  
  public static void main(String[] args)
  {
	readDocxFile(WORD_FILE);
	makeRandomWordsList(NUMBER_OF_WORDS);
	printRandomWordsList();
  }
  
  
  private static void readDocxFile(String docxFileName) {
	try {
	  File file = new File(docxFileName);
	  FileInputStream fis = new FileInputStream(file.getAbsolutePath());
	  
	  XWPFDocument document = new XWPFDocument(fis);
	  readTableFromXWPFDocument(document);
	 
	  fis.close();
	} catch (Exception e) {
	  e.printStackTrace();
	}
  }
  
  private static void readTableFromXWPFDocument(XWPFDocument document){
	List<XWPFTable> tables = document.getTables();
	
	for (XWPFTable table : tables) {
	  
	  List<XWPFTableRow> rows = table.getRows();
	  //We don't need first row, we start from the second.
	  for (int i = 1; i< rows.size();i++) {
		try {
		  XWPFTableRow row = rows.get(i);
		  readWordsAndTranslationsFromRow(row);
		}
		catch (Exception e){
		}
	  }
	}
		
  }
  
  private static void readWordsAndTranslationsFromRow(XWPFTableRow row){
	String result="";
	if (row.getCell(0).getText().equals("")||row.getCell(2).getText().equals("")){
	  return;
	}
	result+=row.getCell(0).getText();
	result+="\t\t\t";
	result+=row.getCell(2).getText();
//	System.out.println(result);
	
	wordsAndTranslations.add(result);
	}
  
  
  private static void makeRandomWordsList(int listSize) {
    ArrayList<String>copyList = wordsAndTranslations;
	for (int i = 0; i < listSize; i++) {
	  //random int from 0 to copyList.size()
	  int rNum = getRandomInt(0,copyList.size());
	  randomWordsList.add(copyList.get(rNum));
	  copyList.remove(rNum);
	}
  }
  
  private static int getRandomInt(int min, int max){
	Random r = new Random();
	return r.nextInt((max - min) + 1) + min;
  }
  
  
  private static void printRandomWordsList() {
	for(String s:randomWordsList){
	  System.out.println(s);
	}
  }
  
}