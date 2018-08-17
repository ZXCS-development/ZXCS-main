package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

/**
<<<<<<< HEAD
 * Êý¾Ý¿â¹¤¾ßÀà Ìá¹©Á½¸ö·½·¨£º
 * 	1¡¢getConnection() 		·µ»ØÁ¬½Ó¶ÔÏó
 * 	2¡¢closeConnection(...) 	¹Ø±ÕÊý¾Ý¿âÁ¬½Ó¶ÔÏó
=======
 * éç‰ˆåµæ´æ’³ä¼éé£Žè¢« éŽ»æ„ªç·µæ¶“ã‚„é‡œé‚è§„ç¡¶é”›ï¿½
 * 	1éŠ†ä¹¬etConnection() 		æ©æ–¿æ´–æ©ç‚´å¸´ç€µç¡…è–„
 * 	2éŠ†ä¹§loseConnection(...) 	éæŠ½æ£´éç‰ˆåµæ´æ’¹ç¹›éŽºãƒ¥î‡®ç’žï¿½
>>>>>>> 6dd593c1424aa73fdb5bc1d17e9cc1c9ffb26e0c
 */
public class DataBaseUtil {
  //String url="jdbc:oracle:thin:@localhost:1521:orcl";
	String url="jdbc:oracle:thin:@192.168.123.207:1521:orcl";
	//String url="jdbc:oracle:thin:@172.16.4.100:1521:orcl";
	String urlMysql="jdbc:mysql://pcshao.cn:9910/zxcs?useSSL=false&autoReconnect=true&characterEncoding=UTF-8";
	private static String user = "zxcsadmin";
	private static String password = "123";
	private static String mysqlDriver = "com.mysql.jdbc.Driver";
	private static String oracleDriver = "oracle.jdbc.driver.OracleDriver";
	
	static{
		try{
			Class.forName(oracleDriver);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println(new DataBaseUtil().getConnection());
	}
<<<<<<< HEAD
	//»ñµÃÁ¬½Ó¶ÔÏó
=======
	//é‘¾å³°ç·±æ©ç‚´å¸´ç€µç¡…è–„
>>>>>>> 6dd593c1424aa73fdb5bc1d17e9cc1c9ffb26e0c
	public Connection getConnection(){
		try{
			return DriverManager.getConnection(url, user, password);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
<<<<<<< HEAD
	//¹Ø±ÕÏà¹Ø¶ÔÏó
=======
	//éæŠ½æ£´é©ç¨¿å§ç€µç¡…è–„
>>>>>>> 6dd593c1424aa73fdb5bc1d17e9cc1c9ffb26e0c
	public void closeConnection(Connection conn, PreparedStatement pstat){
		closeDBObject(conn);
		closeDBObject(pstat);
	}
	public void closeConnection(Connection conn, Statement stat){
		closeDBObject(conn);
		closeDBObject(stat);
	}
	public void closeConnection(Connection conn, PreparedStatement pstat, ResultSet rs){
		closeDBObject(conn);
		closeDBObject(pstat);
		closeDBObject(rs);
	}
	public void closeConnection(Connection conn, Statement stat, ResultSet rs){
		closeDBObject(conn);
		closeDBObject(stat);
		closeDBObject(rs);
	}
	public void closeDBObject(Connection conn){
		if(conn!=null){
			try{
				conn.close();
			}catch(SQLException e){}
		}
	}
	public void closeDBObject(PreparedStatement pstat){
		if(pstat!=null){
			try{
				pstat.close();
			}catch(SQLException e){}
		}
	}
	public void closeDBObject(Statement stat){
		if(stat!=null){
			try{
				stat.close();
			}catch(SQLException e){}
		}
	}
	public void closeDBObject(ResultSet rs){
		if(rs!=null){
			try{
				rs.close();
			}catch(SQLException e){}
		}
	}
}
