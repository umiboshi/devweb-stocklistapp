package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
                // データベースのURL
		final String URL = "jdbc:postgresql://ec2-35-170-146-54.compute-1.amazonaws.com:5432/d1s9jdrdm88fph";
                // データベースにアクセスするユーザー
		final String USER =  "rmoovgurggvnbx";
                // パスワード
		final String PASSWORD = "335236b8ac0ac13a1b0092b17278eaab98cee48111f479afea8573a243b2592d";

		Class.forName("org.postgresql.Driver");
		
                // データベースへ接続する
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		
		return con;
	}
}