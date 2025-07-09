package com.urlytics.shorttrace_service.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class UrlShortener {
    private static final String CHAR_POOL = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int HASH_LENGTH = 6;
    /**
     * Creates a short hash for the given URL.
     *
     * @param url the URL to hash
     * @return a short hash string
     */
    public static String createHash(String url) {
        try {
            // Generate SHA-256 hash
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(url.getBytes());

            // Convert hash bytes to a base-62 string
            StringBuilder hash = new StringBuilder();
            for (byte b : hashBytes) {
                int index = (b & 0xFF) % CHAR_POOL.length();
                hash.append(CHAR_POOL.charAt(index));
                if (hash.length() == HASH_LENGTH) {
                    break; // Limit to 6 characters
                }
            }
            return hash.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating hash", e);
        }
    }
}
