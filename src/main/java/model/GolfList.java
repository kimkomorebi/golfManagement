package model;

public class GolfList {
	private String teacher_code;//강사코드
	private String teacher_name;//강사명
	private String class_name;//강의명
	private Integer class_price;//수강료(정수)
	private String s_class_price;//수강료(문자열)
	private String teacher_regist_date;//강사자격취득일
	
	private String regist_month;//수강월
	private String c_no;//회원번호
	private String class_area;//강의장소
	private Integer tuition;//수강료
	private String tuition_s;//수강료(문자열)
	//강사 코드
	
	//수강월 String regist_month
	//회원번호 String c_no
	private String c_name;//회원명
	//강의명 String class_name
	//강의장소 String class_area
	//수강료 문자열 String tuition_s
	private String grade;//등급
	
	//강사코드 String teacher_code
	//강의명 String class_name
	//강사명 String teacher_name
	private String sumPay;//총매출
	
	public String getSumPay() {
		return sumPay;
	}
	public void setSumPay(String sumPay) {
		this.sumPay = sumPay;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getTeacher_code() {
		return teacher_code;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getRegist_month() {
		return regist_month;
	}
	public void setRegist_month(String regist_month) {
		this.regist_month = regist_month;
	}
	public String getC_no() {
		return c_no;
	}
	public void setC_no(String c_no) {
		this.c_no = c_no;
	}
	public String getClass_area() {
		return class_area;
	}
	public void setClass_area(String class_area) {
		this.class_area = class_area;
	}
	public Integer getTuition() {
		return tuition;
	}
	public void setTuition(Integer tuition) {
		this.tuition = tuition;
	}
	public String getTuition_s() {
		return tuition_s;
	}
	public void setTuition_s(String tuition_s) {
		this.tuition_s = tuition_s;
	}
	public void setTeacher_code(String teacher_code) {
		this.teacher_code = teacher_code;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public Integer getClass_price() {
		return class_price;
	}
	public void setClass_price(Integer class_price) {
		this.class_price = class_price;
	}
	public String getS_class_price() {
		return s_class_price;
	}
	public void setS_class_price(String s_class_price) {
		this.s_class_price = s_class_price;
	}
	public String getTeacher_regist_date() {
		return teacher_regist_date;
	}
	public void setTeacher_regist_date(String teacher_regist_date) {
		this.teacher_regist_date = teacher_regist_date;
	}
}
