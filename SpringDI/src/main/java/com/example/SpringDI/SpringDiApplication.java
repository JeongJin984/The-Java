package com.example.SpringDI;

import java.lang.reflect.*;
import java.util.Arrays;

public class SpringDiApplication {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
		Class<Book> bookClass = Book.class;
		Book book = new Book();
		Class<? extends Book> bookClass1 = book.getClass();
		Class<?> bookClass2 = Class.forName("com.example.SpringDI.Book");

		Arrays.stream(bookClass.getDeclaredFields()).forEach(f ->{
			try {
				f.setAccessible(true);
				System.out.printf("%s: %s\n", f, f.get(book));
			}catch (Exception e) {
				e.printStackTrace();
			}
		});
		/*						Heap의 Class 가져오기 					*/

		Class<?> bookClassR = Class.forName("com.example.SpringDI.Book");
		Constructor<?> constructor1 = bookClassR.getConstructor(null);
		Constructor<?> constructor2 = bookClassR.getConstructor(String.class, String.class, String.class);
		Book bookR1 = (Book)constructor1.newInstance();
		Book bookR2 = (Book)constructor2.newInstance("D", "E", "F");

		Field d = Book.class.getDeclaredField("d");
		System.out.println(d.get(book));

		Field b = Book.class.getDeclaredField("b");
		b.setAccessible(true);
		System.out.println(b.get(null)); // static이므로 인스턴스를 넘겨줄 필요가 없다(공유)
		b.set(null, "asdfasdf");
		System.out.println(b.get(null));

		Method sum = Book.class.getDeclaredMethod("sum", int.class, int.class);
		int invoke = (int) sum.invoke(book, 1,2);
		System.out.println(invoke);
		/*							Class 수정하기								*/




	}

}
