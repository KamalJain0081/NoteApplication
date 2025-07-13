package com.utilityMethods;

import org.springframework.stereotype.Component;

/*
 
Step 1: Character shifting by position + key

Step 2: String reversal

Step 3: Custom XOR with a secret key

Step 4: Character reordering (odd/even shuffle)
 
*/

@Component
public class SecureCipher {

    private static final String SECRET_KEY = "SecurityCipher#062025"; 
    
    // Step 1: Shift characters by position + key
    private static String step1_shiftChars(String input) 
    {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) 
        {
            int keyChar = SECRET_KEY.charAt(i % SECRET_KEY.length());
            char c = input.charAt(i);
            c += (i + keyChar) % 5; // shift with position and key
            result.append(c);
        }
        
        return result.toString();
    }

    // Step 2: Reverse string
    private static String step2_reverse(String input) 
    {
        return new StringBuilder(input).reverse().toString();
    }

    // Step 3: XOR each char with secret key
    private static String step3_xor(String input) 
    {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) 
        {
            char c = (char)(input.charAt(i) ^ SECRET_KEY.charAt(i % SECRET_KEY.length()));
            result.append(c);
        }
        
        return result.toString();
    }

    // Step 4: Reorder characters (odd/even shuffle)
    private static String step4_reorder(String input) 
    {
        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) 
        {
            if (i % 2 == 0) even.append(input.charAt(i));
            else odd.append(input.charAt(i));
        }
        
        return even.toString() + odd.toString();
    }

    // REVERSE Step 4
    private static String reverse_step4_reorder(String input) 
    {
        int half = (input.length() + 1) / 2;
        String even = input.substring(0, half);
        String odd = input.substring(half);

        StringBuilder original = new StringBuilder();
        for (int i = 0; i < input.length(); i++) 
        {
            if (i % 2 == 0) original.append(even.charAt(i / 2));
            else original.append(odd.charAt(i / 2));
        }
        
        return original.toString();
    }

    // REVERSE Step 3
    private static String reverse_step3_xor(String input) 
    {
        return step3_xor(input); // XOR is reversible by itself
    }

    // REVERSE Step 2
    private static String reverse_step2_reverse(String input) 
    {
        return step2_reverse(input); // Reversal is its own inverse
    }

    // REVERSE Step 1
    private static String reverse_step1_shiftChars(String input) 
    {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) 
        {
            int keyChar = SECRET_KEY.charAt(i % SECRET_KEY.length());
            char c = input.charAt(i);
            c -= (i + keyChar) % 5; // reverse shift
            result.append(c);
        }
        
        return result.toString();
    }

    // 🔒 Encrypt
    public String encrypt(String input) 
    {
        String step1 = step1_shiftChars(input);
        String step2 = step2_reverse(step1);
        String step3 = step3_xor(step2);
        String step4 = step4_reorder(step3);
        return step4;
    }

    // 🔓 Decrypt
    public String decrypt(String input) 
    {
        String step1 = reverse_step4_reorder(input);
        String step2 = reverse_step3_xor(step1);
        String step3 = reverse_step2_reverse(step2);
        String step4 = reverse_step1_shiftChars(step3);
        return step4;
    }
}

