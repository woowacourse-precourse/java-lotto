package lotto;

import java.util.List;

public class Compare {
	private int[] compareResult = {0, 0, 0, 0, 0};
	private int sum;
	private String yield;

	public Compare() {}

	public void compareNumbers(List<List<Integer>> myLottos, List<Integer> winningNumbers, int bonusNumber) {
		for(List<Integer> myLotto : myLottos) {
			int hitCount = 0;

			for(int winningNumber : winningNumbers) {
				hitCount += isContains(myLotto, winningNumber);
			}

			setResult(hitCount, myLotto, bonusNumber);
		}
	}

	public int isContains(List<Integer> myLotto, int winningNumber) {
		if(myLotto.contains(winningNumber)) {
			return 1;
		}

		return 0;
	}

	public void setResult(int hitCount, List<Integer> myLotto, int bonusNumber) {
		setFirst(hitCount);
		setSecond(hitCount, myLotto, bonusNumber);
		setThird(hitCount, myLotto, bonusNumber);
		setFourth(hitCount);
		setFifth(hitCount);
	}

	public void setFirst(int hitCount) {
		if(hitCount == 6) {
			compareResult[0]++;
		}
	}

	public void setSecond(int htiCount, List<Integer> myLotto, int bonusNumber) {
		if(htiCount == 5 && myLotto.contains(bonusNumber)) {
			compareResult[1]++;
		}
	}

	public void setThird(int hitCount, List<Integer> myLotto, int bonusNumber) {
		if(hitCount == 5 && !myLotto.contains(bonusNumber)) {
			compareResult[2]++;
		}
	}

	public void setFourth(int hitCount) {
		if(hitCount == 4) {
			compareResult[3]++;
		}
	}

	public void setFifth(int hitCount) {
		if(hitCount == 3) {
			compareResult[4]++;
		}
	}

	public void sumWinnings() {
		sum = (2_000_000_000 * compareResult[0]) +
				(30_000_000 * compareResult[1]) +
				(1_500_000 * compareResult[2]) +
				(50_000 * compareResult[3]) +
				(5_000 * compareResult[4]);
	}

	public void figureYield(int bettingMoney) {
		yield = String.format("%.1f", (double) 100 * sum / bettingMoney);
	}

	public void printResult() {
		System.out.println("\n당첨 통계\n---");
		System.out.println("3개 일치 (5,000원) - " + compareResult[4] + "개");
		System.out.println("4개 일치 (50,000원) - " + compareResult[3] + "개");
		System.out.println("5개 일치 (1,500,000원) - " + compareResult[2] + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + compareResult[1] + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + compareResult[0] + "개");
		System.out.println("총 수익률은 " + yield + "%입니다.");
	}
}
