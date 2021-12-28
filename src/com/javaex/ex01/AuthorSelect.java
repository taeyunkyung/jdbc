package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorSelect {

	public static void main(String[] args) {

		List<AuthorVO> authorList = new ArrayList<AuthorVO>();

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
			query += "select  author_id id, ";
			query += "		  author_name, ";
			query += "        author_desc ";
			query += " from author ";

			// 문자열을 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);

			// 바인딩 - 생략

			// 실행
			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next() == true) {
				int authorId = rs.getInt("id");
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");

				 /*
				 int authorId = rs.getInt(1); 
				 String authorName = rs.getString(2); 
				 String authorDesc = rs.getString(3);
				 */

				AuthorVO vo = new AuthorVO(authorId, authorName, authorDesc);
				authorList.add(vo);

				// System.out.println(authorList.get(authorId) + ". " + authorName + ", " +
				// authorDesc);
			}

			// 출력
			for (int i = 0; i < authorList.size(); i++) {
				AuthorVO authorVo = authorList.get(i);
				System.out.println(
						authorVo.getAuthorId() + ". " + authorVo.getAuthorName() + ", " + authorVo.getAuthorDesc());
			}

			// 첫번째 작가 다시 출력
			AuthorVO author = authorList.get(0);
			System.out.println(author.getAuthorId() + ". " + author.getAuthorName() + ", " + author.getAuthorDesc());

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
