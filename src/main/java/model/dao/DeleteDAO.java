package model.dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DBConnection;

public class DeleteDAO {

	/**
	 * StockListを削除する
	 * @return 削除した行数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws URISyntaxException 
	 */
	public int deleteStockList(int id) throws SQLException, ClassNotFoundException, URISyntaxException {
		int processingNumber = 0;

		// SQL文
		String sql = "DELETE FROM stocklist WHERE id = ?";

		// DBに接続し、Listを削除する
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			// idを設定する
			pstmt.setInt(1, id);

			// SQLを実行する
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
}