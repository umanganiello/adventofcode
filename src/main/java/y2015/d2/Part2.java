package y2015.d2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class Part2 {

	public static void main(String[] args) {
		InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("input/2015/2/input.txt");
		List<String> lines = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8)).lines().collect(Collectors.toList());
		int totalRibbon = lines.stream().map(Box::fromMeasures).mapToInt(Box::getNeededRibbon).sum();
		System.out.println("Total ribbon="+totalRibbon);
	}

}
