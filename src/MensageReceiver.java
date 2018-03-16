import java.io.BufferedReader;
import java.io.IOException;

public class MensageReceiver extends Thread {
	
	private boolean stopConnection = false;
	
	BufferedReader in;
	
	public MensageReceiver(BufferedReader in) {
		this.in = in;
	}
	
	@Override
	public void run() {
		try {
			String messageReceived;
			while ((messageReceived = in.readLine()) != null) {
				System.out.println(messageReceived);
			}
			stopConnection = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isStopConnection() {
		return this.stopConnection;
	}
}
