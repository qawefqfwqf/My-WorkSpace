package com.zzh.parser;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class ParseCnkiTest {

	@Test
	public void parseCnki() throws Exception {

		// 调用chrome driver
		System.setProperty("webdriver.chrome.driver",
				"D:/Software/Ordinary/上网工具/GoogleChrome/Application/chromedriver.exe");

		// 调用chrome
		WebDriver driver = new ChromeDriver();

		// 调整高度
		((ChromeDriver) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

		// 获取网址
		((ChromeDriver) driver).get("http://epub.cnki.net/KNS/brief/result.aspx?dbprefix=CMFD");

		// 高级搜索
		WebElement high = driver.findElement(By.xpath("//*[@id=\"1_3\"]/a"));
		high.click();
		Thread.sleep(1000);
		// 定位元素
		WebElement in = ((ChromeDriver) driver).findElementByName("txt_1_value1");

		// 定义搜索内容
		String searchWord = "";
		searchWord = "基因芯片";
		// 发送搜索内容
		in.sendKeys(searchWord);
		((ChromeDriver) driver).findElementByXPath("//*[@id='ddSubmit']/span").click();
		((ChromeDriver) driver).findElementByXPath("//*[@id='btnSearch']").click();
		Thread.sleep(2000);
		// 清除分类获得所有
		((ChromeDriver) driver).findElementByXPath("//*[@id='XuekeNavi_Div']/div[1]/input[1]").click();
		((ChromeDriver) driver).findElementByXPath("//*[@id='B']/span/img[1]").click();
		Thread.sleep(2000);

		// 分割符
		System.out.println("-----------------------");

		// 定位iframe
		WebElement iframe = driver.findElement(By.id("iframeResult"));

		// 也可直接这样写((ChromeDriver) driver).switchTo().frame("id=iframeResult");

		// 线程休眠
		Thread.sleep(2000);

		for (int i = 0; i < 10; i++) {
			// 获取窗口
			String now_handle = driver.getWindowHandle();
			Set<String> all_handles = driver.getWindowHandles();
			// 判断窗口是否一致
			for (String handle : all_handles) {
				if (handle != now_handle) {
					driver.switchTo().window(handle);
					((ChromeDriver) driver).switchTo().frame(iframe);

					// 选择50页
					WebElement btn = ((ChromeDriver) driver)
							.findElementByXPath("//*[@id=\"id_grid_display_num\"]/a[3]");
					btn.click();

					// 获取页面内容
					// String content=driver.getPageSource();
					// System.out.println(content);

					// 获取iframe元素内容直至tr
					List<WebElement> tb = driver.findElements(By.xpath("//*[@id=\"ctl00\"]/table/tbody/tr[2]"));
					for (WebElement t : tb) {
						List<WebElement> tbod = t.findElements(By.tagName("tbody"));
						for (WebElement tr : tbod) {
							List<WebElement> td = tr.findElements(By.tagName("tr"));
							td.remove(0);
							for (WebElement tds : td) {
								List<WebElement> tdss = tds.findElements(By.tagName("td"));
								String title = tdss.get(1).getText();
								String author = tdss.get(2).getText();
								String college = tdss.get(3).getText();
								String year = tdss.get(4).getText();
								System.out.println(title + "--" + author + "--" + college + "--" + year);
							}
						}

					}

				}
			}
			// 线程休眠
			Thread.sleep(1000);
			WebElement nextBtn = ((ChromeDriver) driver).findElementByXPath("//*[@id=\"Page_next\"]");
			nextBtn.click();
		}

		// 关闭driver
		driver.close();
	}

}
