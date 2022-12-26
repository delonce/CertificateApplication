package main.CryptoPackage;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class CryptoManager extends AbstractCryptoManager {

    public String DoEncodingData(String inputData, String pathToSave) {
        try {
            byte[] plainText = inputData.getBytes("UTF8");

            getKeyGen().initialize(4096);
            KeyPair keyPair = getKeyGen().generateKeyPair();

            getCipher().init(Cipher.ENCRYPT_MODE, keyPair.getPrivate());

            byte[] cipherText = getCipher().doFinal(plainText);
            String base64EncodedData = new String(Base64.getEncoder().encode(cipherText));

            SavePublicKey(keyPair.getPublic(), pathToSave);

            return base64EncodedData;

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    public String DecodeByPublicKey(String encodedData, String pathToKey) {
        try {
            PublicKey publicKey = LoadPublicKey(pathToKey);
            byte[] decodedData = Base64.getMimeDecoder().decode(encodedData);

            getCipher().init(Cipher.DECRYPT_MODE, publicKey);
            byte[] finalKeyEncoding = getCipher().doFinal(decodedData);

            String resultOfDecodingByKey = new String(finalKeyEncoding, "UTF8");
            return resultOfDecodingByKey;

        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }

    }

    private void SavePublicKey(PublicKey publicKey, String pathToSave) {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey.getEncoded());

        try (FileOutputStream fileOutputStream = new FileOutputStream(pathToSave)){
            fileOutputStream.write(keySpec.getEncoded());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private PublicKey LoadPublicKey(String path) {
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            File filePrivateKey = new File(path);

            byte[] encodedPrivateKey = new byte[(int) filePrivateKey.length()];
            fileInputStream.read(encodedPrivateKey);

            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encodedPrivateKey);
            PublicKey publicKey = getKeyFactory().generatePublic(keySpec);
            return publicKey;

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}
