package ejemplo.cliente.ssl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 *
 * @author Manu
 */
public class EjemploClienteSSL {

    public static void main(String[] args) throws IOException {
        System.setProperty("javax.net.ssl.keyStore", "src/keychat");
        System.setProperty("javax.net.ssl.keyStorePassword", "manuel");
        System.setProperty("javax.net.ssl.trustStore", "src/keychat");
        System.setProperty("javax.net.ssl.trustStorePassword", "manuel");
        
        SSLSocketFactory clientFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket client = (SSLSocket)clientFactory.createSocket();
        InetSocketAddress addr = new InetSocketAddress("localhost", 5556);
        
        client.connect(addr);
        
        InputStream recepcion = client.getInputStream();
        OutputStream envio = client.getOutputStream();
        
        String mensaje= "holi";
        envio.write(mensaje.length());
        envio.write(mensaje.getBytes());
        
        envio.close();
        
        

    }

}
