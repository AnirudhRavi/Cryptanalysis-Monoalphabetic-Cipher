/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptochatappmonoalpha.networking;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anirudhravi
 */
public class MessageTransmitter extends Thread {
    
    String message, hostname;
    int port;
    MonoAlphaCipher encrypt;
    
    public MessageTransmitter() {        
    }

    public MessageTransmitter(String message, String hostname, int port) {
        encrypt = new MonoAlphaCipher();
        this.message = encrypt.encryption(message);
        System.out.println("\n" + this.message);
        this.hostname = hostname;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            Socket s = new Socket(hostname, port);
            s.getOutputStream().write(message.getBytes());
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(MessageTransmitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
