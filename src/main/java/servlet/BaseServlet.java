package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constant.SessionInfo;

/**
 * Servlet implementation class BaseServlet
 */
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ユーザーIDを保持する
	 */
	private String UserId;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseServlet() {
        super();
    }

    /**
     * ログイン中のユーザーIDを取得する
     * @return
     */
    public String getLoginUserId() {
    	return UserId;
    }

	/**
	 * doPostメソッドを呼び出す
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * ログイン済みかどうかを判定する
	 * ログイン済みの場合各処理を実行
	 * ログインしていない場合ログイン画面に遷移する
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションからログイン中のユーザーIDを取得する
		HttpSession session = request.getSession();
		String loginUserId = (String)session.getAttribute(SessionInfo.LOGIN_USER_ID);

		// セッションにログイン中のユーザーIDが存在する時
		if (loginUserId != null) {
			try {
				UserId = loginUserId;
				exec(request, response);
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);;
		}
	}

	/**
	 * 各サーブレットの処理を記述する
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected abstract void exec(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ClassNotFoundException;
}