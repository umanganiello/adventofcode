package y2015.d1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class Part1 {

	public static void main(String[] args) {
		InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("input/2015/1/input.txt");
		List<String> lines = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8)).lines().collect(Collectors.toList());	
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
