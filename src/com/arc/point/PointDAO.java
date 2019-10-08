package com.arc.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.arc.util.DBConnector;

public class PointDAO {

	//id, pw로 해당 학생의 점수를 조회
	public void table() {
		Connection con = null;
		PreparedStatement st = null;
		String yId = null;
		String yPw = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ID를 입력");
		yId = sc.next();
		System.out.println("PW를 입력");
		yPw = sc.next();
		
		try {
			con = DBConnector.getConnect();
			
			String sql = "select * from point "
					+ "where num = (select num from member "
					+ "where id = ? and pw = ?)";
			
			st = con.prepareStatement(sql);
			st.setString(1, yId);
			st.setString(2, yPw);
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	
}
