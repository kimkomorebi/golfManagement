package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBExpert {
	final private String driver ="oracle.jdbc.OracleDriver";
	final private String url ="jdbc:oracle:thin:@//localhost:1521/xe";
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	public ArrayList<GolfList> teacherPayList(){
		String select = "select t.teacher_code, t.class_name, t.teacher_name, to_char(sum(c.tuition), 'L999,999,999')"
				+ " from tbl_teacher_202201 t, tbl_class_202201 c"
				+ " where t.teacher_code = c.teacher_code"
				+ " group by t.teacher_code, t.class_name, t.teacher_name"
				+ " order by t.teacher_code asc";
		ArrayList<GolfList> list = new ArrayList<GolfList>();
		GolfList gl = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				gl = new GolfList();
				gl.setTeacher_code(rs.getString(1));
				gl.setClass_name(rs.getString(2));
				gl.setTeacher_name(rs.getString(3));
				gl.setSumPay(rs.getString(4));
				list.add(gl);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			}catch(Exception e) {}
		}
		return list;
	}
	
	public ArrayList<GolfList> memberInfoSearch(){
		String select = "select substr(c.regist_month,1,4)||'년'||substr(c.regist_month,5,2)||'월',"
				+ " c.c_no, m.c_name, t.class_name,"
				+ " c.class_area, to_char(c.tuition, 'L999,999,999,999'), m.grade"
				+ " from tbl_class_202201 c, tbl_member_202201 m, tbl_teacher_202201 t"
				+ " where c.c_no = m.c_no"
				+ " and t.teacher_code = c.teacher_code";
		ArrayList<GolfList> list = new ArrayList<GolfList>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GolfList gl = new GolfList();
				gl.setRegist_month(rs.getString(1));
				gl.setC_no(rs.getString(2));
				gl.setC_name(rs.getString(3));
				gl.setClass_name(rs.getString(4));
				gl.setClass_area(rs.getString(5));
				gl.setTuition_s(rs.getString(6));
				gl.setGrade(rs.getString(7));
				list.add(gl);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	public boolean putClassInfo(GolfList gl) {
		String insert = "insert into tbl_class_202201 values("
				+ "?,?,?,?,?)";
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, gl.getRegist_month());
			pstmt.setString(2, gl.getC_no());
			pstmt.setString(3, gl.getClass_area());
			pstmt.setInt(4, gl.getTuition());
			pstmt.setString(5, gl.getTeacher_code());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public ArrayList<String> getClassNameList(){//강의명 리스트 콤모박스
		String select="select class_name from tbl_teacher_202201";
		ArrayList<String> list = new ArrayList<String>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String nameList = rs.getString(1);
				list.add(nameList);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
				
		}
		return list;
	}
	public ArrayList<String> getClassAreaList(){//강의장소 리스트 콤모박스
		String select = "select distinct(class_area) from tbl_class_202201";
		ArrayList<String> list = new ArrayList<String>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String areaList = rs.getString(1);
				list.add(areaList);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
				
		}
		return list;
	}
	public ArrayList<String> getmemberList(){//회원명 리스트 콤모박스
		String select = "select c_name from tbl_member_202201";
		ArrayList<String> list = new ArrayList<String>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String memberList = rs.getString(1);
				list.add(memberList);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	public ArrayList<GolfList> getTeacherList(){
		String select = "select teacher_code, teacher_name, class_name, to_char(class_price, 'L999,999,999,999'),"
				+ " substr(teacher_regist_date,1,4)||'년'||substr(teacher_regist_date,5,2)||'월'||"
				+ " substr(teacher_regist_date,7,2)||'일'"
				+ " from tbl_teacher_202201"
				+ " order by teacher_code asc";
		ArrayList<GolfList> list = new ArrayList<GolfList>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GolfList gl = new GolfList();
				gl.setTeacher_code(rs.getString(1));
				gl.setTeacher_name(rs.getString(2));
				gl.setClass_name(rs.getString(3));
				gl.setS_class_price(rs.getString(4));
				gl.setTeacher_regist_date(rs.getString(5));
				list.add(gl);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
}
