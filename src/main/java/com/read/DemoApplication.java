package com.read;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {
		ArrayList<String> textData = new ArrayList<>();
		SpringApplication.run(DemoApplication.class, args);
		File f = new File("C:\\Users\\kaila\\OneDrive\\Desktop\\sampleData.txt");
		
		try (Scanner sc = new Scanner(f)) {
			while (sc.hasNext()) {
				textData.add(sc.next());
			}
			
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet1 = workbook.createSheet("dataFromTextFile");
			String col = "COL";
			int headerItem = 0;
			String[] header = new String[textData.size()];
			
			for (String s : textData) {
				header[headerItem++]= col+headerItem;
			}
			System.out.println(Arrays.toString(header));
			
			Row headerRow = sheet1.createRow(0);
			for(int j = 0; j<header.length; j++) {
				Cell cell = headerRow.createCell(j);
				cell.setCellValue(header[j]);
			}
			int itemNum = 0;
			
			for(String i : textData) {
				Row row = sheet1.createRow(1);
				row.createCell(itemNum).setCellValue(textData.get(itemNum));
				itemNum=itemNum+1;
				
//				row.createCell(0).setCellValue(textData.get(0));
//				row.createCell(1).setCellValue(textData.get(1));
//				row.createCell(2).setCellValue(textData.get(2));
//				row.createCell(3).setCellValue(textData.get(3));
//				row.createCell(4).setCellValue(textData.get(4));
				
				try {
					File xlFile = new File("C:\\Users\\kaila\\OneDrive\\Desktop\\excelFile.xls");
					FileOutputStream fos  = new FileOutputStream(xlFile);
					
					workbook.write(fos);
					System.out.println("File Written !!!");
				} catch (Exception e) {
					System.err.println(e);
				}
				
				
			
			
			}
			
		}
	}

}
