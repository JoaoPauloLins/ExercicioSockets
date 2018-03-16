import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteChat {
	
	public static void main(String[] args) {
		String clientName = "Cliente";
		Socket echoSocket = null;
		int port = 9090;
		try {
			echoSocket = new Socket("localhost", port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		try {
			SocketChat chat = new SocketChat(echoSocket, clientName);
			chat.begin();
			echoSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
