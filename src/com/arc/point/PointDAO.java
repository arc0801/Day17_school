package com.arc.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.arc.util.DBConnector;

public class PointDAO {
	
	private Connection con;
	private PreparedStatement st;
	private ResultSet rs;
	private PointDTO pointDTO;
	private String sql;
	private int result;
	
	public PointDAO() {
		con = null;
		st = null;
		rs = null;
		sql = null;
		result = 0;
	}
	
	
	//정보를 삭제 delete
	public int deletePoint(int num) {
		try {
			con = DBConnector.getConnect();
			
			sql = "delete point where num = ?";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, num);
			
			result = st.executeUpdate();
			
			if(result>0) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	//정보를 추가 insert
	public int insertPoint(PointDTO pointDTO) {
		try {
			con = DBConnector.getConnect();
			
			sql = "insert into point(num, name, kor, eng, math, total, avg) "
					+ "values (?, ?, ?, ?, ?, ?, ?)";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, pointDTO.getNum());
			st.setString(2, pointDTO.getName());
			st.setInt(3, pointDTO.getKor());
			st.setInt(4, pointDTO.getEng());
			st.setInt(5, pointDTO.getMath());
			st.setInt(6, pointDTO.getTotal());
			st.setDouble(7, pointDTO.getAvg());
			
			result = st.executeUpdate();
			
			if(result==1) {
				System.out.println("입력 성공");
			}else {
				System.out.println("입력 실패");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	
	//id, pw로 해당 학생의 점수를 조회
	public PointDTO getPoint(String id, String pw) {
		try {
			con = DBConnector.getConnect(); //접속
			
			sql = "select * from point " //쿼리문 작성
					+ "where num = (select num from member "
					+ "where id = ? and pw = ?)";
			
			st = con.prepareStatement(sql); //sql문 미리 보내기~
			
			st.setString(1, id); //?에 값 대입
			st.setString(2, pw);
			
			rs = st.executeQuery(); //sql문 미리 보냈으니까 ?값만 보내면 됨
			
			if(rs.next()) { //데이터를 꺼내서 다른 곳으로 보내줘야되니 return을 쓴다
				//데이터는 여러 개인데 return은 한 개만 가능하므로 DTO에 담아준다!
				pointDTO = new PointDTO(); //객체 생성!
				pointDTO.setNum(rs.getInt("num")); //DTO에 담아준다
				pointDTO.setName(rs.getString("name"));
				pointDTO.setKor(rs.getInt("kor"));
				pointDTO.setEng(rs.getInt("eng"));
				pointDTO.setMath(rs.getInt("math"));
				pointDTO.setTotal(rs.getInt("total"));
				pointDTO.setAvg(rs.getDouble("avg"));
			}else {
				System.out.println("로그인 실패");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pointDTO;
	}
}
