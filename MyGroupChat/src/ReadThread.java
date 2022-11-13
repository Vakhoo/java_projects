import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ReadThread implements Runnable{
    private MulticastSocket socket;
    private InetAddress socketAddress;
    private int port;
    private final static int    MAX_LENGTH = 100;

    public ReadThread(MulticastSocket socket, InetAddress socketAddress, int port) {
        this.socket = socket;
        this.socketAddress = socketAddress;
        this.port = port;
    }


    @Override
    public void run() {
        while (!GroupChat.isFinished){
            byte[] buffer = new byte[MAX_LENGTH];
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, socketAddress, port);
            try {
                socket.receive(datagramPacket);
                String string = new String(buffer, 0, datagramPacket.getLength(), "UTF-8");
                System.out.println(string);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
