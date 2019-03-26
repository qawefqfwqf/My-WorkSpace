package com.zzh.utils;

import java.io.File;
import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.springframework.util.ResourceUtils;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * 解析图片验证码的工具类
 * 
 * @author zzh
 *
 */
public class ParseImageUtil {

	public static String createByPost(String imgPath, Class clazz, Logger logger, String tessPath)
			throws TesseractException, FileNotFoundException {
		File imageFile = new File(imgPath);
		ITesseract instance = new Tesseract();// 调用Tesseract
		// URL url = ClassLoader.getSystemResource("tessdata");//获得Tesseract的文字库
		// String path = clazz.getClass().getResource("/").getPath();
		// path = path.substring(1, path.indexOf("/target") + 7);
		// String tesspath = path + "/classes/static/tessdata";
		// String tesspath =
		// ResourceUtils.getURL("classpath:static/tessdata").getPath();
		// tesspath = tesspath.substring(tesspath.indexOf("/") + 1);
		tessPath = tessPath + "/tessdata";
		logger.info("读取Tesseract的文字库位置：" + tessPath);
		// 进行读取，默认是英文，如果要使用中文包，加上instance.setLanguage("chi_sim");
		instance.setDatapath(tessPath);
		String result = null;
		result = instance.doOCR(imageFile);
		result = result.replaceAll("[^a-z^A-Z^0-9]", "");// 替换大小写及数字
		return result;
	}

}
