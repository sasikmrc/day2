package org.method;

	import java.io.IOException;
	import java.util.List;

import org.global.LibGlobalCommonUpdate;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;

	public class AmazonPriceValid extends LibGlobalCommonUpdate {
		String name = null;
		String name1 = null;
		int sum = 0;

		@Test
		public void Search() throws IOException {
			getDriver();
			loadUrl("https://www.amazon.in/");
			maximize();
			type(driver.findElement(By.id("twotabsearchtextbox")), "iphone");
			click(driver.findElement(By.id("nav-search-submit-button")));
			click(driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")));
			click(driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]")));
			switchToParticularWindow(1);
			click(driver.findElement(By.id("add-to-cart-button")));
			switchToParticularWindow(2);
			click(driver.findElement(By.id("add-to-cart-button")));
			switchToParticularWindow(0);
			pageRefresh();
			click(driver.findElement(By.id("nav-cart-count")));
			// WebElement element4 =
			// driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base
			// sc-price sc-white-space-nowrap']"));
			String text = driver
					.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']"))
					.getText();
			System.out.println(text);
			String trim = text.trim();
			System.out.println(trim);
			String replace = trim.replace(",", "");
			System.out.println(replace);
			String replace1 = replace.replace(".00", "");
			System.out.println(replace1);
			int j = Integer.parseInt(replace1);
			
			List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']"));
			for (WebElement x : list) {
				String text2 = x.getText();
				System.out.println(text2);
				String trim1 = text2.trim();
				System.out.println(trim1);
				String replace2 = trim1.replace(",", "");
				String replace3 = replace2.replace(".00", "");
				System.out.println(replace3);
				int i = Integer.parseInt(replace3);
				sum = sum + i;

			}
			System.out.println(sum);
			Assert.assertEquals(sum, j);
			System.out.println("Add to cart Validated");
			
			List<WebElement> list1 = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']"));
			for (WebElement x : list) {
				String text2 = x.getText();
				System.out.println(text2);
				String trim1 = text2.trim();
				System.out.println(trim1);
				String replace2 = trim1.replace(",", "");
				String replace3 = replace2.replace(".00", "");
				System.out.println(replace3);
				int i = Integer.parseInt(replace3);
				sum = sum + i;

			}
			System.out.println(sum);
			Assert.assertEquals(sum, j);
			System.out.println("Add to cart Validated");
		}
		}

	}



