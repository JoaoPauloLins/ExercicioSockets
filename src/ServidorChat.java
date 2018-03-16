import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServidorChat {
	
	public static void main(String[] args) throws IOException {
		String serverName = "Servidor";
		Socket echoSocket = null;
		ServerSocket server = null;
		try {
			server = new ServerSocket(9090);
			System.out.println("Aguardando nova conexao");
			echoSocket = server.accept();
			System.out.println("Conexao com cliente iniciada");
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		try {
			SocketChat chat = new SocketChat(echoSocket, serverName);
			chat.begin();
			echoSocket.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
