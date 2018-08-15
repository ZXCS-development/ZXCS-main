package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import service.AdminService;


/**
 * ��־����
 * 	��־�ڳ��������ļ�Ŀ¼���ļ���logs�У�����ر�֤���ļ��д��ڲ����п�дȨ��
 * @author pcshao
 * 
 */
public class LogMark {
	
	private static String pathname = System.getProperty("user.dir");	//��ȡ��ǰ��������·��
	private static String pattern = "yyyy-MM-dd HH:mm:ss";				//��־���ڸ�ʽ
	private static File file;
	private static PrintWriter pw;
	private static SimpleDateFormat sdf,fdf;
	
	static {
		//��ʽ����ʼ��
		sdf = new SimpleDateFormat(pattern);
		fdf = new SimpleDateFormat("yyMMdd");
		//��־��ʼ�ļ���ʼ��
		file = new File(pathname+"\\logs\\"+fdf.format(new Date())+".log");
		try {
			if(!file.exists())
				file.createNewFile();
			pw = new PrintWriter(new FileOutputStream(file,true));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void LogWrite(String content) {
		//��־�ݶ�Ϊ	��ǰϵͳ����Ա����̨orPOS��+��־����
		String log = AdminService.admin.getName()+content;
		pw.println(addDate()+log);
		pw.flush();
	}
	public static void LogWrite(String content ,Boolean loginOperate) {
		pw.println(addDate()+content);
		pw.flush();
	}
	
	private static String addDate() {
		return sdf.format(new Date())+" ";
	}
	
}
