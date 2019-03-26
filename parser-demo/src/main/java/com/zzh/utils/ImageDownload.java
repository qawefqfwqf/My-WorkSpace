package com.zzh.utils;

import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImageDownload {

	public static String getImg(WebDriver driver) throws IOException {

		String imgPath = "E:/图片/验证码/test.png";
		double a = 1;

		WebElement ele = driver.findElement(By.xpath("//*[@id=\"VerifyCode\"]"));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Get entire page screenshot
		BufferedImage fullImg = ImageIO.read(screenshot);
		// Get the location of element on the page
		org.openqa.selenium.Point point = ele.getLocation();
		// Get width and height of the element
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();
		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot = fullImg.getSubimage((int) (point.getX() * a), (int) (point.getY() * a),
				(int) (eleWidth * a), (int) (eleHeight * a));
		ImageIO.write(eleScreenshot, "png", screenshot);
		// Copy the element screenshot to disk
		File screenshotLocation = new File(imgPath);
		FileUtils.copyFile(screenshot, screenshotLocation);

		return imgPath;

	}

}
