package y2015.d3;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

import util.CommonUtils;

public class Part2 {

	public static void main(String[] args) {
		Set<Pair<Integer, Integer>> visitedHouses = new HashSet<>();
		
		char[] moves = CommonUtils.readFileLines("input/2015/3/input.txt").get(0).toCharArray();
		
		Location santa = new Location(0, 0);
		Location roboSanta = new Location(0, 0);
		
		visitedHouses.add(Pair.of(0, 0));
		
		for(int i=0; i<moves.length; i++) {
			
			if(i%2 == 0) {
				santa.move(moves[i]);
				visitedHouses.add(Pair.of(santa.getX(), santa.getY()));
			}
			else {
				roboSanta.move(moves[i]);
				visitedHouses.add(Pair.of(roboSanta.getX(), roboSanta.getY()));
			}
			
			
		}
		System.out.println("Visited Houses = "+visitedHouses.size());
	}
	
}