package com.zzh.utils;

import java.io.File;
import java.net.URL;

import org.junit.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ParseImageUtil {

	public static String createByPost(String imgPath, Class clazz) throws TesseractException {
		File imageFile = new File(imgPath);
		ITesseract instance = new Tesseract();// 调用Tesseract
		// URL url = ClassLoader.getSystemResource("tessdata");//获得Tesseract的文字库
		String path = clazz.getClass().getResource("/").getPath();
		path = path.substring(1, path.indexOf("/target") + 7);
		String tesspath = path + "/classes/static/tessdata";
		instance.setDatapath(tesspath);// 进行读取，默认是英文，如果要使用中文包，加上instance.setLanguage("chi_sim");
		String result = null;
		result = instance.doOCR(imageFile);
		result = result.replaceAll("[^a-z^A-Z^0-9]", "");// 替换大小写及数字
		System.out.println("========================解析验证码结果：" + result + "========================");
		return result;
	}

}
