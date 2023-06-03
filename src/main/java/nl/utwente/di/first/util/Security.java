package nl.utwente.di.first.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HexFormat;


/**
 * The SHA-256 algorithm generates an almost-unique, fixed-size 256-bit (32-byte) hash.
 * This is a one-way function, so the result cannot be decrypted back to the original value.
 * salt+password OR password+salt are all valid
 */
public class Security {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String passwordToHash = "password";
//        byte[] byteSalt = getSalt();
//        String stringSalt = toHex(byteSalt);
        String test = "4f7697e8aef26cfd2564b9534e394355";
        String testHashedPassword = "3097b3d3eda2623854172066b5bb5221104f7aa4cd5fa2c8a42509458f526f93";

//        System.out.println("Convert from byte to Hex(String): " + stringSalt);
        byte[] backToByte = toByteArray(test);

        String securePassword = saltSHA256(passwordToHash, backToByte);
        System.out.println(securePassword);
        System.out.println("Compare equal: " + securePassword.equals(testHashedPassword));

    }


    public static String saltSHA256(String passwordToHash, byte[] salt) {
        String finalPassword = "";
        byte[] saltByteArray = salt;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Passing the salt to the digest for the computation
            md.update(saltByteArray);

            // Add password bytes to digest
            byte[] bytes = md.digest(passwordToHash.getBytes());

            finalPassword = toHex(bytes);

        } catch (NoSuchAlgorithmException e) {
            System.err.println("Algorithm does not exist");
        }
        return finalPassword;
    }


    // Add salt
    public static byte[] getSalt() throws NoSuchAlgorithmException {
        // generate random salt
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG"); // “SHA1PRNG” pseudo-random number generator algorithm
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt); // fill in 16-byte array

        return salt;

    }

    public static String toHex(byte[] bytes) {
        HexFormat hexFormat = HexFormat.of();
        String result = hexFormat.formatHex(bytes);

        return result;
    }
//    public static String toHex2(byte[] bytes) {
//        StringBuilder result = new StringBuilder();
//        for (byte aByte : bytes) {
//            result.append(String.format("%02x", aByte));
//        }
//        return result.toString();
//    }
        public static byte[] toByteArray(String str) {

        HexFormat hexFormat = HexFormat.of();
        byte[] result = hexFormat.parseHex(str);

        return result;
    }
}
