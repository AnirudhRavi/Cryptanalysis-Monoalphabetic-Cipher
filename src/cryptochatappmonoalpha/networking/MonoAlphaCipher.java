/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptochatappmonoalpha.networking;

/**
 *
 * @author anirudhravi
 */
public class MonoAlphaCipher {
    private static char alphabets[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};
    private static char key[] = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', ' '};
    
    public MonoAlphaCipher() {
        
    }
    
    public String encryption(String message) {
        char cipherText[] = new char[(message.length())];
        for (int i = 0; i < message.length(); i++) {
            for (int j = 0; j < 27; j++) {
                if (alphabets[j] == message.charAt(i)) {
                    cipherText[i] = key[j];
                    break;
                }
            }
        }
        return (new String(cipherText));
    }
    
    public String decryption(String message) {
        char plainText[] = new char[(message.length())];
        for (int i = 0; i < message.length(); i++) {
            for (int j = 0; j < 27; j++) {
                if (key[j] == message.charAt(i)) {
                    plainText[i] = alphabets[j];
                    break;
                }
            }
        }
        return (new String(plainText));
    }
}