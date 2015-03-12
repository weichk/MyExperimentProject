package com.eabax.test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

public class DESEncryptHelper {
	/**
	 * 获取密钥
	 * @return
	 * @throws InvalidKeySpecException
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 */
	public static SecretKey getDESKey() throws InvalidKeySpecException,
			InvalidKeyException, NoSuchAlgorithmException{
		SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
		DESKeySpec keyspec = new DESKeySpec("gasoftgasoftgaso".getBytes());
		SecretKey deskey = factory.generateSecret(keyspec);
		return deskey;
	}
	
	/**
	 * 对字符串加密 
	 * @param str
	 * @return
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 */
	public static String getEncryptStr(String str,String key) throws InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException,
			InvalidKeySpecException, NoSuchAlgorithmException,
			NoSuchPaddingException {
		//获取密钥
		SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
		DESKeySpec keyspec = new DESKeySpec(key.getBytes());
		SecretKey deskey = factory.generateSecret(keyspec);
		// Cipher负责完成加密或解密工作
		Cipher c = Cipher.getInstance("DES");
		// 根据密钥，对Cipher对象进行初始化，DECRYPT_MODE表示加密模式  
		c.init(Cipher.ENCRYPT_MODE, deskey);
		byte[] src = str.getBytes();
		// 该字节数组负责保存加密的结果
		byte[] cipherByte = c.doFinal(src);
		String enstr = new String(Base64.encodeBase64(cipherByte));
		return enstr;
	}
}
