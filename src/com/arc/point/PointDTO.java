package com.arc.point;

public class PointDTO {

	// 접근지정자 private
	// 데이터타입 table의 컬럼과 동일
	// Number(전체자릿수, 소수점자릿수)
	// Number(3) : int, long
	// Number(4, 2) : float, double
	// Varchar2() : String
	// Date : java.sql.Date, String
	// CLOB : String
	// 변수명 table의 컬럼과 동일
	
	private String name;
	private int num;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	
}
