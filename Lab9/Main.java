import java.security.*;
import java.util.Base64;

public class Main {

    public static void main(String[] args) throws Exception {
        // Створення об'єкту DSA з ключами за замовчуванням
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        keyPairGenerator.initialize(1024); // Розмір ключа 1024 біти
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Для контролю виводиться згенерований секретний ключ
        System.out.println("---Secret key:");
        System.out.println(privateKey);

        // Публічний ключ експортується для передачі іншій стороні
        System.out.println("---Public key:");
        System.out.println(publicKey);

        // Вхідне повідомлення представляється у вигляді байтової послідовності
        String message = "Hello world!";
        System.out.println("---Message: ");
        System.out.println(message);

        byte[] messageBytes = message.getBytes();
        System.out.println("---HexMessage: ");
        for (byte b : messageBytes) {
            System.out.print(String.format("%02X", b));
        }
        System.out.println();

        // Створюється дайджест повідомлення за алгоритмом SHA-1
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        byte[] hashedMessage = sha1.digest(messageBytes);
        System.out.println("---HashedMessage: ");
        for (byte b : hashedMessage) {
            System.out.print(String.format("%02X", b));
        }
        System.out.println();

        // Підписується повідомлення
        Signature dsa = Signature.getInstance("SHA1withDSA");
        dsa.initSign(privateKey);
        dsa.update(hashedMessage);
        byte[] signature = dsa.sign();
        System.out.println("---Signature: ");
        System.out.println(Base64.getEncoder().encodeToString(signature));

        // Перевіряється підпис для дайджесту
        System.out.println("\n---Verification:");
        dsa.initVerify(publicKey);
        dsa.update(hashedMessage);
        boolean verified = dsa.verify(signature);
        System.out.println("Verification result: " + verified);
    }
}
