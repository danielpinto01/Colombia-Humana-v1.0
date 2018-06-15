package connections;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Thread{

	private Socket connection;
	private DataInputStream input;
	private DataOutputStream output;
	private boolean stop;
	
	public Client(String ip, int port) throws UnknownHostException, IOException {
		this.connection = new Socket(ip, port);
		input = new DataInputStream(connection.getInputStream());
		output = new DataOutputStream(connection.getOutputStream());
		start();
	}
	
	@Override
	public void run() {
		String request = "";
		while (!stop) {
			try {
				if ((request = input.readUTF())!= null) {
					receiveRequestServer(request);
					sendMessage("hola to server");
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
				stop = true;
			}
		}
	}
	
	public void receiveRequestServer(String request) throws IOException {
		switch (Response.valueOf(request)) {
		case MESSAGE_SERVER:
			System.out.println(input.readUTF());
			break;
		default:
			break;
		}
	}
	
	public void sendMessage(String message) throws IOException {
		output.writeUTF(Request.MESSAGE.toString());
		output.writeUTF(message);
	}
	
	public static void main(String[] args) {
		try {
			new Client("",  2000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
