package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Print {
	List<ArrayList<Integer>> lottonumbersall;
	int lottonum = 0;
	enum rank { 
		FIRST(6), SECOND(5), THIRD(5), FOURTH(4), FIFTH(3);
		
		private final int value;
	
		rank(int value) {
			this.value = value;
		} 
		
		public int getValue() {
			return this.value;
		}
	};
	
	public void printNumberAll(List<ArrayList<Integer>> lottonumbersall, int lottonum) {
		System.out.printf("%d를 구매했습니다.",lottonum);
		for (int i = 0; i < lottonum; i++) {
			System.out.println(lottonumbersall.get(i));
		}
		this.lottonumbersall = lottonumbersall;
		this.lottonum = lottonum;
		System.out.println();
	}
	
	public void printWin() {
		
	}
	
	public void countWin(List<Integer> inputnumbers, int bonusnumber) {
		HashSet<Integer> inputnumberset = new HashSet<>();  // 사용자 입력값들을 모두 inputnumberset에 담기
		inputnumberset.addAll(inputnumbers);
		inputnumberset.add(bonusnumber);
		
		for (int i =0; i < lottonum; i++) {
			ArrayList<Integer> lotto = new ArrayList<Integer>();  
			HashSet<Integer> lottoset = new HashSet<>();  
			
			lotto = lottonumbersall.get(i);
			lottoset.addAll(lotto);  // 한번 할 때마다 나온 로또 값 6개를 lottoset에 담기
			
			lottoset.retainAll(inputnumberset);
			if (lottoset.size() == rank.FIFTH.getValue()) {
				
			}
		}
	}
	
	public void rankCount() {
		
	}
	
	public void printProfit() {
		
	}
	
	public void printProfitRound() {
		
	}
}
