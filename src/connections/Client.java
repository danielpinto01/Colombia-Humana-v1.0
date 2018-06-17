package connections;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Thread{

	private Socket connection;
	private DataInputStream input;
	private DataOutputStream output;
	private boolean stop;
	
	private String nameConnection;
	
	public Client(String ip, int port) throws UnknownHostException, IOException {
		this.connection = new Socket(ip, port);
		input = new DataInputStream(connection.getInputStream());
		output = new DataOutputStream(connection.getOutputStream());
		
		nameConnection = "";
		
		start();
	}
	
	@Override
	public void run() {
		String request = "";
		while (!stop) {
			try {
				if ((request = input.readUTF())!= null) {
					receiveRequestServer(request);
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
				stop = true;
			}
		}
	}
	
	public void setNameConnection(String nameConnection) {
		this.nameConnection = nameConnection;
	}
	
	public String getNameConnection() {
		return nameConnection;
	}


	public void receiveRequestServer(String request) throws IOException {
		switch (Response.valueOf(request)) {
		case MESSAGE_SERVER:
			recibirmensajedevuelta();
			break;
		default:
			break;
		}
	}
	
	public void recibirmensajedevuelta() {
		try {
			System.out.println(input.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String message) throws IOException {
		output.writeUTF(Request.MESSAGE.toString());
		output.writeUTF(message);
	}
	
	public void sendInformationPlayer() throws IOException {
		output.writeUTF(Request.PLAYER_INFORMATION.toString());
		File file = new File(getNameConnection() + "Information.json");
		byte[] bs = new byte[(int) file.length()]; 
		System.out.println("Sending File...");
		readFileToSend(file, bs);
		output.writeUTF(file.getName());
		output.writeInt(bs.length);
		output.write(bs);
	}
	
	public void readFileToSend(File file, byte[] bs) throws IOException {
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(bs);
		inputStream.close();
	}
	

	
	public static void main(String[] args) {
		try {
			new Client("",  2000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
