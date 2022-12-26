package main.CryptoPackage;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

abstract public class AbstractCryptoManager {
    private KeyPairGenerator keyGen;
    private Cipher cipher;
    private KeyFactory keyFactory;

    public AbstractCryptoManager() {
        try {
            this.keyGen = KeyPairGenerator.getInstance("RSA");
            this.cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            this.keyFactory = KeyFactory.getInstance("RSA");
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public KeyFactory getKeyFactory() {
        return keyFactory;
    }

    public void setKeyFactory(KeyFactory keyFactory) {
        this.keyFactory = keyFactory;
    }

    public void setKeyGen(KeyPairGenerator keyGen) {
        this.keyGen = keyGen;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public KeyPairGenerator getKeyGen() {
        return keyGen;
    }

    public Cipher getCipher() {
        return cipher;
    }
}
