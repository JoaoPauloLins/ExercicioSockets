import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketChat {

	PrintWriter out;
	BufferedReader in;
	String userName;
	
	public SocketChat(Socket socket, String userName) throws IOException {
		this.out = new PrintWriter(socket.getOutputStream(), true);
		this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.userName = userName;
	}
	
	public void begin() {
		MensageReceiver mensageReceiver = new MensageReceiver(in);
		mensageReceiver.start();
		MensageDelivery mensageDelivery = new MensageDelivery(out, userName);
		mensageDelivery.start();
		while (!mensageReceiver.isStopConnection()) { }
	}
}
