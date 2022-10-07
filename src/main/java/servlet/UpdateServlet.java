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
    	try {
			stocklist = dao.getStockList(stocklistId);
		} catch (ClassNotFoundException | SQLException | URISyntaxException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

    	request.setAttribute("stocklist", stocklist);
    	request.getRequestDispatcher("update.jsp").forward(request, response);
    }
    
    protected void getPostRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
    	// リクエストパラメータから値を取得する
    	request.setCharacterEncoding("UTF-8");
    	int id = Integer.parseInt(request.getParameter(Parameters.STOCKLIST_ID));
    	String name =replaceEscapeChar((String) request.getParameter(Parameters.NAME));
    	int number = Integer.parseInt(request.getParameter(Parameters.NUMBER));
    	String memo = replaceEscapeChar((String) request.getParameter(Parameters.MEMO));
    	Date update = Date.valueOf(request.getParameter(Parameters.UPDATE));

    	// DAOを生成し、StockListを更新する
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
    
    //replaceEscapeCharクラス
	 //概要：文字列データのエスケープを行う
	private String replaceEscapeChar(String val) {
		if (val == null) return "";
	       val = val.replaceAll("&", "& amp;");
	       val = val.replaceAll("<", "& lt;");
	       val = val.replaceAll(">", "& gt;");
	       val = val.replaceAll("\"", "&quot;");
	       val = val.replaceAll("'", "&apos;");
	       return val;
	     }

}