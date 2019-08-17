package y2015.d4;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Part12MultiThread {

	public static void main(String[] args) throws NoSuchAlgorithmException, InterruptedException, ExecutionException {
		String input = "iwrupvqb";
		int checksPerThread = 200000;
		
		ExecutorService executor = Executors.newFixedThreadPool(6);
        List<Future<Integer>> resultList = new LinkedList<Future<Integer>>();
        
        for(int i=0; i<100; i++) {
        	int start = i*checksPerThread;
        	int end = start+checksPerThread-1;
        	Future<Integer> result = executor.submit(new CalculationTask(input, start, end));
        	resultList.add(result);	
        }
        
        executor.shutdown();
	}

}
