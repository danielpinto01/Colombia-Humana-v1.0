package models;

public class Manager extends MyThread{
	
	private Player player;
	
	public Manager(String name) {
		super(name);
		player = new Player();
		start();
	}
	
	public static Player createPlayer(String namePlayer, String characterPlayer, int positionX, int positionY) {
		return new Player(namePlayer, characterPlayer, positionX, positionY);
	}
	
	public int getPositionInX() {
		return (int)(Math.random()*1000);
	}

	public int getPositionInY() {
//		return (int)(Math.random()*800);
		return 700;
	}
	
	public void setPlayer(Player playerOne) {
		this.player = playerOne;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void getPositions() {
		System.out.println(player.getPositionInX() +  "-" + player.getPositionInY());
	}

	public void movePlayer(int code, int posXFrame, int posYFrame){
		switch (code) {
		case 37:
			player.movePlayer(DirectionPlayer.LEFT, posXFrame, posYFrame);
			break;
		case 39:
			player.movePlayer(DirectionPlayer.RIGHT, posXFrame, posYFrame);
			break;
		}
	}

	@Override
	void executeTask() {
	}
}