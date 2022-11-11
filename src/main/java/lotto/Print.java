package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Print {
	List<List<Integer>> lottonumbersall = new ArrayList<>();
	int lottonum = 0;
	int bonusnumber = 0;
	int purchaseprice = 0;
	enum rank { 
		FIFTH(3,5000), FOURTH(4,50000), THIRD(5,1500000), SECOND(5,30000000), FIRST(6,2000000000);
		
		private final int value;
		private final int price;
		
		rank(int value, int price) {
			this.value = value;
			this.price = price;
		} 
		
		public int getValue() {
			return this.value;
		}
		
		public int getPrice() {
			return this.price;
		}
	};
	HashMap<Integer, Integer> rankmap = new HashMap<>();
	
	public void printNumberAll(List<List<Integer>> lottonumbersall, int lottonum, int purchaseprice) {
		System.out.printf("%d개를 구매했습니다.\n",lottonum);
		for (int i = 0; i < lottonum; i++) {
			System.out.println(lottonumbersall.get(i));
		}
		this.lottonumbersall = lottonumbersall;
		this.lottonum = lottonum;
		this.purchaseprice = purchaseprice;
		System.out.println();
	}
	
	public void printWin() {
		int ranknum = 5;
		System.out.println("당첨 통계");
		System.out.println("---");
		for (rank r : rank.values()) {
			if (ranknum == 2) {
				System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개\n", r.getValue(), r.getPrice(), rankmap.getOrDefault(ranknum, 0));
				ranknum--;
				continue;
			}
			System.out.printf("%d개 일치 (%d원) - %d개\n", r.getValue(), r.getPrice(), rankmap.getOrDefault(ranknum, 0));
			ranknum--;
		}
	}
	
	public void countWin(List<Integer> inputnumbers, int bonusnumber) {
		this.bonusnumber = bonusnumber;
		HashSet<Integer> inputnumberset = new HashSet<>();  // 사용자 입력값들을 모두 inputnumberset에 담기
		inputnumberset.addAll(inputnumbers);
		inputnumberset.add(bonusnumber);
		
		for (int i =0; i < lottonum; i++) {
			List<Integer> lotto = new ArrayList<Integer>();  
			HashSet<Integer> lottoset = new HashSet<>();  
			
			lotto = lottonumbersall.get(i);
			lottoset.addAll(lotto);  // 한번 할 때마다 나온 로또 값 6개를 lottoset에 담기
			
			lottoset.retainAll(inputnumberset);
			rankCount(lotto, lottoset);
		}
	}
	
	public void rankCount(List<Integer> lotto, HashSet<Integer> lottoset) {
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
	
	public double printProfit() {
		double profit = 0;
		int ranknum = 5;
		for (rank r : rank.values()) {
			double price = 0;
			price = rankmap.get(ranknum) * r.getPrice();
			profit += price;
			ranknum--;
		}
		profit = profit / purchaseprice;
		return profit;
	}
	
	public void printProfitRound(double profit) {
		System.out.printf("총 수익률은 %f.2%%입니다.", profit);
	}
}
