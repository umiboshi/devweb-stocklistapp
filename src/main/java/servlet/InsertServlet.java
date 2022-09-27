package servlet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constant.Parameters;
import constant.SessionInfo;
import model.dao.InsertDAO;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert-servlet")
public class InsertServlet extends BaseServlet {
	
	/**
	 ログイン中のユーザーIDを保持する
	 */
	private String loginUserId;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		request.setCharacterEncoding("UTF-8");
		// リクエストパラメータのname属性がnameの値を受け取る
		String name = (String) request.getParameter(Parameters.NAME);
		// リクエストパラメータのname属性がnumberの値を受け取る
		int number = Integer.valueOf(request.getParameter(Parameters.NUMBER));
		// リクエストパラメータのname属性がmemoの値を受け取る
		String memo = (String) request.getParameter(Parameters.MEMO);
		// リクエストパラメータのname属性がupdateの値を受け取る
		Date update = Date.valueOf(request.getParameter(Parameters.UPDATE));
		
		// ログイン中のユーザーIDを取得する
		HttpSession session = request.getSession();
		loginUserId = (String)session.getAttribute(SessionInfo.LOGIN_USER_ID);

		// DAOを生成し、StockListをデータベースに登録する
		InsertDAO dao = new InsertDAO();
		
		try {
			dao.insertStocklist(name, number, memo, update, loginUserId);
		} catch (ClassNotFoundException | SQLException | URISyntaxException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		response.sendRedirect("list-servlet");
	}

}
