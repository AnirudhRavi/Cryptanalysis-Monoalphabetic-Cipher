**Program**: Chat application (using Mono-alphabetic encryption) created using NetBeans UI and decrypted using a Python script

**Author**: Anirudh Ravi

**About**:

These programs are written in Java and Python respectively. For more information please refer to this video: https://youtu.be/gWRWtLkb6t0.

**Chat Application**:

The Chat Application uses Mono-alphabetic cipher encryption. It was built in Java and makes use of simple socket programming where before a message is transmitted it is encrypted using the mono-alphabetic key and on receiving the message on the receiver side the message is decrypted using the same key.

**Cryptanalysis of Mono-alphabetic Cipher**:

The Cryptanalysis of this code is done using hill climbing algorithm written using Python code. Character–n–grams of a text can be used to analyse and predict the ciphertext to plaintext mapping. This particular approach is used to get the ciphertext based on the plaintext without knowing the key. We make use of Quadgram data (in this case collected from the book “War and Peace” by Leo Tolstoy) in order to predict the key of the cipher text. Quadgrams work better than tri, di and monograms while higher character-n-grams do not contribute much to accuracy of prediction.

**Cryptanalysis Algorithm**:

The algorithm works as follows:

1. Use a random key and set this as the parent key
2. Do this for 1000 iterations:
  - Store the fitness score (score based on occurrences of Quadgrams) of the deciphered text using key
  - Swap 2 characters in the parent key and set this as child. If fitness score calculated using the child is greater than parent then set the parent as child key
3. Print current best key and best plaintext if fitness score is higher than from the earlier iterations and move back to step 1

Quadgram data was taken from the website Practical Cryptography. Breaking ciphers less than 100 characters is more troublesome because word frequency and n-gram

**Analysis of results**:

Ciphertext of varying character length either encrypted using monoalphabetic cipher (plaintext data collected from Quora) or taken from different university websites and the NSA (National Security Agency) website was used to test the Cryptanalysis code. For further details please refer: https://drive.google.com/file/d/0B5oLABv2TB-FTVphTHhjQmoxTnc/view.
