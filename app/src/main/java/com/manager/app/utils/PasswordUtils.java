package com.manager.app.utils;

import com.manager.app.model.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

public class PasswordUtils {
    private static RandomNumberGenerator rnd = new SecureRandomNumberGenerator();

    private static final String hashing = "SHA-256";

    public static void encrypt(User user){
        // randomly generate data for salting
//        https://auth0.com/blog/adding-salt-to-hashing-a-better-way-to-store-passwords/#Generating-a-Good-Random-Salt
        String salts = rnd.nextBytes().toString();
        // add salts to randomize hashing
        String newPass = new SimpleHash(hashing, user.getPassword(), salts, 1).toString();
        user.setPassword(newPass);
        // need to save salt
        user.setSalt(salts);
    }
}
