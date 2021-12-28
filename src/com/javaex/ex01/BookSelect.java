package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelect {

	public static void main(String[] args) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL문 준비 / 바인딩 / 실행
			// 문자열 만들기
			String query = "";
			query += "select  book_id, ";
			query += "		  title, ";
			query += "        pubs, ";
			query += "        to_char(pub_date, 'YYYY-MM-DD') pubdate, ";
			query += "        author_id ";
			query += " from book ";
			query += " order by book_id asc";

			// 문자열을 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);

			// 바인딩 - 생략

			// 실행
			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next() == true) {
				int bookId = rs.getInt("book_id");
				String Title = rs.getString("title");
				String Pubs = rs.getString("pubs");
				String pubDate = rs.getString("pubdate");
				int authorId = rs.getInt("author_id");

				System.out.println(bookId + ". " + Title + ", " + Pubs + ", " + pubDate + ", " + authorId);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		}

	}

}
