package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class CommonUtils {

	public static List<String> readFileLines(String path){
		InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
		return new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8)).lines().collect(Collectors.toList());
	}
}
