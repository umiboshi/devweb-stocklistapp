package model.dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DBConnection;

/**
 * stocklistをデータベースに登録するクラス
 */
public class InsertDAO {

	/**
	 * stocklistをデータべースに登録する
	 *
	 * @param name
	 * @param number
	 * @param memo
	 * @param update
	 * @param loginUserId
	 * @return 登録数
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws URISyntaxException 
	 */
	public int insertStocklist(String name, int number, String memo, Date update, String loginUserId)throws ClassNotFoundException, SQLException, URISyntaxException {
		// 更新した行数を返却するための変数
		int processingNumber = 0;

		// 実行するSQL
		String sql = "INSERT INTO stocklist (name, number, memo, update, userid) VALUES (?, ?, ?, ?, ?);";

		// SQLを実行する
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			// パラメータに値を設定する
			// 1つ目のパラメータにnameの内容を設定
			pstmt.setString(1,name);
			// 2つ目のパラメータにnumberの内容を設定
			pstmt.setInt(2, number);
			// 3つ目のパラメータにmemoの内容を設定
			pstmt.setString(3, memo);
			// 4つ目のパラメータにupdateの内容を設定
			pstmt.setDate(4, update);
			// 5つ目のパラメータにuserIdの内容を設定
			pstmt.setString(5, loginUserId);
			// SQLを実行し、実行行数を受け取る
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
}