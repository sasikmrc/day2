package org.test.day2;

import java.io.IOException;

import org.method.LibGlobalCommon;

public class BookConfirmation {
	public static void main(String[] args) throws InterruptedException, IOException {
		LibGlobalCommon z = new LibGlobalCommon();
		AddactinHotel hotel = new AddactinHotel();
		hotel.login(z.excelRead(1, 0), z.excelRead(1, 1));
		hotel.searchHotel(z.excelRead(1, 2), z.excelRead(1, 3), z.excelRead(1, 4));
		hotel.selectHotel();
		hotel.bookHotel(z.excelRead(1, 6), z.excelRead(1, 7), z.excelRead(1, 8), z.excelRead(1, 9), z.excelRead(1, 10),
				z.excelRead(1, 11), z.excelRead(1, 12), z.excelRead(1, 13));
		Thread.sleep(15000);
		String name1 = hotel.bookingConfrim();
		System.out.println(name1);

	}

}
