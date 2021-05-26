package TOOLSS;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entities.student;
import dao.CredentialC;


/**
 * Servlet implementation class Auth
 */
@WebServlet("/Auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Auth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		student u=new student();
		u=null;
		String lg=request.getParameter("login");
		String ps=request.getParameter("password");
		u=CredentialC.Authentification(lg, ps);
		 if(u != null)
		   {
			   HttpSession ses = request.getSession(true);
	           ses.setAttribute("student",u);
			   response.sendRedirect("index.jsp");
		   }else
			   {
			   	response.sendRedirect("authenification.jsp?res=err");
			   }
	}

}
