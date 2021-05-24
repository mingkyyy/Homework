package Day0524;

import java.util.TreeSet;

public class Homework2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		
		for(int i=0; lotto.size()<6; ++i) {
			lotto.add((int)(Math.random()*45)+1);
		}
		System.out.println(lotto);

	}

}
