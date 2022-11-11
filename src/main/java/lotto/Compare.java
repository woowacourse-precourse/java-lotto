package lotto;

import java.util.List;

public class Compare {
	private int[] compareResult = {0, 0, 0, 0, 0};

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
}
