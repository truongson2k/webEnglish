package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import BEAN.slidebanner;



public class HomeDAO {
	private Connection connection;
	 public static  List<slidebanner> Displaysliderbanner(Connection conn)
	 {
		 List<slidebanner> list =new ArrayList<slidebanner>();
		 String sql="select *from slidebanner";
		 try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			
			while(rs.next()) {
				slidebanner slide=new slidebanner();
		
				String slidename =rs.getString("slidename");
				String slidecontent=rs.getString("slidecontent");
				String slideimage=rs.getString("slideimage");
				slide.setSlidename(slidename);
				slide.setSlidecontent(slidecontent);
				slide.setSlideimage(slideimage);
				list.add(slide);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
		 
	 }
	 

}
 