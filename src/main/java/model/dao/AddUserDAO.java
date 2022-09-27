package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DBConnection;

public class AddUserDAO {
	
	/**
	 * 新規ユーザーの追加
	 *
	 * @param id
	 * @param password
	 * @return 登録数
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int addUser(String id, String password)throws ClassNotFoundException, SQLException {
		// 更新した行数を返却するための変数
		int processingNumber = 0;

		// 実行するSQL
		String sql = "INSERT INTO users (id, password) VALUES (?, ?);";

		// SQLを実行する
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			// パラメータに値を設定する
			// 1つ目のパラメータにidの内容を設定
			pstmt.setString(1,id);
			// 2つ目のパラメータにpasswordの内容を設定
			pstmt.setString(2, password);
			// SQLを実行し、実行行数を受け取る
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}

}
