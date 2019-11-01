package com.zzh.controller;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zzh.utils.ImageDownload;
import com.zzh.utils.ParseImageUtil;

@Controller
public class AutoLoginController {

	Logger logger = LoggerFactory.getLogger(getClass());

	// 验证码不正确重新登录次数
	private static int loginTimes = 0;
	// 异常导致重新登录次数
	private static int exceptionTimes = 0;

	private WebDriver driver = null;

	@GetMapping("/autologin")
	public void autologin() throws Exception {

		String chromedriverPath = "D:/Software/Programmer/Tools/Google/Chrome/Application";
		String username = "Zzh18092653533";
		String password = "zzh789512357";

		// 调用chrome driver
		// D:/Software/浏览器/Google Chrome/chromedriver.exe
		System.setProperty("webdriver.chrome.driver", chromedriverPath + "/chromedriver.exe");

		// 调用chrome
		driver = new ChromeDriver();

		// 调整高度
		((ChromeDriver) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

		// 打开网站
		((ChromeDriver) driver).get("http://server3.cdce.cn/student/default.aspx");

		Thread.sleep(2000);

		// 填写表单并登录
		inputForm(driver, username, password, chromedriverPath);

		Thread.sleep(2000);

		// 登陆成功
		logger.info("========================登陆成功========================");
	}

	/**
	 * 提交表单的公共方法
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public void inputForm(WebDriver driver, String username, String password, String tessPath) throws Exception {
		if (loginTimes <= 10) {

			// 获取登录框
			WebElement input_loginName = driver.findElement(By.xpath("//*[@id=\"txtEmail\"]"));
			// 确保输入框中干净
			input_loginName.clear();
			// 登录框填写用户名
			input_loginName.sendKeys(username);

			Thread.sleep(1000);

			// 获取密码框
			WebElement input_password = driver.findElement(By.xpath("//*[@id=\"txtPWD\"]"));
			// 确保输入框中干净
			input_password.clear();
			// 密码框填写密码
			input_password.sendKeys(password);

			Thread.sleep(1000);

			// 下载验证码图片
			String imgPath = ImageDownload.getImg(driver);
			// 解析验证码
			String imgResult = ParseImageUtil.createByPost(imgPath, AutoLoginController.class, logger, tessPath);
			// 获取验证码框
			WebElement input_txtVerifyCode = driver.findElement(By.xpath("//*[@id=\"txtCheck\"]"));
			// 确保输入框中干净
			input_txtVerifyCode.clear();
			// 填写验证码
			input_txtVerifyCode.sendKeys(imgResult);

			Thread.sleep(1000);

			// 获取登录按钮
			WebElement btn_login = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
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

				loginTimes++;

				inputForm(driver, username, password, tessPath);
			} catch (NoAlertPresentException e) {
				logger.info("========================验证码不正确，导致重新登陆" + loginTimes + "次========================");
			}

		} else {
			exceptionTimes = loginTimes;
			driver.quit();
		}

	}

}
