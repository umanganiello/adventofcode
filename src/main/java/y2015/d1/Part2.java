package y2015.d1;

import java.util.List;

import util.CommonUtils;

public class Part2 {

	public static void main(String[] args) {
		List<String> lines = CommonUtils.readFileLines("input/2015/1/input.txt");
		int floor = 0;
		int position = 0;
		
		for(String line: lines) {
			for(int i=0; i<line.length(); i++) {
				if('(' == line.charAt(i)) {
					floor++;
				}
				else if(')' == line.charAt(i)) {
					floor--;
				}
				if(floor == -1) {
					position = i+1;
					break;
				}
			}
		}
		
		System.out.println(position);
	}
}
