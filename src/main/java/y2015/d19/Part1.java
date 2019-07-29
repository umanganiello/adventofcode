package y2015.d19;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

public class Part1 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String inputFilePath = "input/2015/19/input.txt";
		List<Pair<String, String>> replacements = readReplacementsFromInputFile(inputFilePath);
		String startingMolecule = readStartingMoleculeFromInputFile(inputFilePath);
		
		Set<String> distinctMolecules = calculateAllDistinctMolecules(replacements, startingMolecule);
		System.out.println("Result: " + distinctMolecules.size() + " - in " + (System.currentTimeMillis()-startTime) + " ms");
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

	private static Set<String> calculateAllDistinctMolecules(List<Pair<String, String>> replacements, String startingMolecule) {
		Set<String> distinctMolecules = new HashSet<String>();
		replacements.forEach(r -> addDistinctMoleculesForSpecificReplacement(distinctMolecules, startingMolecule, r));
		return distinctMolecules;
	}

	private static void addDistinctMoleculesForSpecificReplacement(Set<String> distinctMolecules, String startingMolecule, Pair<String, String> replacement) {
		if(startingMolecule.contains(replacement.getLeft())) {
			StringBuilder sb = new StringBuilder(startingMolecule);
			
			int index = startingMolecule.indexOf(replacement.getLeft());
			
			while(index != -1) {
				sb.replace(index, index + replacement.getLeft().length(), replacement.getRight());
				distinctMolecules.add(sb.toString());
				index = startingMolecule.indexOf(replacement.getLeft(), index + 1);
				sb = new StringBuilder(startingMolecule);
			}
		}
	}
	
	private static Pair<String, String> getPairFromLine(String l) {
		int indexEq = l.indexOf("=");
		String left = l.substring(0, indexEq - 1);
		String right = l.substring(indexEq + 3);
		return Pair.of(left, right);
	}
}