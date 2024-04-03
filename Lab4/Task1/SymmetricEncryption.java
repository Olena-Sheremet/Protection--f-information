import java.util.Arrays;

public class SymmetricEncryption {
    // Функція для шифрування тексту
    public static String encrypt(String plaintext, int[][] key) {
        // Перетворення рядка у масив байтів
        byte[] plaintextBytes = plaintext.getBytes();

        // Шифрування кожного байта масиву plaintextBytes за допомогою ключа
        for (int i = 0; i < plaintextBytes.length; i++) {
            plaintextBytes[i] = (byte) (plaintextBytes[i] + key[i % key.length][i % key[i % key.length].length]);
        }

        // Перетворення зшифрованого масиву байтів у рядок
        return Arrays.toString(plaintextBytes);
    }
    // Функція для дешифрування тексту
    public static String decrypt(String ciphertext, int[][] key) {
        // Перетворення рядка у масив байтів
        String[] bytesString = ciphertext.substring(1, ciphertext.length() - 1).split(", ");
        byte[] ciphertextBytes = new byte[bytesString.length];
        for (int i = 0; i < bytesString.length; i++) {
            ciphertextBytes[i] = Byte.parseByte(bytesString[i]);
        }

        // Дешифрування кожного байта масиву ciphertextBytes за допомогою ключа
        for (int i = 0; i < ciphertextBytes.length; i++) {
            ciphertextBytes[i] = (byte) (ciphertextBytes[i] - key[i % key.length][i % key[i % key.length].length]);
        }

        // Перетворення розшифрованого масиву байтів у рядок
        return new String(ciphertextBytes);
    }
    public static void main(String[] args) {
        // Приклад використання
        int[][] key = {{1,2,3},{4,5,6},{7,8,9}}; // Ключ

        String plaintext = "Hello World"; // Текст для шифрування
        System.out.println("Початковий текст: " + plaintext);

        String ciphertext = encrypt(plaintext, key); // Шифрування
        System.out.println("Шифрований текст: " + ciphertext);

        String decryptedText = decrypt(ciphertext, key); // Дешифрування
        System.out.println("Дешифрований текст: " + decryptedText);
    }
}
