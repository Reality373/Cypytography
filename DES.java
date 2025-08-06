import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class EncryptDecryptDemo {

    public static void main(String[] args) throws Exception {
        // Plain Text
        String plainText = "My secret message";

        // Key generation
        SecretKey key = KeyGenerator.getInstance("DES").generateKey();

        // encryption mode
        Cipher encryptCipher = Cipher.getInstance("DES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, key);

        // Encryption
        byte[] encryptedBytes = encryptCipher.doFinal(plainText.getBytes());

        // printable message and key
        String encryptedBase64 = Base64.getEncoder().encodeToString(encryptedBytes);
        String keyBase64 = Base64.getEncoder().encodeToString(key.getEncoded());

        // decryption mode
        Cipher decryptCipher = Cipher.getInstance("DES");
        decryptCipher.init(Cipher.DECRYPT_MODE, key);

        // Decryption
        byte[] decryptedBytes = decryptCipher.doFinal(Base64.getDecoder().decode(encryptedBase64));
        String decryptedText = new String(decryptedBytes);

        // Print 
        System.out.println("PT          : " + plainText);
        System.out.println("KEY         : " + keyBase64);
        System.out.println("Encrypted Text : " + encryptedBase64);
        System.out.println("Decrypted Text : " + decryptedText);
    }
}
