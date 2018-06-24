package models;

public class Player {

	private String name;
	private int life;
	private int victories;
	private Area area;
	
	public Player(String name, Area area) {
		this.name = name;
		this.area = area;
		this.life = 100;
	}
	
	public void setVictories(int victories) {
		this.victories = victories;
	}
	
	public void setLife(int life) {
		this.life = life;
	}
	
	public void move(Direction direction) {
		 area.move(direction);
	}	
	
	public String getName() {
		return name;
	}
	
	public int getLife() {
		return life;
	}
	
	public Area getArea() {
		return area;
	}
	
	public int getVictories() {
		return victories;
	}
}