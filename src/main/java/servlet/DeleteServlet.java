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
import model.dao.DeleteDAO;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete-servlet")
public class DeleteServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /**
     * Getリクエストを受け付けてStockListを削除する
     */
    protected void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
    	// リクエストパラメータから削除するStockListのidを取得する
    	int id = Integer.parseInt(request.getParameter(Parameters.STOCKLIST_ID));

    	DeleteDAO dao = new DeleteDAO();
    	// StockListを削除する
    	try {
			dao.deleteStockList(id);
		} catch (ClassNotFoundException | SQLException | URISyntaxException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

    	response.sendRedirect("list-servlet");
    }
    
   
}
