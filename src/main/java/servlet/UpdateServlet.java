package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Parameters;
import model.dao.UpdateDAO;
import model.dao.dto.StockListDTO;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update-servlet")
public class UpdateServlet extends BaseServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
    }
    
    @Override
	protected void exec(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ClassNotFoundException {
		// メソッドの取得
		String method = request.getMethod();

		if (method.equals("GET")) {
			getGetRequest(request, response);
		} else if (method.equals("POST")) {
			getPostRequest(request, response);
		}
	}

    protected void getGetRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
    	// リクエストパラメータからStockListIdを取得する
		int stocklistId = 0;
		try {
			stocklistId = Integer.parseInt(request.getParameter(Parameters.STOCKLIST_ID));
		} catch (NumberFormatException e) {
			request.getRequestDispatcher("list-servlet").forward(request, response);
		}

    	UpdateDAO dao = new UpdateDAO();
    	StockListDTO stocklist = new StockListDTO();
    
    	// StockListの取得
    	stocklist = dao.getStockList(stocklistId);

    	request.setAttribute("stocklist", stocklist);
    	request.getRequestDispatcher("update.jsp").forward(request, response);
    }
    
    protected void getPostRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
    	// リクエストパラメータから値を取得する
    	request.setCharacterEncoding("UTF-8");
    	int id = Integer.parseInt(request.getParameter(Parameters.STOCKLIST_ID));
    	String name = request.getParameter(Parameters.NAME);
    	int number = Integer.parseInt(request.getParameter(Parameters.NUMBER));
    	String memo = request.getParameter(Parameters.MEMO);
    	Date update = Date.valueOf(request.getParameter(Parameters.UPDATE));

    	// DAOを生成し、StockListを更新する
    	UpdateDAO dao = new UpdateDAO();
  
    	// 受け取ったパラメータを元にデータベースを更新する
    	dao.updateStockList(id, name, number, memo, update);

    	response.sendRedirect("list-servlet");
    }
}