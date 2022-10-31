package servlet;


import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.StockListDAO;
import model.dao.dto.StockRecordDTO;

/**
 * Servlet implementation class ListSarvlet
 */
@WebServlet("/list-servlet")
public class ListServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // STOCKLIST Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void exec(HttpServletRequest request, HttpServletResponse response)
    		throws  ServletException, IOException, SQLException, ClassNotFoundException {
    	// StockListの一覧を保持する変数を宣言
    	List<StockRecordDTO> stocklist = new ArrayList<>();

    	// DAOを生成しStockRecord一覧を取得する
    	StockListDAO dao = new StockListDAO();

		// StockRecord一覧を取得する
		try {
			stocklist = dao.getStockList(request);
		} catch (ClassNotFoundException | SQLException | URISyntaxException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	
    	// StockListをリクエストスコープに設定する
    	request.setAttribute("stockList",stocklist);
    	// StockList一覧画面に遷移する
    	RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
    	rd.forward(request, response);
    }

}
