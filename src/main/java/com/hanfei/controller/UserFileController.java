package com.hanfei.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import com.hanfei.file.FileUser;
import com.hanfei.file.service.UserFileService;
import com.hanfei.file.service.UserFileServiceImpl;
import com.hanfei.utils.PoiUtils;

public class UserFileController {
	 
	private UserFileService FileUserFileService;
	
	@Test
	public void creatExcel() {
 
		FileUserFileService = new UserFileServiceImpl();
 
		List<FileUser> list = FileUserFileService.add();
		
		HSSFWorkbook workBook = PoiUtils.getWorkBook(list);
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(new File("D://demo.xls"));
			workBook.write(fileOutputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 
	}
	
	@Test
	public void readExcel() {
		String filePath = "D://demo.xls";
		List<FileUser> readExcel = PoiUtils.readExcel(filePath);
		for (FileUser FileUser : readExcel) {
			System.out.println(FileUser);
		}
	}
	
	
 
}
