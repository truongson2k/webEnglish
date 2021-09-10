package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import BEAN.Grammarguideline;
public class BaihdnguphapDAO {
	
public static List<Grammarguideline> Displaygrammar(int start,int count,Connection conn) throws SQLException{
	List<Grammarguideline> list= new ArrayList<Grammarguideline>();
	String sql= "SELECT * FROM grammar LIMIT "+(start-1)+", "+count+"";
	PreparedStatement ptmt= conn.prepareStatement(sql);
	ResultSet rs=ptmt.executeQuery();
	while (rs.next()) {
		Grammarguideline grammarguideline= new Grammarguideline();
		int idgrammar=rs.getInt("idgrammar");
		String grammarname= rs.getString("grammarname");
		String grammarimage = rs.getString("grammarimage");
		
		grammarguideline.setIdgrammar(idgrammar);
		grammarguideline.setGrammarname(grammarname);
		grammarguideline.setGrammarimage(grammarimage);
	   list.add(grammarguideline);    
	}

	return list;
}
public static int Countrow(Connection conn) throws SQLException {
	int count=0;
	String sql = "select count(*) from grammar";
	PreparedStatement ptmt= conn.prepareStatement(sql);
	ResultSet rs=ptmt.executeQuery();
	rs.next();
	count= rs.getInt(1);
	
	return count;
	
}
public static String Displaygrammarcontent(Connection conn,int ma) throws SQLException{
	String content="";
	String sql= "SELECT * FROM Grammar where idgrammar="+ma;
	PreparedStatement ptmt= conn.prepareStatement(sql);
	ResultSet rs=ptmt.executeQuery();
	while (rs.next()) {
	
		 content=rs.getString("content");
		
	}

	return content;
}
public static String Displaygrammarname(Connection conn,int ma) throws SQLException{
	String grammarname="";
	String sql= "SELECT * FROM Grammar where idgrammar="+ma;
	PreparedStatement ptmt= conn.prepareStatement(sql);
	ResultSet rs=ptmt.executeQuery();
	while (rs.next()) {
	
		grammarname=rs.getString("grammarname");
		
	}

	return grammarname;
}
}
