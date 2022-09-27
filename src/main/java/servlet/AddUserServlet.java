package servlet;

import java.io.IOException;
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
    	// ���N�G�X�g�p�����[�^��name������loginId�̒l���󂯎��
    	String id = (String) request.getParameter(Parameters.LOGIN_ID);
    	// ���N�G�X�g�p�����[�^��name������password�̒l���󂯎��
    	String password = (String) request.getParameter(Parameters.LOGIN_PASSWORD);
    	
    	
    	//idまたはpasswordが空白の場合
    	if((id =="")||(password=="")) {
    		response.sendRedirect("adduser.jsp");
    	}else {

    	// DAOを生成し、ユーザー情報を登録
    	AddUserDAO dao = new AddUserDAO();
    	try {
    		// �󂯎�����p�����[�^�������ɓn��
    		dao.addUser(id, password);

    	}catch(SQLException | ClassNotFoundException e) {
    		e.printStackTrace();
    	}

    	response.sendRedirect("login.jsp");
    	
    	}
    }
    	
}
