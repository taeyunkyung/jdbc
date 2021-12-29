package com.javaex.ex02;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {

		AuthorDao authorDao = new AuthorDao();
		List<AuthorVo> list; 

		// 작가등록
		authorDao.authorInsert("이문열", "경북 영양");
		authorDao.authorInsert("박경리", "경남 통영");
		authorDao.authorInsert("유시민", "17대 국회의원");
		
		list = authorDao.authorSelect();
		for (int i = 0; i < list.size(); i++) {
			AuthorVo authorVo = list.get(i);
			System.out.println(
					authorVo.getAuthorId() + ". " + authorVo.getAuthorName() + ", " + authorVo.getAuthorDesc());
		}
		System.out.println("------------------------------");
		
		// 작가수정
		authorDao.authorUpdate("박경리(수정)", "토지 작가", 2);
		
		list = authorDao.authorSelect();
		for (int i = 0; i < list.size(); i++) {
			AuthorVo authorVo = list.get(i);
			System.out.println(
					authorVo.getAuthorId() + ". " + authorVo.getAuthorName() + ", " + authorVo.getAuthorDesc());
		}
		System.out.println("------------------------------");
		
		// 작가삭제
		authorDao.authorDelete(3);

		list = authorDao.authorSelect();
		for (int i = 0; i < list.size(); i++) {
			AuthorVo authorVo = list.get(i);
			System.out.println(
					authorVo.getAuthorId() + ". " + authorVo.getAuthorName() + ", " + authorVo.getAuthorDesc());
		}
		System.out.println("------------------------------");
	}

}
