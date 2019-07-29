package y2015.d19;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

public class Part2 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String inputFilePath = "input/2015/19/input2.txt";
		List<Pair<String, String>> replacements = readReplacementsFromInputFile(inputFilePath);
		String startingMolecule = readStartingMoleculeFromInputFile(inputFilePath);
		
		System.out.println("Count="+calculateFewestNumberOfSteps(replacements, startingMolecule)+". Time: "+(System.currentTimeMillis()-startTime)+"ms.");
	}
	
	private static List<Pair<String, String>> readReplacementsFromInputFile(String path) {
		List<Pair<String, String>> replacements = null; 
		InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
		List<String> lines = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8)).lines().collect(Collectors.toList());	
		
        replacements = lines.stream()
        	.filter(l -> l.contains("=>"))
        	.map(l -> getPairFromLine(l))
        	.collect(Collectors.toList());
        
		return replacements;
	}
	
	private static String readStartingMoleculeFromInputFile(String path) {
		String startingMolecule = null;
		InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
		List<String> lines = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8)).lines().collect(Collectors.toList());	

        startingMolecule = lines.stream()
        	.filter(l -> !l.contains("=>") && !l.isEmpty())
        	.collect(Collectors.toList()).get(0);
	            
		return startingMolecule;
	}

	private static int calculateFewestNumberOfSteps(List<Pair<String, String>> replacements, String molecule) {
		int count = 0;
		
		while(!molecule.equals("e")) {
			for(Pair<String, String> replacement: replacements) {
				if(molecule.contains(replacement.getRight())) {
					molecule = molecule.replaceFirst(replacement.getRight(), replacement.getLeft());
					count++;
				}
			}
		}
		
		return count;
	}

	private static Pair<String, String> getPairFromLine(String l) {
		int indexEq = l.indexOf("=");
		String left = l.substring(0, indexEq - 1);
		String right = l.substring(indexEq + 3);
		return Pair.of(left, right);
	}
}