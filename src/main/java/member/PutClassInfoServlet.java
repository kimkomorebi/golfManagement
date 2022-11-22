package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBExpert;
import model.GolfList;

/**
 * Servlet implementation class PutClassInfoServlet
 */
@WebServlet("/putClassInfo.do")
public class PutClassInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PutClassInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String regist_month = request.getParameter("REGIST_MONTH");
		String c_name = request.getParameter("C_NAME");
		String c_no = request.getParameter("C_NO");
		String class_area = request.getParameter("CLASS_AREA");
		String class_name = request.getParameter("CLASS_NAME");
		String tuition = request.getParameter("TUITION");
		
		GolfList gl = new GolfList();
		gl.setRegist_month(regist_month);
		gl.setC_no(c_no);
		gl.setClass_area(class_area);
		gl.setTeacher_code(class_name);
		gl.setTuition(Integer.parseInt(tuition));
		DBExpert dbe = new DBExpert();
		boolean result = dbe.putClassInfo(gl);
		if(result) {
			response.sendRedirect("putClassInfoResult.jsp?R=Y");
		}else {
			response.sendRedirect("putClassInfoResult.jsp?R=N");
		}
	}

}
