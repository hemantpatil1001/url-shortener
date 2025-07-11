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
Convert it to a positive number: (byte & 0xFF)

Get an index in the character pool(base-62) such as 
``` index = (byte & 0xFF) % CHAR_POOL.length() ```

Pick the corresponding character from the CHAR_POOL.

Append it to the hash string

Stop when length of 6 characters have been appended.

#### 4. Output:
Return the final 6-character string (e.g., aKf9Zx) as the short code.

#### 5. Storing in Database
Map the newly created 6-charater string to the input url to be retrieved later

#### 6. Creating shortened url with custom domain name
https://custome-domain.com/{base62-encoded-hash}

### Database Integration

#### 1. MySQL : RDBMS, Easy to manage, faster for simple queries 

#### 2. Run the database instance as a docker container for local development:
Download mysql:latest docker image 
```
docker pull mysql:latest
```
Create a docker container from the image and specify environment variables neccessary for database creation
``` 
docker create \
  --name my-mysql-container \
  -e MYSQL_ROOT_PASSWORD=secret-root-passowrd \
  -e MYSQL_DATABASE=urlytics \
  -e MYSQL_USER=urlytics_app \
  -e MYSQL_PASSWORD=testpass \
  -v mysql_data:/var/lib/mysql \
  -p 3306:3306 \
  mysql:latest
```
Start the container
```
docker start my-mysql-container
```
Access the container's shell
``` 
docker exec -it my-mysql-container bash
```
Access mysql CLI

```
mysql -u root -p
```



