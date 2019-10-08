package com.arc.point;

import java.util.Scanner;

public class SchoolMain {

	public static void main(String[] args) {
		// id, pw 입력
		// 출력

		Scanner sc = new Scanner(System.in);
		PointDAO pointDAO = new PointDAO();
		PointDTO pointDTO = new PointDTO();
		
		
		System.out.println("ID 입력");
		String id = sc.next();
		System.out.println("PW 입력");
		String pw = sc.next();
		
		pointDTO = pointDAO.getPoint(id, pw); //return 값을 pointDTO로 받아줘야 함!
		
		
		System.out.println("NUM : "+pointDTO.getNum());
		System.out.println("NAME : "+pointDTO.getName());
		System.out.println("KOR : "+pointDTO.getKor());
		System.out.println("ENG : "+pointDTO.getEng());
		System.out.println("MATH : "+pointDTO.getMath());
		System.out.println("TOTAL : "+pointDTO.getTotal());
		System.out.println("AVG : "+pointDTO.getAvg());
	
		
		
		
		System.out.println("학생번호 입력");
		pointDTO.setNum(sc.nextInt());
		System.out.println("이름 입력");
		pointDTO.setName(sc.next());
		System.out.println("국어 점수 입력");
		pointDTO.setKor(sc.nextInt());
		System.out.println("영어 점수 입력");
		pointDTO.setEng(sc.nextInt());
		System.out.println("수학 점수 입력");
		pointDTO.setMath(sc.nextInt());
		
		
		
	
	}
	
	
	

}
