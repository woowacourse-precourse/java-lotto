package lotto;

import java.util.ArrayList;
import java.util.List;

public class Print {
	public void printNumberAll(List<ArrayList<Integer>> lottonumbersall, int lottonum) {
		System.out.printf("%d를 구매했습니다.",lottonum);
		for (int i = 0; i < lottonum; i++) {
			System.out.println(lottonumbersall.get(i));
		}
		System.out.println();
	}
	
	public void printWin() {
		
	}
	
	public void countWin() {
		
	}
	
	public void printProfit() {
		
	}
	
	public void printProfitRound() {
		
	}
}
