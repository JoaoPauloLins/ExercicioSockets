import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteChat {
	
	public static void main(String[] args) {
		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		int port = 9090;
		try {
			echoSocket = new Socket("localhost", port);
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
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
			System.out.println(in.readLine());
			while ((mensageSent = stdIn.readLine()) != null) {
				out.println(mensageSent);
				mensageReceived = in.readLine();
				System.out.println("Servidor: " + mensageReceived);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
