package com.zzh.demo;

public class NumToRMB {
	private String[] hanArr = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
	private String[] unitArr = { "十", "百", "千" };

	public String[] divide(double num) { // 将一个浮点数强制类型转换为long，即得到它的整数部分
		long zheng = (long) num; // 浮点数减去整数部分，得到小数部分，小数部分乘以100后再取整得到2位小数
		long xiao = Math.round((num - zheng) * 100);
		// 下面用了2种方法把整数转换为字符串
		return new String[] { zheng + "", String.valueOf(xiao) };
	}

	public String toHanStr(String numStr) {
		String result = "";
		int numLen = numStr.length();
		// 依次遍历数字字符串的每一位数字
		for (int i = 0; i < numLen; i++) {
			// 把char型数字转换成的int型数字，因为它们的ASCII码值恰好相差48
			// 因此把char型数字减去48得到int型数字，例如'4'被转换成4。
			int num = numStr.charAt(i) - 48;
			// 如果不是最后一位数字，而且数字不是零，则需要添加单位（千、百、十）
			if (i != numLen - 1 && num != 0) {
				result += hanArr[num] + unitArr[numLen - 2 - i];
			}
			// 否则不要添加单位
			else {
				result += hanArr[num];
			}
		}
		return result;
	}
}
