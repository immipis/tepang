package com.tepang.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	
		public Connection conn = null;
		public PreparedStatement psmt;
		public ResultSet rs;
			
			
			public void disConnect() {
				try {
					if(conn != null)
						conn.close();
					if(psmt != null)
						psmt.close();
					if(rs != null)
						rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			public Connection getConn() {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드
					
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "tepang", "tepang");
				} catch (Exception e) {
					System.out.println("연결중 에러");
					e.printStackTrace(); 
				}
				return conn; 
			}
}
