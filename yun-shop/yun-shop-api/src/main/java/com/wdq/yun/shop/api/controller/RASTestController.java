package com.wdq.yun.shop.api.controller;

import com.wdq.yun.common.utils.RSAUtil;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RestController("/test")
public class RASTestController {

    private String publicKey;
    private String privateKey;

    @Before
    public void setUp() throws Exception {
        Map<String, Key> keyMap = RSAUtil.initKey();
        publicKey = RSAUtil.getPublicKey(keyMap);
        privateKey = RSAUtil.getPrivateKey(keyMap);
        System.err.println("公钥: \n\r" + publicKey);
        System.err.println("私钥： \n\r" + privateKey);
    }

    @Test
    public void test() throws Exception {
        System.err.println("公钥加密——私钥解密");
        String inputStr = "wudq";
        byte[] encodedData = RSAUtil.encryptByPublicKey(inputStr, publicKey);
        byte[] decodedData = RSAUtil.decryptByPrivateKey(encodedData, privateKey);
        String outputStr = new String(decodedData);
        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
        assertEquals(inputStr, outputStr);
    }

}
