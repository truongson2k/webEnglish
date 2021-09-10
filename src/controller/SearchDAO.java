package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import BEAN.Grammarguideline;

public class SearchDAO {
	public static  List<Grammarguideline> Displayresult(HttpServletRequest request,Connection conn,String name) throws SQLException
	 {
		 List<Grammarguideline> list =new ArrayList<Grammarguideline>();
		 String sql="select * from grammar where grammarname like '%"+name+"%'";
	
	try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			if(!rs.isBeforeFirst()) {
				request.setAttribute("ketqua","Không có kết quả");
			}
			else {
				while(rs.next())
				{
					Grammarguideline grammarguideline = new Grammarguideline();
					int idgrammar = rs.getInt("idgrammar");
					String grammarname= rs.getString("grammarname");
					String grammarimage= rs.getString("grammarimage");
					
					grammarguideline.setIdgrammar(idgrammar);
					grammarguideline.setGrammarname(grammarname);
					grammarguideline.setGrammarimage(grammarimage);
					
					list.add(grammarguideline);
				}
			}
	}
			catch(SQLException e)
			{
				request.setAttribute("ketqua",e.getMessage());
			}
			
			return list;
			}
}
