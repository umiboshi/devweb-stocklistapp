package servlet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Parameters;
import model.dao.AddUserDAO;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/addUser-servlet")
public class AddUserServlet extends HttpServlet {
   
	/**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // STOCKLIST Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	// リクエストパラメーターのname属性からloginIdを受け取る
    	String id = (String) request.getParameter(Parameters.LOGIN_ID);
    	// リクエストパラメーターのname属性からpasswordを受け取る
    	String password = (String) request.getParameter(Parameters.LOGIN_PASSWORD);
    	
    	
    	//idまたはpasswordが空白の場合
    	if((id =="")||(password=="")) {
    		response.sendRedirect("adduser.jsp");
    	}else {

    	// DAOを生成し、ユーザー情報を登録
    	AddUserDAO dao = new AddUserDAO();
    	try {
    		dao.addUser(id, password);

    	}catch(SQLException | ClassNotFoundException | URISyntaxException e) {
    		e.printStackTrace();
    	}

    	response.sendRedirect("login.jsp");
    	
    	}
    }
    	
}
