import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

public class SymmetricEncryption {

    // Функція для шифрування тексту методом гамування
    public static String encrypt(String plaintext, byte[] gamma) {
        byte[] plaintextBytes = plaintext.getBytes();

        // Шифрування кожного байта масиву plaintextBytes за допомогою гами
        for (int i = 0; i < plaintextBytes.length; i++) {
            plaintextBytes[i] = (byte) (plaintextBytes[i] ^ gamma[i]); // XOR оператор для гамування
        }

        // Перетворення зашифрованого масиву байтів в Base64 рядок
        return Base64.getEncoder().encodeToString(plaintextBytes);
    }

    // Функція для дешифрування тексту методом гамування
    public static String decrypt(String ciphertext, byte[] gamma) {
        // Перетворення Base64 рядка в масив байтів
        byte[] ciphertextBytes = Base64.getDecoder().decode(ciphertext);

        // Дешифрування кожного байта масиву ciphertextBytes за допомогою гами
        for (int i = 0; i < ciphertextBytes.length; i++) {
            ciphertextBytes[i] = (byte) (ciphertextBytes[i] ^ gamma[i]); // XOR оператор для гамування
        }

        return new String(ciphertextBytes);
    }

    public static void main(String[] args) {
        int[][] key = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; // Ключ

        String plaintext = "Hello World"; // Текст для шифрування
        System.out.println("Початковий текст: " + plaintext);

        // Генерація гами 
        byte[] gamma = generateGamma(plaintext.length());

        String ciphertext = encrypt(plaintext, gamma); // Шифрування
        System.out.println("Шифрований текст: " + ciphertext);

        String decryptedText = decrypt(ciphertext, gamma); // Дешифрування
        System.out.println("Дешифрований текст: " + decryptedText);
    }

    // Функція для генерації гами
    private static byte[] generateGamma(int length) {
        byte[] gamma = new byte[length];
        new Random().nextBytes(gamma);
        return gamma;
    }
}
