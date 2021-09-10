package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
//	public static Connection CreateConnection ()
//	{
//		Connection conn =null;
//		String url="jdbc:mysql://localhost:3306/webEnglish ";
//		String username="root";
//		String password="112358";
//		try {
//			
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("url","username","password");
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//     
	 private static String url = "jdbc:mysql://localhost:3306/webenglish";
	    private static String username = "root";
	    private static String password = "112358@son";
//	    private static String url = "jdbc:mysql://node237650-truong.j.layershift.co.uk/webenglish?characterEncoding=UTF-8";
//	    private static String username = "root";
//	    private static String password = "XTIxox42559";
	 
	 public static Connection getConnection() {
		 Connection conn = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	           // Class.forName("com.mysql.jdbc.Driver");
	            
				conn = DriverManager.getConnection(url, username, password);
	          
	        } catch (Exception ex) {
	            System.out.println("connect failure!");
	            ex.printStackTrace();
	        }
	        return conn;
    }
//	private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
//            + "databaseName=webenglish;"
//            + "integratedSecurity=true";
//    private static String USER_NAME = "sa";
//    private static String PASSWORD = "truongson2k";
// 
// public static Connection getConnection() {
//	 Connection conn = null;
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            
//			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
//          
//        } catch (Exception ex) {
//            System.out.println("connect failure!");
//            ex.printStackTrace();
//        }
//        return conn;
//    }
// 
	
	 public static void disconnect() throws SQLException {
		 Connection conn = null;
	        if (conn != null && !conn.isClosed()) {
	            conn.close();
	        }
	    }

}
