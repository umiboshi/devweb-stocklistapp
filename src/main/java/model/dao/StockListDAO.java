package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DBConnection;
import model.dao.dto. StockListDTO;

/**
 * StockListの一覧を取得するクラス
 *
 */
public class StockListDAO {

	/**
	 * Listの一覧を取得する
	 * @return listの一覧
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<StockListDTO> getStockList() throws ClassNotFoundException, SQLException {
		// 返却用Listの初期化
		List<StockListDTO> stockList = new ArrayList<>();

		// 実行するSQL
		String sql = "SELECT * from stocklist;";

		// DBに接続し、Todo一覧を取得する
		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// SQLを実行しResultSetの変数に結果を格納する
			ResultSet res = pstmt.executeQuery();
			// 実行結果を順番に取り出す
			while (res.next()) {
			        //それぞれid, name, number, memo, update, userIdを取得する
				int id = res.getInt("id");
				String name = res.getString("name");
				int number = res.getInt("number");
				String memo = res.getString("memo");
				Date update = res.getDate("update");
				String userId = res.getString("userId");

				//取得したid, name, number, memo, update, userIdでStockListDTOを初期化してstockListに追加
				stockList.add(new StockListDTO(id, name, number, memo, update ,userId));
			
		           
			}
		}
	            	            
		return stockList;
	}
	            
		 
	}