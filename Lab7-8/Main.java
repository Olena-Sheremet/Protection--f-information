import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;

public class Main {
    private static final String ALGORITHM = "RSA";

    public static KeyPair generateKeyPair(int keySize) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGenerator.initialize(keySize);
        return keyPairGenerator.generateKeyPair();
    }

    public static byte[] encrypt(byte[] data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] data, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    public static void main(String[] args) throws Exception {
        // генерація Key Pair
        KeyPair keyPair = generateKeyPair(2048);
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();


        String originalText = "Hello, World!";
        byte[] originalData = originalText.getBytes();

        // Шифрування
        byte[] encryptedData = encrypt(originalData, publicKey);

        // Дешифрування
        byte[] decryptedData = decrypt(encryptedData, privateKey);

        String decryptedText = new String(decryptedData);

        // Output
        System.out.println("Початковий текст: " + originalText);
        System.out.println("Шифрований текст: " + Base64.getEncoder().encodeToString(encryptedData));
        System.out.println("Дешифрований текст: " + decryptedText);
    }
}
