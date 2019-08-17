package y2015.d4;

import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

public class Part12 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String input = "iwrupvqb";
		int num = 0;
		
		long start = System.currentTimeMillis();
		while(true) {
			String md5 = DigestUtils.md5Hex(new StringBuilder().append(input).append(num).toString());
			if(md5.startsWith("00000"))
				break;
			else
				num++;
		}
		System.out.println("Solution to Part1="+num+" found in "+(System.currentTimeMillis()-start)+"ms.");
		
		num = 0;
		start = System.currentTimeMillis();
		while(true) {
			String md5 = DigestUtils.md5Hex(new StringBuilder().append(input).append(num).toString());
			if(md5.startsWith("000000"))
				break;
			else
				num++;
		}
		System.out.println("Solution to Part2="+num+" found in "+(System.currentTimeMillis()-start)+"ms.");
	}

}
