package y2015.d2;

public class Box {
	private int length;
	private int width;
	private int height;
	
	
	public Box(int length, int width, int height) {
		super();
		this.length = length;
		this.width = width;
		this.height = height;
	}
	
	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public static Box fromMeasures(String s) {
		String measures[] = s.split("x");
		return new Box(Integer.parseInt(measures[0]), Integer.parseInt(measures[1]), Integer.parseInt(measures[2]));
	}
	
	public int getNeededPaper() {
		return 2*length*width + 2*width*height + 2*height*length + getSmallestSideArea();
	}
	
	public int getNeededRibbon() {
		return (length*width*height) + getSmallestSidePerimeter();
	}

	private int getSmallestSideArea() {
		int measures[] = {length, width, height};
		int min1=measures[0], min2=measures[1];
		
		for(int i=1; i<3; i++) {
			if(measures[i] < min1) {
				min2 = min1;
				min1 = measures[i];
			}
			else {
				if(measures[i] < min2) {
					min2 = measures[i];
				}
			}
		}
		return min1*min2;
	}
	
	private int getSmallestSidePerimeter() {
		int measures[] = {length, width, height};
		int min1=measures[0], min2=measures[1];
		
		for(int i=1; i<3; i++) {
			if(measures[i] < min1) {
				min2 = min1;
				min1 = measures[i];
			}
			else {
				if(measures[i] < min2) {
					min2 = measures[i];
				}
			}
		}
		return 2*(min1+min2);
	}
}
