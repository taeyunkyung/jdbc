package com.javaex.ex07;

import java.util.List;

public class BookApp {

	public static void main(String[] args) {

		List<BookVo> list;
		BookDao bookDao = new BookDao();

		// 책 등록
		BookVo vo01 = new BookVo("우리들의 일그러진 영웅", "다림", "1998-02-22", 1);
		bookDao.bookInsert(vo01);
		
		BookVo vo02 = new BookVo("삼국지", "민음사", "2002-03-01", 1);		
		bookDao.bookInsert(vo02);
		
		BookVo vo03 = new BookVo("토지", "마로니에북스", "2012-08-15", 2);
		bookDao.bookInsert(vo03);				
				
		list = bookDao.bookSelect();
		for (int i = 0; i < list.size(); i++) {
			BookVo vo = list.get(i);
			System.out.println(vo.getBookId() + ". " + vo.getTitle() + ", " + vo.getPubs() + ", " + vo.getPubDate()
					+ ", " + vo.getAuthorId() + ", " + vo.getAuthorName() + ", " + vo.getAuthorDesc());
		}
		System.out.println("----------------------------------------");

		// 책 삭제
		bookDao.bookDelete(2);

		list = bookDao.bookSelect();
		for (int i = 0; i < list.size(); i++) {
			BookVo vo = list.get(i);
			System.out.println(vo.getBookId() + ". " + vo.getTitle() + ", " + vo.getPubs() + ", " + vo.getPubDate()
					+ ", " + vo.getAuthorId() + ", " + vo.getAuthorName() + ", " + vo.getAuthorDesc());
		}
		System.out.println("----------------------------------------");
		
		// 책 수정
		BookVo bookVo = new BookVo(3, "토지(수정)", "마로니에북스(수정)", "2012-08-15", 2);
		bookDao.bookUpdate(bookVo);

		list = bookDao.bookSelect();
		for (int i = 0; i < list.size(); i++) {
			BookVo vo = list.get(i);
			System.out.println(vo.getBookId() + ". " + vo.getTitle() + ", " + vo.getPubs() + ", " + vo.getPubDate()
					+ ", " + vo.getAuthorId() + ", " + vo.getAuthorName() + ", " + vo.getAuthorDesc());
		}
		System.out.println("----------------------------------------");

	}

}
