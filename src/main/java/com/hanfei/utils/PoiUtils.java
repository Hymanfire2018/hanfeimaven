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
	 * 	��ȡ�ļ�
	 * 
	 */
	public static List<FileUser> readExcel(String filePath) {
		//�������ϴ������
		List<FileUser> list = new ArrayList<FileUser>();
		POIFSFileSystem fs = null;
		 try {
			 fs=new POIFSFileSystem(new FileInputStream(filePath));
			 HSSFWorkbook wb = new HSSFWorkbook(fs); 
			//��ȡ�ڵ��ű��
			 HSSFSheet sheet = wb.getSheetAt(0); 
			 //��ȡ��
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
				// System.out.println("����˵ڣ� "+i+" ������");
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
		 System.out.println("������һ������� "+list.size()+" ������ļ���");
		 
		 return list;
	}
 
	/**
	 * �������з�װ�����ݴ�ŵ�HSSFWorkbook������
	 * 
	 * @param list
	 * @return workbook
	 */
	public static HSSFWorkbook getWorkBook(List<FileUser> list) {
		for (FileUser user : list) {
			System.out.println(user);
		}
		// �������������
		HSSFWorkbook workbook = new HSSFWorkbook();
		// �ڶ����д���һ����
		HSSFSheet sheet = workbook.createSheet("sheet0");
		// ��ȡ��ͷ
		String[] header = PoiUtils.getTabHeader();
		for (int i = 0; i < list.size() + 1; i++) {
			// ������i��
			HSSFRow row = sheet.createRow(i);
			// ���ñ�ͷ
			if (i == 0) {
				for (int j = 0; j < header.length; j++) {
					row.createCell(j).setCellValue(header[j]);
				}
			}
			// ������д��excel���
			else {
				// ��ȡ��������ֵ
				String[] userMsg = getUserMsg(list.get(i - 1));
				for (int j = 0; j < userMsg.length; j++) {
					row.createCell(j).setCellValue(userMsg[j]);
				}
			}
 
		}
		return workbook;
	}
 
	/**
	 * ����������ֵ���뵽string������
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
	 * �ṩ��ͷ
	 * 
	 * @return
	 */
	public static String[] getTabHeader() {
 
		String[] tabHeader = { "�û��ɣ�", "�û���", "����", "����ǩ��", "����", "����", "����" };
		return tabHeader;
 
	}
 
	/**
	 * ���������͵�����ת���ַ���
	 * 
	 * @param date
	 * @return date
	 */
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
		return sdf.format(date);
 
	}
 
	/**
	 * ���ַ������͵�����ת������
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
			throw new RuntimeException("ת��ʧ��");
		}
 
	}
}
