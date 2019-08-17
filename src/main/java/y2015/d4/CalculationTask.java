package y2015.d4;

import java.util.concurrent.Callable;

import org.apache.commons.codec.digest.DigestUtils;

public class CalculationTask implements Callable<Integer> {

	private String seed;
	private int startNum;
	private int endNum;
	
	public CalculationTask(String seed, int startNum, int endNum) {
		this.seed = seed;
		this.startNum = startNum;
		this.endNum = endNum;
	}

	@Override
	public Integer call() throws Exception {
//		System.out.println("Running Task in Thread#"+Thread.currentThread().getName()+"["+startNum+","+endNum+"]");
		
		String md5 = null;
		int start = startNum;
		int end = endNum;
		
		long startTime = System.currentTimeMillis();
		
		for(int i=start; i<=end; i++) {
			md5 = DigestUtils.md5Hex(new StringBuilder().append(seed).append(i).toString());
			if(md5.startsWith("000000")) {
				System.out.println("Thread#"+Thread.currentThread().getName()+" solution found "+i+" in "+(System.currentTimeMillis()-startTime)+"ms.");
				return i;
			}
		}
		
		return -1;
	}
}
