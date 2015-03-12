package com.eabax.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadHTMLUtil {

	public static void main(String[] args) throws UnsupportedEncodingException {
		HashMap<String, String> map = getFromYahoo("http://www.blogjava.net/rabbit/archive/2008/03/27/189009.html");
		System.out.println(map.get("title"));
	}

	/**
	 * 
	 * @param s
	 * @return 获取雅虎知识堂文章标题及内容
	 * @throws UnsupportedEncodingException 
	 */
	public static HashMap<String, String> getFromYahoo(final String htmlUrl) throws UnsupportedEncodingException {
		final HashMap<String, String> hm = new HashMap<String, String>();
		String html = "";
		try {
			html = getOneHtml(htmlUrl);
		} catch (final Exception e) {
			e.getMessage();
		}
		String title = outTag(getTitle(html));
		title = changeCharset(title,"utf-8");
		hm.put("title", title.trim());
		return hm;
	}

	/**
	 * 读取一个网页全部内容
	 */
	private static String getOneHtml(final String htmlurl) throws IOException {
		URL url;
		String temp;
		final StringBuffer sb = new StringBuffer();
		try {
			url = new URL(htmlurl);
			final BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream(), "utf-8"));// 读取网页全部内容
			while ((temp = in.readLine()) != null) {
				sb.append(temp);
			}
			in.close();
		} catch (final MalformedURLException me) {
			System.out.println("你输入的URL格式有问题！请仔细输入");
			me.getMessage();
			throw me;
		} catch (final IOException e) {
			e.printStackTrace();
			throw e;
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param s
	 * @return 获得网页标题
	 */
	private static String getTitle(final String s) {
		String regex;
		String title = "";
		final List<String> list = new ArrayList<String>();
		regex = "<title>.*?</title>";
		final Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ);
		final Matcher ma = pa.matcher(s);
		while (ma.find()) {
			list.add(ma.group());
		}
		for (int i = 0; i < list.size(); i++) {
			title = title + list.get(i);
		}
		return outTag(title);
	}

	/**
	 * 
	 * @param s
	 * @return 去掉标记
	 */
	private static String outTag(final String s) {
		return s.replaceAll("<.*?>", "");
	}
	
	/**
	 * 转化
	 * @param str
	 * @param newCharset
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static  String changeCharset(String str, String newCharset)
			throws UnsupportedEncodingException {
		if (str != null) {
			// 用默认字符编码解码字符串。
			byte[] bs = str.getBytes();
			// 用新的字符编码生成字符串
			return new String(bs, newCharset);
		}
		return null;
	}
}
