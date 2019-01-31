/**
 * 
 */
package com.wdq.yun.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName: MD5
 * @Description: MD5加密类
 * @author http://liaohong.me
 * @date 2014年12月29日 下午7:37:39
 */
public class MD5 {

	private static char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	public static String byteToHex(byte ib) {
		char[] ob = new char[2];
		ob[0] = digit[(ib >>> 4) & 0X0F];
		ob[1] = digit[ib & 0X0F];
		String s = new String(ob);
		return s;
	}

	public static String md5(String src) {
		return md5(src.getBytes());
	}

	public static String md5(byte[] bb) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(bb);
			byte[] b = md.digest();
			String str = "";
			for (int i = 0; i < b.length; i++) {
				str += byteToHex(b[i]);
			}
			return str;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}
