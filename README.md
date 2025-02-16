# **SecureKeyGen - Advanced Cryptographic Key Generator**

## **Abstract**
SecureKeyGen is a robust cryptographic key generation tool designed to enhance data security by leveraging multiple hashing algorithms, key derivation techniques, XOR operations, and symmetric encryption methods. Built using **Java**, this project ensures **secure and unpredictable key generation** for encryption purposes. The tool adheres to modern cryptographic standards, integrating **AES, 3DES, Blowfish, PBKDF2, SHA-1, SHA-256, SHA-512, and MD5** to provide **multi-layered security**.

## **Installation**
Clone the repository and navigate to the project directory:

```bash
git clone https://github.com/AdityaBhatt3010/SecureKeyGenerator.git
cd SecureKeyGen
```

## **Key Features**
1. **Multi-Stage Key Generation** – Generates cryptographic keys using **PBKDF2, XOR operations, and multiple encryption layers**.
2. **Hashing Algorithms** – Supports **MD5, SHA-1, SHA-256, and SHA-512**.
3. **Key Derivation Function** – Implements **PBKDF2** for strengthened security.
4. **Symmetric Encryption** – Uses **AES, 3DES, and Blowfish** to protect keys.
5. **XOR-Based Key Mixing** – Introduces additional randomness and complexity in key generation.
6. **End-to-End Encryption & Decryption** – Encrypts and decrypts data securely using the generated key.

## **Technology Stack**
- **Language:** Java
- **Cryptographic Standards:**
  - **PBKDF2** – NIST SP 800-132
  - **SHA-1** – ISO/IEC 10118-3, NIST FIPS 180-4 (Deprecated)
  - **SHA-256, SHA-512** – ISO/IEC 10118-3, NIST FIPS 180-4
  - **MD5** – ISO/IEC 10118-3 (Deprecated)
  - **AES (Advanced Encryption Standard)** – ISO/IEC 18033-3, NIST FIPS 197
  - **3DES (Triple DES)** – ISO/IEC 18033-3, NIST SP 800-67 (Deprecated)
  - **Blowfish** – No official NIST standard but widely used

## **Methodology**
1. **Input Handling** – Accepts user input for data and key.
2. **Hashing** – Generates four different hashes (`MD5, SHA-1, SHA-256, SHA-512`).
3. **Key Mixing & Derivation** –
   - Extracts substrings from hashes.
   - Uses **PBKDF2** to derive secure keys.
   - Performs **XOR operations** to increase entropy.
4. **Multi-Layered Encryption** –
   - Encrypts the generated key sequentially using **AES, 3DES, and Blowfish**.
5. **Final Key Generation** – Combines the results to form a **secure cryptographic key**.
6. **Data Encryption & Decryption** – Uses the generated key to encrypt and decrypt user-provided data.

## **Security Standards Compliance**
SecureKeyGen follows modern cryptographic best practices:
| Algorithm | Standard | Security Status |
|-----------|----------|----------------|
| **MD5** | ISO/IEC 10118-3 | Weak (Collisions found) |
| **SHA-1** | ISO/IEC 10118-3, NIST FIPS 180-4 | Weak (Collision attacks exist) |
| **SHA-256** | ISO/IEC 10118-3, NIST FIPS 180-4 | Strong |
| **SHA-512** | ISO/IEC 10118-3, NIST FIPS 180-4 | Strong |
| **PBKDF2** | NIST SP 800-132 | Secure |
| **AES** | ISO/IEC 18033-3, NIST FIPS 197 | Secure |
| **3DES** | ISO/IEC 18033-3, NIST SP 800-67 | Weak (Deprecated) |
| **Blowfish** | No official NIST standard | Somewhat outdated |

## **Usage Example**
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Data: ");
        String data = scanner.nextLine();
        
        System.out.print("Enter Key: ");
        String key = scanner.nextLine();
        
        String generatedKey = SecureKeyGen.genKey(key);
        String cipherText = Symmetric_AES.encrypt_AES(data, generatedKey);
        String plainText = Symmetric_AES.decrypt_AES(cipherText, generatedKey);
        
        System.out.println("Original: " + data);
        System.out.println("Encrypted: " + cipherText);
        System.out.println("Decrypted: " + plainText);
        
        scanner.close();
    }
}
```

## **Results**
- **Robust Key Generation** using advanced cryptographic techniques.
- **Multi-Layered Security** with PBKDF2, XOR, and multiple encryption algorithms.
- **AES Encryption** ensures **high-level data confidentiality**.
- **Successful Decryption** confirms **data integrity** and security.

## **Conclusion**
SecureKeyGen is an **advanced, secure, and efficient cryptographic key generation system**. By combining hashing, PBKDF2, XOR operations, and multiple encryption techniques, it ensures **highly unpredictable key generation** for **enhanced security**. The project adheres to **ISO, NIST, and industry-standard cryptographic guidelines**, making it a reliable tool for security professionals and developers.

