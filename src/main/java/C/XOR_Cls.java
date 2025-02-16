package C;

public class XOR_Cls
{
    public static String xorStrings(String s1, String s2)
    {
        // Ensure strings are of equal length
        if (s1.length() != s2.length())
        {
            throw new IllegalArgumentException("Strings must be of equal length.");
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s1.length(); i++)
        {
            // XOR each character
            char xorChar = (char)(s1.charAt(i) ^ s2.charAt(i));
            result.append(xorChar);
        }

        return result.toString();
    }
/*
    public static void main(String[] args)
    {
        String str1 = "123";
        String str2 = "456";

        String xorResult = xorStrings(str1, str2);
        System.out.println("XOR Result: " + xorResult);

        // To display XOR result in readable hexadecimal format (optional)
        StringBuilder hexResult = new StringBuilder();
        for (char c : xorResult.toCharArray()) {
            hexResult.append(String.format("%02X ", (int)c));
        }
        System.out.println("XOR Result in Hex: " + hexResult.toString().trim());
    }

*/
}
