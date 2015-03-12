package myProject;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;

public class Test13 {
	private final static String DES = "DES";
	public static void main(String[] args) throws IOException, Exception {
		System.out.println(getEncryptStr("18696725229", "DJ43FF9A"));
		System.out.println(decrypt("y5zM++vj4sBmvxpQtl3AMg==", "DJ43FF9A"));
		System.out.println(ReVerifyRegexTeilPhone("18702303667"));
	}
	 /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws IOException,
            Exception {
        if (data == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf,key.getBytes());
        return new String(bt);
    }
	/**
	 * 验证手机号码和电话号码
	 * @param teliphone
	 * @return
	 */
	public static boolean ReVerifyRegexTeilPhone(String teliphone) {
		boolean b = false;
		Pattern p = Pattern
				.compile("1([\\d]{10})|((\\+[0-9]{2,4})?\\(?[0-9]+\\)?-?)?[0-9]{7,8}");
		if (teliphone != null && !"".equals(teliphone)) {
			Matcher mo = p.matcher(teliphone);
			b = mo.matches();
		}
		return b;
	}
    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
 
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
 
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
 
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);
 
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
 
        return cipher.doFinal(data);
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
