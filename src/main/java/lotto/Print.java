package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Print {
	List<ArrayList<Integer>> lottonumbersall;
	int lottonum = 0;
	int bonusnumber = 0;
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
	HashMap<Integer, Integer> rankmap = new HashMap<>();
	
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
		this.bonusnumber = bonusnumber;
		HashSet<Integer> inputnumberset = new HashSet<>();  // 사용자 입력값들을 모두 inputnumberset에 담기
		inputnumberset.addAll(inputnumbers);
		inputnumberset.add(bonusnumber);
		
		for (int i =0; i < lottonum; i++) {
			ArrayList<Integer> lotto = new ArrayList<Integer>();  
			HashSet<Integer> lottoset = new HashSet<>();  
			
			lotto = lottonumbersall.get(i);
			lottoset.addAll(lotto);  // 한번 할 때마다 나온 로또 값 6개를 lottoset에 담기
			
			lottoset.retainAll(inputnumberset);
			rankCount(lotto, lottoset);
		}
	}
	
	public void rankCount(ArrayList<Integer> lotto, HashSet<Integer> lottoset) {
		int count = 0;
		if (lottoset.size() == rank.FIFTH.getValue()) {
			count = rankmap.getOrDefault(5, 0) + 1;
			rankmap.put(5, count);
		} else if (lottoset.size() == rank.FOURTH.getValue()) {
			count = rankmap.getOrDefault(4, 0) + 1;
			rankmap.put(4, count);
		} else if (lottoset.size() == rank.THIRD.getValue()) {
			if (lotto.contains(bonusnumber)) {
				count = rankmap.getOrDefault(2, 0) + 1;
				rankmap.put(2, count);
				return;
			}
			count = rankmap.getOrDefault(3, 0) + 1;
			rankmap.put(3, count);
		} else if (lottoset.size() == rank.FIRST.getValue()) {
			count = rankmap.getOrDefault(1, 0) + 1;
			rankmap.put(1, count);
		} 
	}
	
	public void printProfit() {
		
	}
	
	public void printProfitRound() {
		
	}
}
