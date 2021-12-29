package com.javaex.ex02;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {

		AuthorDao authorDao = new AuthorDao();

		authorDao.authorInsert("이문열", "경북 영양");
		authorDao.authorInsert("박경리", "경남 통영");
		authorDao.authorInsert("유시민", "17대 국회의원");

		// authorDao.authorUpdate("박경리(수정)", "토지 작가", 4);
		// authorDao.authorDelete(3);

		List<AuthorVo> authorList = authorDao.authorSelect();

		for (int i = 0; i < authorList.size(); i++) {
			AuthorVo authorVo = authorList.get(i);
			System.out.println(
					authorVo.getAuthorId() + ". " + authorVo.getAuthorName() + ", " + authorVo.getAuthorDesc());
		}
	}

}
