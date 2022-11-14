package lotto.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Print {
	List<List<Integer>> lottoNumbersAll = new ArrayList<>();
	int lottoNum = 0;
	int bonusNumber = 0;
	int purchasePrice = 0;

	enum rank {
		FIFTH(3, 5000), FOURTH(4, 50000), THIRD(5, 1500000), SECOND(5, 30000000), FIRST(6, 2000000000);

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

	public void printNumberAll(List<List<Integer>> lottoNumbersAll, int lottoNum, int purchasePrice) {
		System.out.printf("%d개를 구매했습니다.\n", lottoNum);

		for (int i = 0; i < lottoNum; i++) {
			System.out.println(lottoNumbersAll.get(i));
		}

		this.lottoNumbersAll = lottoNumbersAll;
		this.lottoNum = lottoNum;
		this.purchasePrice = purchasePrice;

		System.out.println();
	}

	public void printWin() {
		int rankNum = 5;
		DecimalFormat df = new DecimalFormat("#,###");

		System.out.println("당첨 통계");
		System.out.println("---");

		for (rank r : rank.values()) {
			if (rankNum == 2) {
				System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", r.getValue(), df.format(r.getPrice()),
						rankmap.getOrDefault(rankNum, 0));
				rankNum--;
				continue;
			}
			System.out.printf("%d개 일치 (%s원) - %d개\n", r.getValue(), df.format(r.getPrice()),
					rankmap.getOrDefault(rankNum, 0));
			rankNum--;
		}
	}

	public void countWin(List<Integer> inputNumbers, int bonusNumber) {
		this.bonusNumber = bonusNumber;
		HashSet<Integer> inputnumberset = new HashSet<>(); // 사용자 입력값들을 모두 inputnumberset에 담기
		inputnumberset.addAll(inputNumbers);

		for (int i = 0; i < lottoNum; i++) {
			List<Integer> lotto = new ArrayList<Integer>();
			HashSet<Integer> lottoset = new HashSet<>();

			lotto = lottoNumbersAll.get(i);
			lottoset.addAll(lotto); // 한번 할 때마다 나온 로또 값 6개를 lottoset에 담기

			lottoset.retainAll(inputnumberset);
			countRank(lotto, lottoset);
		}
	}

	public void countRank(List<Integer> lotto, HashSet<Integer> lottoSet) {
		int count = 0;
		if (lottoSet.size() == rank.FIFTH.getValue()) {
			count = rankmap.getOrDefault(5, 0) + 1;
			rankmap.put(5, count);
		} else if (lottoSet.size() == rank.FOURTH.getValue()) {
			count = rankmap.getOrDefault(4, 0) + 1;
			rankmap.put(4, count);
		} else if (lottoSet.size() == rank.THIRD.getValue()) {
			if (lotto.contains(bonusNumber)) {
				count = rankmap.getOrDefault(2, 0) + 1;
				rankmap.put(2, count);
				return;
			}
			count = rankmap.getOrDefault(3, 0) + 1;
			rankmap.put(3, count);
		} else if (lottoSet.size() == rank.FIRST.getValue()) {
			count = rankmap.getOrDefault(1, 0) + 1;
			rankmap.put(1, count);
		}
	}

	public double printProfit() {
		double profit = 0;
		int rankNum = 5;
		for (rank r : rank.values()) {
			double price = 0;

			price = rankmap.getOrDefault(rankNum, 0) * r.getPrice();
			profit += price;
			rankNum--;
		}
		profit = profit / purchasePrice;
		return profit * 100;
	}

	public void printProfitRound(double profit) {
		double profitResult = 0f;

		profitResult = Math.round(profit * 10) / 10.0;

		System.out.printf("총 수익률은 %.1f%%입니다.", profitResult);
	}
}
