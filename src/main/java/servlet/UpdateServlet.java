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

import constant.Parameters;
import model.CharCheck;
import model.dao.UpdateDAO;
import model.dao.dto.StockRecordDTO;

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
			stocklistId = Integer.parseInt(request.getParameter(Parameters.STOCKRECORD_ID));
		} catch (NumberFormatException e) {
			request.getRequestDispatcher("list-servlet").forward(request, response);
		}

    	UpdateDAO dao = new UpdateDAO();
    	StockRecordDTO stocklist = new StockRecordDTO();
    
    	// StockListの取得
    	try {
			stocklist = dao.getStockRecord(stocklistId);
		} catch (ClassNotFoundException | SQLException | URISyntaxException e) {
			// STOCKLIST 自動生成された catch ブロック
			e.printStackTrace();
		}

    	request.setAttribute("stocklist", stocklist);
    	request.getRequestDispatcher("update.jsp").forward(request, response);
    }
    
    protected void getPostRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
    	// リクエストパラメータから値を取得する
    	request.setCharacterEncoding("UTF-8");
    	int id = Integer.parseInt(request.getParameter(Parameters.STOCKRECORD_ID));
    	String name =CharCheck.replaceEscapeChar((String) request.getParameter(Parameters.NAME));
    	int number = Integer.parseInt(request.getParameter(Parameters.NUMBER));
    	String memo = CharCheck.replaceEscapeChar((String) request.getParameter(Parameters.MEMO));
    	Date update = Date.valueOf(request.getParameter(Parameters.UPDATE));

    	// DAOを生成し、StockRecordを更新する
    	UpdateDAO dao = new UpdateDAO();
  
    	// 受け取ったパラメータを元にデータベースを更新する
    	try {
			dao.updateStockList(id, name, number, memo, update);
		} catch (ClassNotFoundException | SQLException | URISyntaxException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

    	response.sendRedirect("list-servlet");
    }
    

}