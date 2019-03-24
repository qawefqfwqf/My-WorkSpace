package com.zzh.parser;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.zzh.utils.ImageDownload;
import com.zzh.utils.ParseImageUtil;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class ParseXjtudlcTest {

	private static int time = 0;

	@Test
	public void parseXjtudlc() throws InterruptedException {
		time++;

		WebDriver driver = null;

		try {

			// 调用chrome driver
			System.setProperty("webdriver.chrome.driver",
					"D:/Software/Ordinary/上网工具/GoogleChrome/Application/chromedriver.exe");

			// 调用chrome
			driver = new ChromeDriver();

			// 调整高度
			((ChromeDriver) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

			// 打开网站
			((ChromeDriver) driver).get("https://xueli.xjtudlc.com/login1.aspx");

			Thread.sleep(2000);

			// 填写表单并登录
			inputForm(driver);

			Thread.sleep(2000);

			// 登陆成功
			// 获取我的课程按钮
			WebElement btn_myCourse = driver.findElement(By.xpath("//*[@id=\"Header\"]/ul/li[5]/a"));
			// 点击我的课程按钮
			btn_myCourse.click();

			// 获取课程url列表
			WebElement tbody_courses = driver.findElement(By.xpath("//*[@id=\"InCourse\"]/tbody"));
			List<WebElement> tag_list_a = tbody_courses.findElements(By.tagName("a"));

			for (WebElement tag_a : tag_list_a) {
				String href = "https://xueli.xjtudlc.com/StudentCenter/" + tag_a.getAttribute("href");

			}

			// // 高级搜索
			// WebElement high =
			// driver.findElement(By.xpath("//*[@id=\"1_3\"]/a"));
			// high.click();
			// Thread.sleep(1000);
			// // 定位元素
			// WebElement in = ((ChromeDriver)
			// driver).findElementByName("txt_1_value1");
			//
			// // 定义搜索内容
			// String searchWord = "";
			// searchWord = "基因芯片";
			// // 发送搜索内容
			// in.sendKeys(searchWord);
			// ((ChromeDriver)
			// driver).findElementByXPath("//*[@id='ddSubmit']/span").click();
			// ((ChromeDriver)
			// driver).findElementByXPath("//*[@id='btnSearch']").click();
			// Thread.sleep(2000);
			// // 清除分类获得所有
			// ((ChromeDriver)
			// driver).findElementByXPath("//*[@id='XuekeNavi_Div']/div[1]/input[1]").click();
			// ((ChromeDriver)
			// driver).findElementByXPath("//*[@id='B']/span/img[1]").click();
			// Thread.sleep(2000);
			//
			// // 分割符
			// System.out.println("-----------------------");
			//
			// // 定位iframe
			// WebElement iframe = driver.findElement(By.id("iframeResult"));
			//
			// // 也可直接这样写((ChromeDriver)
			// driver).switchTo().frame("id=iframeResult");
			//
			// // 线程休眠
			// Thread.sleep(2000);
			//
			// for (int i = 0; i < 10; i++) {
			// // 获取窗口
			// String now_handle = driver.getWindowHandle();
			// Set<String> all_handles = driver.getWindowHandles();
			// // 判断窗口是否一致
			// for (String handle : all_handles) {
			// if (handle != now_handle) {
			// driver.switchTo().window(handle);
			// ((ChromeDriver) driver).switchTo().frame(iframe);
			//
			// // 选择50页
			// WebElement btn = ((ChromeDriver) driver)
			// .findElementByXPath("//*[@id=\"id_grid_display_num\"]/a[3]");
			// btn.click();
			//
			// // 获取页面内容
			// // String content=driver.getPageSource();
			// // System.out.println(content);
			//
			// // 获取iframe元素内容直至tr
			// List<WebElement> tb =
			// driver.findElements(By.xpath("//*[@id=\"ctl00\"]/table/tbody/tr[2]"));
			// for (WebElement t : tb) {
			// List<WebElement> tbod = t.findElements(By.tagName("tbody"));
			// for (WebElement tr : tbod) {
			// List<WebElement> td = tr.findElements(By.tagName("tr"));
			// td.remove(0);
			// for (WebElement tds : td) {
			// List<WebElement> tdss = tds.findElements(By.tagName("td"));
			// String title = tdss.get(1).getText();
			// String author = tdss.get(2).getText();
			// String college = tdss.get(3).getText();
			// String year = tdss.get(4).getText();
			// System.out.println(title + "--" + author + "--" + college + "--"
			// +
			// year);
			// }
			// }
			//
			// }
			//
			// }
			// }
			// // 线程休眠
			// Thread.sleep(1000);
			// WebElement nextBtn = ((ChromeDriver)
			// driver).findElementByXPath("//*[@id=\"Page_next\"]");
			// nextBtn.click();
			// }
			//
			// // 关闭driver
			// driver.close();

		} catch (Exception e) {
			driver.close();
			if (time <= 10) {
				Thread.sleep(2000);
				parseXjtudlc();
			}
		} finally {
			driver.close();
		}
	}

	public void inputForm(WebDriver driver) throws Exception {
		// 获取登录框
		WebElement input_loginName = driver.findElement(By.xpath("//*[@id=\"txtUserName\"]"));
		// 确保输入框中干净
		input_loginName.clear();
		// 登录框填写用户名
		input_loginName.sendKeys("18092653533");

		Thread.sleep(1000);

		// 获取密码框
		WebElement input_password = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
		// 确保输入框中干净
		input_password.clear();
		// 密码框填写密码
		input_password.sendKeys("zzh789512357");

		Thread.sleep(1000);

		// 下载验证码图片
		String imgPath = ImageDownload.getImg(driver);
		// 解析验证码
		String imgResult = ParseImageUtil.createByPost(imgPath, ParseXjtudlcTest.class);
		// 获取验证码框
		WebElement input_txtVerifyCode = driver.findElement(By.xpath("//*[@id=\"txtVerifyCode\"]"));
		// 确保输入框中干净
		input_txtVerifyCode.clear();
		// 填写验证码
		input_txtVerifyCode.sendKeys(imgResult);

		Thread.sleep(1000);

		// 获取登录按钮
		WebElement btn_login = driver.findElement(By.xpath("//*[@id=\"lbtnLogin\"]"));
		// 点击登录按钮
		btn_login.click();

		Thread.sleep(1000);

		// 如果验证码错误
		Alert alert = null;
		try {
			alert = driver.switchTo().alert();
			Thread.sleep(1000);
			// 点击alert弹框的确定按钮
			alert.accept();
			// 再次填写表单并登录
			inputForm(driver);
		} catch (NoAlertPresentException e) {
			System.out.println("========================登陆成功========================");
		}

	}

}
