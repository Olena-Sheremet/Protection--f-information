import java.util.Objects;

abstract class SymmetricEncryption {
    protected String key;

    public SymmetricEncryption(String key) {
        this.key = key;
    }

    abstract boolean validateKey();

    abstract String encrypt(String plaintext);

    abstract String decrypt(String ciphertext);

    boolean validateEncryption(String ciphertext, String plaintext) {
        return Objects.equals(decrypt(ciphertext), plaintext);
    }

    // Перевірка окремо шифрування і розшифрування
    boolean validateEncryption(String encryptedText, String decryptedText, String plaintext) {
        String encrypted = encrypt(plaintext);
        String decrypted = decrypt(encryptedText);
        return Objects.equals(encryptedText, encrypted) && Objects.equals(decryptedText, decrypted);
    }
}

class TrithemiusEncryption extends SymmetricEncryption {
    public TrithemiusEncryption(String key) {
        super(key);
    }

    @Override
    boolean validateKey() {
        return key != null && !key.isEmpty();
    }

    // Метод encrypt для TrithemiusEncryption
    @Override
    String encrypt(String plaintext) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);
            char encryptedChar = (char) (currentChar + i % key.length());
            encryptedText.append(encryptedChar);
        }
        return encryptedText.toString();
    }

    // Метод decrypt для TrithemiusEncryption
    @Override
    String decrypt(String ciphertext) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);
            char decryptedChar = (char) (currentChar - i % key.length());
            decryptedText.append(decryptedChar);
        }
        return decryptedText.toString();
    }
}

class VigenereEncryption extends SymmetricEncryption {
    public VigenereEncryption(String key) {
        super(key);
    }

    @Override
    boolean validateKey() {
        return key != null && !key.isEmpty();
    }

    // Метод encrypt для VigenereEncryption
    @Override
    String encrypt(String plaintext) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);
            char encryptedChar = (char) (currentChar + key.charAt(i % key.length()) - 'a');
            encryptedText.append(encryptedChar);
        }
        return encryptedText.toString();
    }

    // Метод decrypt для VigenereEncryption
    @Override
    String decrypt(String ciphertext) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);
            char decryptedChar = (char) (currentChar - key.charAt(i % key.length()) + 'a');
            decryptedText.append(decryptedChar);
        }
        return decryptedText.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        String key = "secret";

        SymmetricEncryption trithemiusEncryption = new TrithemiusEncryption(key);
        SymmetricEncryption vigenereEncryption = new VigenereEncryption(key);

        String plaintext = "Hello World";
        System.out.println("Початковий текст: " + plaintext);

        // Шифрування та розшифрування методом Тритеміуса
        String ciphertext1 = trithemiusEncryption.encrypt(plaintext);
        String decryptedText1 = trithemiusEncryption.decrypt(ciphertext1);
        System.out.println("Зашифроване повідомлення методом Тритеміуса: " + ciphertext1);
        System.out.println("Дешифроване повідомлення методом Тритеміуса: " + decryptedText1);
        System.out.println("Перевірка результату для методу Тритеміуса: " + trithemiusEncryption.validateEncryption(ciphertext1, decryptedText1, plaintext));

        // Шифрування та розшифрування методом Віженера
        String ciphertext2 = vigenereEncryption.encrypt(plaintext);
        String decryptedText2 = vigenereEncryption.decrypt(ciphertext2);
        System.out.println("Зашифроване повідомлення методом Віженера: " + ciphertext2);
        System.out.println("Дешифроване повідомлення методом Віженера: " + decryptedText2);
        System.out.println("Перевірка результату для методу Віженера : " + vigenereEncryption.validateEncryption(ciphertext2, decryptedText2, plaintext));
    }
}
import java.util.Objects;

abstract class SymmetricEncryption {
    protected String key;

    public SymmetricEncryption(String key) {
        this.key = key;
    }

    abstract boolean validateKey();

    abstract String encrypt(String plaintext);

    abstract String decrypt(String ciphertext);

    boolean validateEncryption(String ciphertext, String plaintext) {
        return Objects.equals(decrypt(ciphertext), plaintext);
    }

    // Перевірка окремо шифрування і розшифрування
    boolean validateEncryption(String encryptedText, String decryptedText, String plaintext) {
        String encrypted = encrypt(plaintext);
        String decrypted = decrypt(encryptedText);
        return Objects.equals(encryptedText, encrypted) && Objects.equals(decryptedText, decrypted);
    }
}

class TrithemiusEncryption extends SymmetricEncryption {
    public TrithemiusEncryption(String key) {
        super(key);
    }

    @Override
    boolean validateKey() {
        return key != null && !key.isEmpty();
    }

    // Метод encrypt для TrithemiusEncryption
    @Override
    String encrypt(String plaintext) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);
            char encryptedChar = (char) (currentChar + i % key.length());
            encryptedText.append(encryptedChar);
        }
        return encryptedText.toString();
    }

    // Метод decrypt для TrithemiusEncryption
    @Override
    String decrypt(String ciphertext) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);
            char decryptedChar = (char) (currentChar - i % key.length());
            decryptedText.append(decryptedChar);
        }
        return decryptedText.toString();
    }
}

class VigenereEncryption extends SymmetricEncryption {
    public VigenereEncryption(String key) {
        super(key);
    }

    @Override
    boolean validateKey() {
        return key != null && !key.isEmpty();
    }

    // Метод encrypt для VigenereEncryption
    @Override
    String encrypt(String plaintext) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);
            char encryptedChar = (char) (currentChar + key.charAt(i % key.length()) - 'a');
            encryptedText.append(encryptedChar);
        }
        return encryptedText.toString();
    }

    // Метод decrypt для VigenereEncryption
    @Override
    String decrypt(String ciphertext) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);
            char decryptedChar = (char) (currentChar - key.charAt(i % key.length()) + 'a');
            decryptedText.append(decryptedChar);
        }
        return decryptedText.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        String key = "secret";

        SymmetricEncryption trithemiusEncryption = new TrithemiusEncryption(key);
        SymmetricEncryption vigenereEncryption = new VigenereEncryption(key);

        String plaintext = "Hello World";
        System.out.println("Початковий текст: " + plaintext);

        // Шифрування та розшифрування методом Тритеміуса
        String ciphertext1 = trithemiusEncryption.encrypt(plaintext);
        String decryptedText1 = trithemiusEncryption.decrypt(ciphertext1);
        System.out.println("Зашифроване повідомлення методом Тритеміуса: " + ciphertext1);
        System.out.println("Дешифроване повідомлення методом Тритеміуса: " + decryptedText1);
        System.out.println("Перевірка результату для методу Тритеміуса: " + trithemiusEncryption.validateEncryption(ciphertext1, decryptedText1, plaintext));

        // Шифрування та розшифрування методом Віженера
        String ciphertext2 = vigenereEncryption.encrypt(plaintext);
        String decryptedText2 = vigenereEncryption.decrypt(ciphertext2);
        System.out.println("Зашифроване повідомлення методом Віженера: " + ciphertext2);
        System.out.println("Дешифроване повідомлення методом Віженера: " + decryptedText2);
        System.out.println("Перевірка результату для методу Віженера : " + vigenereEncryption.validateEncryption(ciphertext2, decryptedText2, plaintext));
    }
}
