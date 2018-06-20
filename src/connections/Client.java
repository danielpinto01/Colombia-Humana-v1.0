package connections;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.json.simple.parser.ParseException;

import models.Player;
import persistence.FileManager;

public class Client extends Thread{

	private Socket connection;
	private DataInputStream input;
	private DataOutputStream output;
	private boolean stop;

	private String nameConnection;
	private FileManager fileManager;

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
			} catch (IOException | ParseException e) {
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


	public void receiveRequestServer(String request) throws IOException, ParseException {
		switch (Response.valueOf(request)) {
		case MESSAGE_SERVER:
			recibirmensajedevuelta();
			break;
		case TOTAL_LIST:
			receiveTotalListFromServerToClient();
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

//	public void sendMessage(String message) throws IOException {
//		output.writeUTF(Request.MESSAGE.toString());
//		output.writeUTF(message);
//	}

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

	public void receiveTotalListFromServerToClient() throws IOException, ParseException {
		File file = new File(input.readUTF());
		byte[] bs = new byte[input.readInt()];
		System.out.println("Receiving File..." + file.toString());
		input.read(bs);
		writeTotalListFromServerToClient(file, bs);
	}

	public void writeTotalListFromServerToClient(File file, byte[] bs) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(file);
		outputStream.write(bs);
		outputStream.close();
	}

	public static void main(String[] args) {
		try {
			new Client("",  2000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}