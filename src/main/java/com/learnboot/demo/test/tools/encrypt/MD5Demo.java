package com.learnboot.demo.test.tools.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Demo {

    public static void main(String[] args) {
        getMD5Url("https://github.com/AobingJava/JavaFamily");
    }

    public static String getMD5Url(String url) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(url.getBytes("UTF-8"));
            byte[] b = md5.digest();

            int i;
            StringBuffer buf = new StringBuffer();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
                url = buf.toString();
                System.out.println("result = " + url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("url = " + url);
        return url;
    }
}
