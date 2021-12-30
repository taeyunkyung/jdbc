package com.javaex.ex08;

import java.util.List;
import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		
		List<AuthorVo> list;
		AuthorDao authorDao = new AuthorDao();

		List<BookVo> bookList;
		BookDao bookDao = new BookDao();
		
		// 작가등록
		AuthorVo vo01 = new AuthorVo("이문열", "경북 영양");
		authorDao.authorInsert(vo01);

		AuthorVo vo02 = new AuthorVo("박경리", "경남 통영");
		authorDao.authorInsert(vo02);

		AuthorVo vo03 = new AuthorVo("주호민", "네이버웹툰");
		authorDao.authorInsert(vo03);

		AuthorVo vo04 = new AuthorVo("강풀", "온라인 만화가 1세대");
		authorDao.authorInsert(vo04);

		AuthorVo vo05 = new AuthorVo("김영하", "알쓸신잡");
		authorDao.authorInsert(vo05);

		AuthorVo vo06 = new AuthorVo("이고잉", "IT");
		authorDao.authorInsert(vo06);

		// 확인
		list = authorDao.authorSelect();
		for (int i = 0; i < list.size(); i++) {
			AuthorVo vo = list.get(i);
			System.out.println(vo.getAuthorId() + ". " + vo.getAuthorName());
		}

		// 책등록
		BookVo bo01 = new BookVo("우리들의 일그러진 영웅", "다림", "1998-02-22", 1);
		bookDao.bookInsert(bo01);

		BookVo bo02 = new BookVo("삼국지", "민음사", "2002-03-01", 1);
		bookDao.bookInsert(bo02);

		BookVo bo03 = new BookVo("토지", "마로니에북스", "2012-08-15", 2);
		bookDao.bookInsert(bo03);

		BookVo bo04 = new BookVo("자바프로그래밍 입문", "위키북스", "2015-04-01", 6);
		bookDao.bookInsert(bo04);

		BookVo bo05 = new BookVo("신과 함께", "재미주의", "2020-08-20", 3);
		bookDao.bookInsert(bo05);

		BookVo bo06 = new BookVo("순정만화", "재미주의", "2011-08-03", 4);
		bookDao.bookInsert(bo06);

		BookVo bo07 = new BookVo("오직 두 사람", "문학동네", "2017-05-04", 5);
		bookDao.bookInsert(bo07);

		BookVo bo08 = new BookVo("26년", "재미주의", "2012-02-04", 4);
		bookDao.bookInsert(bo08);

		// 확인
		bookList = bookDao.bookSelect();
		for (int i = 0; i < bookList.size(); i++) {
			BookVo bo = bookList.get(i);
			System.out.println(bo.getBookId() + ". " + bo.getTitle());

		}
		
		// 검색
		Scanner sc = new Scanner(System.in);
		boolean run = true;

		System.out.println("******************************");
		System.out.println("*         도서검색시스템          *");
		System.out.println("******************************");

		while (run) {
			System.out.print(">이름: ");
			String keyword = sc.nextLine();

			if (keyword.equals("q/")) {
				run = false;

			} else {
				bookList = bookDao.search(keyword);
				for (int i = 0; i < bookList.size(); i++) {
					BookVo bo = bookList.get(i);
					System.out.println(bo.getBookId() + ". " + bo.getTitle() + ", " + bo.getPubs() + ", "
							+ bo.getPubDate() + ", " + bo.getAuthorName());
				}

				System.out.println("검색되었습니다." + "\n");
			}
		}

		System.out.println("종료되었습니다.");
		sc.close();

	}

}
