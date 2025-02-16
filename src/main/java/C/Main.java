package C;

public class Main
{
    public static String genKey(String key)
    {
        String h1;  // 32 len
        String h2;  // 40 len
        String h3;  // 64 len
        String h4;  //128 len

        h1 = Hash_MD5.md5Hash(key);
        h2 = Hash_SHA1.sha1Hash(key);
        h3 = Hash_SHA256.sha256Hash(key);
        h4 = Hash_SHA512.sha512Hash(key);

        String k1 = "";     // 44 len
        String k2 = "";     // 44 len
        String k3 = "";     // 44 len
        String k4 = "";
        String k5 = "";
        String k6 = "";
        String k7 = "";
        String k8 = "";
        String k9 = "";

        k1 = h1.substring(22, 32) + h2.substring(35, 38) + h3.substring(50, 60) + h4.substring(90, 111);

        try
        {
            k2 = Key_PBKDF2.deriveKey(k1, h2.getBytes());
        }
        catch (Exception e){}

        k3 = XOR_Cls.xorStrings(k1, k2);

        k4 = Symmetric_AES.encrypt_AES(k3, h1);
        k5 = Symmetric_3DES.encrypt_3DES(k4, h3);
        k6 = Symmetric_Blowfish.encrypt_Blowfish(k5, h4);

        try
        {
            k7 = Key_PBKDF2.deriveKey(k6, h2.getBytes());
        }
        catch (Exception e){}

        k8 = XOR_Cls.xorStrings(k6.substring(k6.length()-44, k6.length()), k7);
        k9 = XOR_Cls.xorStrings(k3, k8);

        return k9;
    }

    public static void main(String[] args)
    {
	System.out.print("Enter Data: ");
        String Data = scanner.nextLine();
        
        System.out.print("Enter Key: ");
        String Key = scanner.nextLine();
        
	String k = genKey(Key);

        String cipher = Symmetric_AES.encrypt_AES(Data, k);
        String dec = Symmetric_AES.decrypt_AES(cipher, k);

        System.out.println(Data);
        System.out.println(cipher);
        System.out.println(dec);
    }
}