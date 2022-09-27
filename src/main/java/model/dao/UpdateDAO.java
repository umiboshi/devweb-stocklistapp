package model.dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;
import model.dao.dto.StockListDTO;

// StockListの更新を行うクラス
public class UpdateDAO {

	/**
	 * idを元にStockListから情報を取得する
	 * @param id
	 * @return stocklist
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws URISyntaxException 
	 */
	public StockListDTO getStockList(int id) throws SQLException, ClassNotFoundException, URISyntaxException {
		// 取得したStockListを格納する変数
		StockListDTO stocklist = new StockListDTO();

		// Idを指定してStockListを取得するSQL
		String sql = "SELECT id, name, number, memo, update FROM stocklist where id = ? ;";

		// DBに接続し、StockListを取得する
		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, id);

			// SQLを実行しStockListを取得する
			ResultSet res = pstmt.executeQuery();

			while(res.next()) {
				// DBから取得したStockListの情報をstocklistに持たせる
				stocklist.setId(res.getInt("id"));
				stocklist.setName(res.getString("name"));
				stocklist.setNumber(res.getInt("number"));
				stocklist.setMemo(res.getString("memo"));
				stocklist.setUpdate(res.getDate("update"));
			}
		}

		return stocklist;

	}
	
	/**
	 * StockListデータを更新する
	 * @param name
	 * @param number
	 * @param memo
	 * @param update
	 * @return 更新行数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws URISyntaxException 
	 */
	public int updateStockList(int id, String name, int number, String memo, Date update) throws SQLException, ClassNotFoundException, URISyntaxException {
		// 変更した行数を返却するための変数
		int processingNumber = 0;

		// SQLを作成
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE ");
		sql.append("    stocklist ");
		sql.append(" SET ");
		sql.append("    name = ? ");
		sql.append(",   number = ? ");
		sql.append(",   memo = ? ");
		sql.append(",   update = ? ");
		sql.append(" WHERE ");
		sql.append("    id = ? ");

		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql.toString())) {
			// パラメータに値を設定する
			pstmt.setString(1, name);
			pstmt.setInt(2, number);
			pstmt.setString(3, memo);
			pstmt.setDate(4, update);
			pstmt.setInt(5, id);

			// SQLを実行し、実行行数を受け取る
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
}