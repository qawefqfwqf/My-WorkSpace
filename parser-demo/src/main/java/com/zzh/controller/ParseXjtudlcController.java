package com.zzh.controller;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class ParseXjtudlcController {

	Logger logger = LoggerFactory.getLogger(getClass());

	// 验证码不正确重新登录次数
	private static int loginTimes = 0;
	// 异常导致重新登录次数
	private static int exceptionTimes = 0;

	private WebDriver driver = null;

	@GetMapping("/stop")
	public String stop() {
		driver.quit();
		logger.info("========================手动停止========================");
		return "index.html";
	}

	/**
	 * 抓取
	 * 
	 * @throws InterruptedException
	 */
	@GetMapping("/submit")
	public void parseXjtudlc(String username, String password, String chromedriverPath,
			@RequestParam(defaultValue = "1") String coursesNumber,
			@RequestParam(defaultValue = "1") String courseswareNumber) throws InterruptedException {

		try {

			// 调用chrome driver
			// D:/Software/浏览器/Google Chrome/chromedriver.exe
			System.setProperty("webdriver.chrome.driver", chromedriverPath + "/chromedriver.exe");

			// 调用chrome
			driver = new ChromeDriver();

			// 调整高度
			((ChromeDriver) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

			// 打开网站
			((ChromeDriver) driver).get("https://xueli.xjtudlc.com/login1.aspx");

			Thread.sleep(2000);

			// 填写表单并登录
			inputForm(driver, username, password, chromedriverPath);

			Thread.sleep(2000);

			// 登陆成功
			logger.info("========================登陆成功========================");
			// 转到对应的frame
			driver = driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"mainFrame\"]")));

			// 获取课程列表
			logger.info("========================获取课程列表========================");
			WebElement tbody_courses = driver.findElement(By.xpath("//*[@id=\"InCourse\"]/tbody"));

			List<WebElement> btn_courses_list_a = tbody_courses.findElements(By.tagName("a"));

			int course = 1;
			int coursesware = 1;
			for (int i = 0; i < btn_courses_list_a.size(); i++) {

				String href_courses = btn_courses_list_a.get(i).getAttribute("href");

				// 获取到的a标签中，有一半是积分页面的链接，不点进去
				if (!href_courses.contains("PointsDetailNew.aspx") && !href_courses.contains("CourseID=&nbsp;")) {

					// Integer.parseInt(coursesNumber) ==
					// course,则用户输入了选择课程，只有到选择的课程才进入到下一层：课件
					if (Integer.parseInt(coursesNumber) <= course) {

						JavascriptExecutor executor = (JavascriptExecutor) driver;
						executor.executeScript("window.open('" + href_courses + "')");

						// 获取目前所有标签
						ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
						driver = driver.switchTo().window(tabs.get(1));

						// 进入到课程中
						// btn_courses_list_a.get(i).click();

						Thread.sleep(2000);

						// 获取课件列表
						logger.info("========================获取课件列表========================");
						WebElement table_coursesware = driver.findElement(By.xpath("//*[@id=\"InCourse\"]"));
						List<WebElement> btn_coursesware_list_a = table_coursesware.findElements(By.tagName("a"));

						for (WebElement btn_coursesware_a : btn_coursesware_list_a) {

							String content_a = btn_coursesware_a.getText();

							// 获取到的a标签中，可能会有href属性中，“=”后是空的。这种不要
							if (content_a.contains("多码率")) {

								// Integer.parseInt(courseswareNumber) ==
								// coursesware,则用户输入了选择课程，只有到选择的课程才进入到下一层：课件
								if (Integer.parseInt(courseswareNumber) <= coursesware) {

									// 总共等待10秒， 如果10秒后，元素还不存在，就会抛出异常
									// org.openqa.selenium.NoSuchElementException
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									// 进入课件
									btn_coursesware_a.click();

									Thread.sleep(2000);

									// 获取目前所有标签
									tabs = new ArrayList<String>(driver.getWindowHandles());
									// 切换到视频列表所在标签
									driver = driver.switchTo().window(tabs.get(2));

									// 获取分页
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									WebElement div_pager = driver.findElement(By.xpath("//*[@id=\"pager\"]"));
									List<WebElement> btn_pager_list_a = div_pager.findElements(By.tagName("a"));

									int page = 0;

									while (true) {
										page++;
										// 获取视频列表
										logger.info("========================获取视频列表========================");
										WebElement ul_coursesware = driver.findElement(By.xpath("//*[@id=\"cslist\"]"));
										List<WebElement> btn_li_list_a = ul_coursesware.findElements(By.tagName("a"));

										int videos = 0;
										for (WebElement btn_coursesware_li : btn_li_list_a) {

											logger.info("========================打开视频========================");
											videos++;
											logger.info("========================看到了第" + course + "门课的第" + coursesware
													+ "个课件的第" + page + "页的第" + videos + "个视频========================");

											// 总共等待10秒，
											// 如果10秒后，元素还不存在，就会抛出异常NoSuchElementException
											driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
											// 打开视频
											btn_coursesware_li.click();

											Thread.sleep(4000);

											// 获取目前所有标签
											tabs = new ArrayList<String>(driver.getWindowHandles());

											// 切换到视频所在标签
											driver = driver.switchTo().window(tabs.get(3));

											// 获取播放按钮
											WebElement btn_play = driver
													.findElement(By.xpath("//*[@id=\"ck_player\"]"));

											// 点击播放按钮
											btn_play.click();

											// 每个视频播放时长
											Thread.sleep(1000 * 60 * 6);

											// 关闭当前标签页
											driver.close();

											Thread.sleep(2000);

											// 获取对话框并确定，如果有对话框的话
											try {
												Alert alert = driver.switchTo().alert();
												// 点击alert弹框的确定按钮
												alert.accept();
											} catch (Exception e) {
											}

											// 视频看完，切换回视频列表，重选视频
											// 切换到视频列表所在标签
											tabs = new ArrayList<String>(driver.getWindowHandles());
											driver = driver.switchTo().window(tabs.get(2));
											Thread.sleep(2000);

											logger.info("========================关闭视频========================");
										}

										Thread.sleep(2000);

										// 获取下一页按钮
										WebElement btn_next = null;
										for (int j = 0; j < btn_pager_list_a.size(); j++) {

											String text = btn_pager_list_a.get(j).getText();

											if ("下一页".equals(text)) {
												driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
												btn_next = btn_pager_list_a.get(j);
												break;
											}
										}

										if (btn_next == null) {
											break;
										} else {
											// 点击下一页
											btn_next.click();

											Thread.sleep(2000);

											// 重新获取视频列表
											ul_coursesware = driver.findElement(By.xpath("//*[@id=\"cslist\"]"));
											btn_li_list_a = ul_coursesware.findElements(By.tagName("a"));
											// 重新获取分页
											driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
											div_pager = driver.findElement(By.xpath("//*[@id=\"pager\"]"));
											btn_pager_list_a = div_pager.findElements(By.tagName("a"));
										}

									}

									// 本课件的视频列表都看完了，切换回课件列表，重选课件
									// 切换到课件列表所在标签
									driver.close();
									tabs = new ArrayList<String>(driver.getWindowHandles());
									driver = driver.switchTo().window(tabs.get(1));
									// driver = driver.switchTo()
									// .frame(driver.findElement(By.xpath("//*[@id=\"mainFrame\"]")));

									Thread.sleep(2000);

								}
								coursesware++;
							}
						}

						Thread.sleep(2000);
						// 本课程中的所有课件都看完了，切换回课程列表，重选课程
						// 转到对应的frame
						// driver.switchTo().defaultContent();
						// driver =
						// driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"topFrame\"]")));
						// WebElement btn_myCourse =
						// driver.findElement(By.xpath("//*[@id=\"Header\"]/ul/li[5]/a"));
						// btn_myCourse.click();
						driver.close();
						tabs = new ArrayList<String>(driver.getWindowHandles());
						driver = driver.switchTo().window(tabs.get(0));
						driver = driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"mainFrame\"]")));
						tbody_courses = driver.findElement(By.xpath("//*[@id=\"InCourse\"]/tbody"));
						btn_courses_list_a = tbody_courses.findElements(By.tagName("a"));
						Thread.sleep(2000);

					}
					course++;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			exceptionTimes++;
			logger.info("========================异常" + exceptionTimes + "次========================");
			// 关闭浏览器
			driver.quit();
			if (exceptionTimes <= 10) {
				// 启动浏览器重试
				Thread.sleep(2000);
				parseXjtudlc(username, password, chromedriverPath, coursesNumber, courseswareNumber);
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
	public void inputForm(WebDriver driver, String username, String password, String tessPath) throws Exception {
		if (loginTimes <= 10) {

			// 获取登录框
			WebElement input_loginName = driver.findElement(By.xpath("//*[@id=\"txtUserName\"]"));
			// 确保输入框中干净
			input_loginName.clear();
			// 登录框填写用户名
			input_loginName.sendKeys(username);

			Thread.sleep(1000);

			// 获取密码框
			WebElement input_password = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
			// 确保输入框中干净
			input_password.clear();
			// 密码框填写密码
			input_password.sendKeys(password);

			Thread.sleep(1000);

			// 下载验证码图片
			String imgPath = ImageDownload.getImg(driver);
			// 解析验证码
			String imgResult = ParseImageUtil.createByPost(imgPath, ParseXjtudlcController.class, logger, tessPath);
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
