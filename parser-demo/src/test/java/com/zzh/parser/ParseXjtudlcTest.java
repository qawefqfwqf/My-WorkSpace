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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ParseXjtudlcTest {

	private static int time = 0;

	/**
	 * 抓取
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void parseXjtudlc() throws InterruptedException {
		time++;

		WebDriver driver = null;

		try {

			// 调用chrome driver
			System.setProperty("webdriver.chrome.driver", "D:/Software/Ordinary/上网工具/GoogleChrome/Application/chromedriver.exe");

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
			// 转到对应的frame
			driver = driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"mainFrame\"]")));

			// 获取课程列表
			WebElement tbody_courses = driver.findElement(By.xpath("//*[@id=\"InCourse\"]/tbody"));

			List<WebElement> btn_courses_list_a = tbody_courses.findElements(By.tagName("a"));

			for (WebElement btn_courses_a : btn_courses_list_a) {
				// 进入到课程中
				btn_courses_a.click();

				Thread.sleep(2000);

				// 获取课件列表
				WebElement table_coursesware = driver.findElement(By.xpath("//*[@id=\"InCourse\"]"));

				List<WebElement> btn_coursesware_list_a = table_coursesware.findElements(By.tagName("a"));

				for (WebElement btn_coursesware_a : btn_coursesware_list_a) {
					// 总共等待10秒， 如果10秒后，元素还不存在，就会抛出异常
					// org.openqa.selenium.NoSuchElementException
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					// 进入课件
					btn_coursesware_a.click();

					Thread.sleep(2000);

					// 打开了一个新的标签页
					// 获取所有标签页
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

					// 切换到新的标签页
					driver = driver.switchTo().window(tabs.get(1));

					WebElement ul_coursesware = driver.findElement(By.xpath("//*[@id=\"cslist\"]"));

					List<WebElement> btn_li_list_a = ul_coursesware.findElements(By.tagName("a"));

					for (WebElement btn_coursesware_li : btn_li_list_a) {

//						// 总共等待10秒， 如果10秒后，元素还不存在，就会抛出异常
//						// org.openqa.selenium.NoSuchElementException
//						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//						// 打开视频
//						btn_coursesware_li.click();
//
//						Thread.sleep(2000);
//
//						// 打开了一个新的标签页
//						tabs = new ArrayList<String>(driver.getWindowHandles());
//
//						// 切换到新的标签页
//						driver = driver.switchTo().window(tabs.get(2));
//
//						// 获取播放按钮
//						WebElement btn_play = driver.findElement(By.xpath("//*[@id=\"ck_player\"]"));
//
//						// 点击播放按钮
//						btn_play.click();
//
//						Thread.sleep(2000);
//
//						// 关闭当前标签页
//						driver.close();
//
//						Thread.sleep(2000);
//
//						// 获取对话框并确定，如果有对话框的话
//						try {
//							Alert alert = driver.switchTo().alert();
//							// 点击alert弹框的确定按钮
//							alert.accept();
//						} catch (Exception e) {
//						}
//
//						// 切换到新的标签页
//						driver = driver.switchTo().window(tabs.get(1));
					}

				}
			}

		} catch (Exception e) {
			driver.quit();
			if (time <= 10) {
				Thread.sleep(2000);
				parseXjtudlc();
			}
		} finally {
			driver.quit();
		}
	}

	/**
	 * 提交表单的公共方法
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public void inputForm(WebDriver driver) throws Exception {
		if (time <= 10) {

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

}
