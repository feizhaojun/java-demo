/*
 * @Author: Mukti
 * @Date: 2021-06-28 18:50:45
 * @LastEditTime: 2021-06-28 18:51:17
 * @LastEditors: Mukti
 */
public class RSAUtil {
   
  private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbbXsP3bfMjQaBQ26+miVuvOUOWG2L9d0subOovEejEpO+kjRqItVstAVf1HEqlYG7o3uUR5yjnO/APjaNk84HlLHLbBQ4RgRl3bzUTuXiiNhtssrE8uU7SBlgn3q2hlwYE8eCzbKnbQHXnoSxxapCha0GdvosS+bM4hLj2I/72QIDAQAB";
 
  /** 加密 */
  public static String encrypt(String param) {
    byte[] encrypt = SecureUtil.rsa(null, PUBLIC_KEY).encrypt(param.getBytes(), "KeyType.PublicKey");
    return Base64.encode(encrypt);
  }
 
  /** 解密 */
  public static String unEncrypt(String param) {
    byte[] re = SecureUtil.rsa(PRIVATE_KEY, null).decrypt(Base64.decode(param), "KeyType.PrivateKey");
    return new String(re);
  }
 
  public static void main(String args[]) throws Exception {
    String rawPassword = "123456";
    String encrypt = URLEncoder.encode(encrypt(rawPassword), "utf-8");
    // 客户端要传的加密密码
    // 注意是post FormData
    System.out.println(encrypt);
    // 测试解密是否成功
    System.out.println(unEncrypt(URLDecoder.decode(encrypt, CharEncoding.UTF_8)));
  }
}