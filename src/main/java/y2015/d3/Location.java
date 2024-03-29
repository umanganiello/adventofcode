package y2015.d3;

public class Location {
	private int x;
	private int y;
	
	
	public Location(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}
	
	public void move(char move) {
		switch (move) {
		case '^':
			y++;
			break;
		case '>':
			x++;
			break;
		case 'v':
			y--;
			break;
		case '<':
			x--;
			break;
		default:
			System.out.println("Direction not recognized");
			break;
		}
	}
	
}
