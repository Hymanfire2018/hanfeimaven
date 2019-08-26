package com.hanfei.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.hanfei.file.FileUser;

public class PoiUtils {
	/**
	 * 
	 * 	读取文件
	 * 
	 */
	public static List<FileUser> readExcel(String filePath) {
		//创建集合存放数据
		List<FileUser> list = new ArrayList<FileUser>();
		POIFSFileSystem fs = null;
		 try {
			 fs=new POIFSFileSystem(new FileInputStream(filePath));
			 HSSFWorkbook wb = new HSSFWorkbook(fs); 
			//读取第第张表格
			 HSSFSheet sheet = wb.getSheetAt(0); 
			 //获取行
			 for(int i= 1;i<sheet.getLastRowNum();i++) {
				 HSSFRow row = sheet.getRow(i); 
				 String[] str = new String[row.getLastCellNum()];			 
				 for (int j=0;j<row.getLastCellNum();j++) {
					str[j]=row.getCell(j).toString();
				}
				FileUser user = new FileUser();
				user.setId(Long.valueOf(str[0]));
				user.setUserName(str[1]);
				user.setPassword(str[2]);
				user.setBirthDay(PoiUtils.stringToDate(str[3]));
				user.setSign(str[4]);
				user.setAge(Integer.valueOf(str[5]));
				user.setSalary(Double.valueOf(str[6]));
				list.add(user);
				// System.out.println("添加了第： "+i+" 个对象");
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 System.out.println("返回了一个存放了 "+list.size()+" 个对象的集合");
		 
		 return list;
	}
 
	/**
	 * 将对象中封装的数据存放到HSSFWorkbook对象中
	 * 
	 * @param list
	 * @return workbook
	 */
	public static HSSFWorkbook getWorkBook(List<FileUser> list) {
		for (FileUser user : list) {
			System.out.println(user);
		}
		// 创建工作表对象
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 在对象中创建一个表
		HSSFSheet sheet = workbook.createSheet("sheet0");
		// 获取表头
		String[] header = PoiUtils.getTabHeader();
		for (int i = 0; i < list.size() + 1; i++) {
			// 创建第i行
			HSSFRow row = sheet.createRow(i);
			// 设置表头
			if (i == 0) {
				for (int j = 0; j < header.length; j++) {
					row.createCell(j).setCellValue(header[j]);
				}
			}
			// 将内容写入excel表格
			else {
				// 获取对象属性值
				String[] userMsg = getUserMsg(list.get(i - 1));
				for (int j = 0; j < userMsg.length; j++) {
					row.createCell(j).setCellValue(userMsg[j]);
				}
			}
 
		}
		return workbook;
	}
 
	/**
	 * 将对象属性值存入到string数组中
	 * 
	 * @param user
	 * @return
	 */
	public static String[] getUserMsg(FileUser user) {
		String[] usersMsg = {
 
				user.getId() != null ? user.getId().toString() : null, user.getUserName(), user.getPassword(),
				PoiUtils.dateToString(user.getBirthDay()), user.getSign(), user.getAge().toString(),
				user.getSalary().toString()
 
		};
		return usersMsg;
 
	}
 
	/**
	 * 提供表头
	 * 
	 * @return
	 */
	public static String[] getTabHeader() {
 
		String[] tabHeader = { "用户ＩＤ", "用户名", "密码", "个性签名", "生日", "年龄", "工资" };
		return tabHeader;
 
	}
 
	/**
	 * 将日期类型的数据转成字符串
	 * 
	 * @param date
	 * @return date
	 */
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
		return sdf.format(date);
 
	}
 
	/**
	 * 将字符串类型的数据转成日期
	 * 
	 * @param date
	 * @return date
	 */
	public static Date stringToDate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
		try {
			return sdf.parse(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("转换失败");
		}
 
	}
}
