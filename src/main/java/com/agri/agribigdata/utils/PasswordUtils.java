package com.agri.agribigdata.utils;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.UUID;

public class PasswordUtils {
    /**
     * 加盐生成密文
     * @param password
     * @return
     */
    public static String encrypt(String password){
        String salt = UUID.randomUUID().toString().replace("-","");
        String saltPassword = DigestUtils.md5DigestAsHex((salt+password).getBytes());
        String cipherPassword = salt + "$" + saltPassword;
        return cipherPassword;
    }

    /**
     * 后续解密使用(给定盐值, 加盐生成密文)
     * @param password
     * @return
     */
    public static String encrypt(String password, String salt){
        String saltPassword = DigestUtils.md5DigestAsHex((salt+password).getBytes());
        String cipherPassword = salt + "$" + saltPassword;
        return cipherPassword;
    }


    public static boolean check(String inputPassword, String cipherPassword){
        if(StringUtils.hasLength(inputPassword) && StringUtils.hasLength(cipherPassword)
        && cipherPassword.length()==65){
            String salt = cipherPassword.split("\\$")[0];
            String checkPassword = encrypt(inputPassword, salt);
            if(checkPassword.equals(cipherPassword)){
                return true;
            }
        }
        return false;
    }

}
