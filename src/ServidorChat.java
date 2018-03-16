import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServidorChat {
	
	public static void main(String[] args) throws IOException {
		Socket echoSocket = null;
		ServerSocket server = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			server = new ServerSocket(9090);
			System.out.println("Aguardando nova conexao");
			echoSocket = server.accept();
			System.out.println("Conexao com cliente iniciada");
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
			out.println("Ola, voce se conectou ao servidor");
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		try {
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String mensageSent;
			String mensageReceived;
			do {
				mensageReceived = in.readLine();
				System.out.println("Cliente: " + mensageReceived);
				mensageSent = stdIn.readLine();
				if (mensageSent != null) {
					out.println(mensageSent);
				}
			} while (mensageReceived != null);
			out.close();
			in.close();
			stdIn.close();
			echoSocket.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
