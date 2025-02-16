package C;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//128 len
public class Hash_SHA512
{
    public static String sha512Hash(String input)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes)
            {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
            return "";
        }
    }

    //*
    public static void main(String[] args)
    {
        String str = "Test";
        System.out.println(sha512Hash(str));
    }
    //*/
}