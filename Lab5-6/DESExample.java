import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class DESExample {
    public static void main(String[] args) {
        String key = "ABCDEFGH"; // ключ
        String iv = "IGKLMNOP"; // вектор ініціалізації
        String plaintext = "Hello World!"; // текст для шифрування
        System.out.println("Початковий текст:"+plaintext);
        try {
            // Шифрування
            byte[] encryptedBytes = encrypt(plaintext, key, iv);
            System.out.println("Шифроване повідомлення: " + bytesToHex(encryptedBytes));

            // Розшифрування
            String decryptedText = decrypt(encryptedBytes, key, iv);
            System.out.println("Дешифроване повідомлення: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] encrypt(String plaintext, String key, String iv) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "DES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
    }

    public static String decrypt(byte[] ciphertext, String key, String iv) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "DES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] decryptedBytes = cipher.doFinal(ciphertext);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02X", b));
        }
        return result.toString();
    }
}
