package y2015.d1;

import java.util.List;

import util.CommonUtils;

public class Part1 {

	public static void main(String[] args) {
		List<String> lines = CommonUtils.readFileLines("input/2015/1/input.txt");	
		int floor = 0;
		
		for(String line: lines) {
			for(int i=0; i<line.length(); i++) {
				if('(' == line.charAt(i)) {
					floor++;
				}
				else if(')' == line.charAt(i)) {
					floor--;
				}
			}
		}
		
		System.out.println(floor);
	}
}
