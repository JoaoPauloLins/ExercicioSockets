import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MensageDelivery extends Thread {

	PrintWriter out;
	String userName;
	
	public MensageDelivery(PrintWriter out, String userName) {
		this.out = out;
		this.userName = userName;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String mensageSent;
			
			while ((mensageSent = stdIn.readLine()) != null) {
				out.println(userName + ": " + mensageSent);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
