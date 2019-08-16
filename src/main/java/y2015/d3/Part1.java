package y2015.d3;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

import util.CommonUtils;

public class Part1 {

	public static void main(String[] args) {
		Set<Pair<Integer, Integer>> visitedHouses = new HashSet<>();
		
		char[] moves = CommonUtils.readFileLines("input/2015/3/input.txt").get(0).toCharArray();
		
		int x = 0, y = 0;
		System.out.println("New House = 00");
		visitedHouses.add(Pair.of(0,  0));
		
		for(char c : moves) {
			switch (c) {
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
			
			Pair<Integer, Integer> newHouse = Pair.of(x, y);
			System.out.println(newHouse);
			visitedHouses.add(newHouse);
		}
		System.out.println("Visited Houses = "+visitedHouses.size());
	}

}
