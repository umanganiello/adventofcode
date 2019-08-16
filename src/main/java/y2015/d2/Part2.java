package y2015.d2;

import java.util.List;

import util.CommonUtils;

public class Part2 {

	public static void main(String[] args) {
		List<String> lines = CommonUtils.readFileLines("input/2015/2/input.txt");
		int totalRibbon = lines.stream().map(Box::fromMeasures).mapToInt(Box::getNeededRibbon).sum();
		System.out.println("Total ribbon="+totalRibbon);
	}

}
