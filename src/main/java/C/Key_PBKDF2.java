package C;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;

public class Key_PBKDF2 {

    // Configuration
    private static final int ITERATIONS = 100000;
    private static final int KEY_LENGTH = 256; // in bits
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";

    // Derives a secure key from the password using PBKDF2 with a user-provided salt
    public static String deriveKey(String password, byte[] salt) throws Exception {
        // Define the password and salt as inputs, along with iteration count and key length
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);

        // Initialize the SecretKeyFactory with PBKDF2 algorithm
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);

        // Generate the key and encode it as Base64
        byte[] key = factory.generateSecret(spec).getEncoded();
        return Base64.getEncoder().encodeToString(key);
    }

    /*
    public static void main(String[] args) {
        try {
            String password = "securePassword";
            String userProvidedSalt = "userSaltString";  // User-provided salt as a string

            // Convert the user-provided salt to a byte array
            byte[] salt = userProvidedSalt.getBytes();

            String derivedKey = deriveKey(password, salt);

            System.out.println("Salt (Base64): " + Base64.getEncoder().encodeToString(salt));
            System.out.println("Derived Key (Base64): " + derivedKey);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
}
