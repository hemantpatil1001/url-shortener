# URL Shortner

### What is a URL Shortener?
_URL Shortener is a tool/application that shortens long and complex web addresses and transforms them into short and manageable links._

### How does it work?
_When someone clicks the shortened link, the URL shortener redirects the user to the associated web address_

### Why is there a need for a URL Shortener?
_Sharing long web addresses becomes difficult when there is a character limit. Other benefits include improved aesthetics of a complex web address, easy management, and UTM tracking._

### Algorithm used to shorten url?

#### 1. Input:
A long URL string.

#### 2. Hashing with SHA-256:
Using `MessageDigest`, compute the `SHA-256` hash of the URL.
This returns a 256-bit hash (32 bytes) in binary format.

#### 3. Convert Bytes to Characters:
For each byte:
Convert it to a positive number: (b & 0xFF)

Get an index in the character pool(base-62) such as 
``` index = (b & 0xFF) % CHAR_POOL.length() ```

Pick the corresponding character from the CHAR_POOL.

Append it to the hash string

Stop when length of 6 characters have been appended.

#### 4. Output:
Return the final 6-character string (e.g., aKf9Zx) as the short code.






