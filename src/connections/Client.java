package connections;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import controllers.IObservable;
import controllers.IObserver;
import models.Enemy;
import models.MyThread;
import models.Player;
import models.Shot;
import persistence.FileManager;

public class Client extends MyThread implements IObservable{

	private Socket socket;
	private DataOutputStream output;
	private DataInputStream input;
	private IObserver iObserver;
	
	private Enemy enemy;
	
	private ArrayList<Shot> shots;
	
	public Client(String ip, int port, Player player) throws IOException {
		super("", 20);
		socket = new Socket(ip, port);
		System.out.println("Conexion iniciada");
		output = new DataOutputStream(socket.getOutputStream());
		input = new DataInputStream(socket.getInputStream());
		createPlayer(player);
		enemy = new Enemy();
		shots = new ArrayList<>();
		start();
	}

	private void createPlayer(Player player) throws IOException {
		output.writeUTF(Request.SIGN_IN.toString());
		output.writeUTF(player.getName());
		output.writeInt(player.getArea().getX());
		output.writeInt(player.getArea().getY());
		output.writeInt(player.getArea().getWidth());
		output.writeInt(player.getArea().getHeight());
	}

	@SuppressWarnings("incomplete-switch")
	private void responseManager(String response) throws IOException {
		switch (Response.valueOf(response)) {
		case PLAYERS_INFO:
			getUsersInfo();
			break;
		case SEND_BEES:
			getBeesFile();
			break;
		case START_GAME:
			iObserver.startGame();
			break;
		}
	}
	
	public ArrayList<Shot> getShots() {
		return shots;
	}

	private void getUsersInfo() throws IOException {
		File file = new File(input.readUTF());
		readFile(file);
		iObserver.loadUsers(FileManager.readUsers(file));
		int x = input.readInt();
		enemy.setPositionInX(x);
		file.delete();
	}
	
	
	private void getBeesFile() throws IOException {
		File file = new File(input.readUTF());
		readFile(file);
		iObserver.loadBees(FileManager.readBees(file));
	}
	
	private void readFile(File file) throws IOException {
		byte[] fileArray = new byte[input.readInt()];
		input.readFully(fileArray);
		FileOutputStream fOutputStream = new FileOutputStream(file);
		fOutputStream.write(fileArray);
		fOutputStream.close();
	}

	public void sendMove(int x, int y) {
		try {
			output.writeUTF(Request.MOVE_PLAYER.toString());
			output.writeInt(x);
			output.writeInt(y);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void execute() {
		String response;
		try {
			response = input.readUTF();
			if (response != null) {
				responseManager(response);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
			stop();
		}
	}

	@Override
	public void addObserver(IObserver iObserver) {
		this.iObserver = iObserver;
	}

	public void createShoot(int x, int y) {
		try {
			output.writeUTF(Request.CREATE_SHOOT.toString());
			output.writeInt(x);
			output.writeInt(y);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public Enemy getEnemy() {
		return enemy;
	}
}