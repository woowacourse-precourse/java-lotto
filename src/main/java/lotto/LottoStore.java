package lotto;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class LottoStore {

	private int moneyBuyLotto;
	private List<Lotto> lottos;
	private boolean[] goal;
	private int bonusNumber;
	private int[] winLotto;
	private double yield;

	public LottoStore() {
		moneyBuyLotto = 0;
		lottos = new ArrayList<>();
		bonusNumber = 0;
		winLotto = new int[Constants.LOTTO_MINIMUM_RANK + 1];
		yield = 0.0;
	}

	public void open(){
		try {
			buy();
			publish();
			win();
			bonus();
			checkWin();
			calcYield();
			statistic();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private void buy(){
		ConsoleOut.printInputMoney();
		moneyBuyLotto = Util.strToInt(ConsoleIn.readLine());
		Verify.verifyMoneyUnit(moneyBuyLotto);
	}

	private void publish() {
		int numLotto = moneyBuyLotto / Constants.MINIMUM_MONEY_UNIT;
		severalLottoPublish(numLotto);
		ConsoleOut.printLottos(lottos);
	}

	private void severalLottoPublish(int numLotto) {
		for (int num = 1; num <= numLotto; num++) {
			List<Integer> numbers = Util.pickUniqueNumbersInRange(Constants.LOTTO_UNDER_BOUNDARY,
					Constants.LOTTO_UPPER_BOUNDARY,
					Constants.LOTTO_LENGTH);
//			Collections.sort(numbers);
			Lotto lotto = new Lotto(numbers);
			lottos.add(lotto);
		}
	}

	private void win() {
		ConsoleOut.printInputGoal();
		List<Integer> inputGoal = ConsoleIn.readGoal();
		Verify.verifyGoal(inputGoal);
		goal = makeGoal(inputGoal);
	}

	private boolean[] makeGoal(List<Integer> inputGoal) {
		boolean[] goal = new boolean[Constants.LOTTO_UPPER_BOUNDARY + 1];

		for (Integer number : inputGoal) {
			goal[number] = true;
		}

		return goal;
	}

	private void bonus() {
		ConsoleOut.printInputBonus();
		bonusNumber = Util.strToInt(ConsoleIn.readLine());
		Verify.verifyBonus(bonusNumber, goal);
	}

	private void checkWin() {
		for (Lotto lotto : lottos) {
			winLotto[lotto.checkWin(goal, bonusNumber)] += 1;
		}
	}

	private void calcYield() {
		long price = calcPrice(winLotto);
		yield = price * Constants.PERCENT / (double)moneyBuyLotto ;
		yield = Math.round(yield * 100) / 100.0;
	}

	private long calcPrice(int[] winLotto) {
		long price = 0;
		for (int rank = Constants.LOTTO_HIGHEST_RANK; rank <= Constants.LOTTO_MINIMUM_RANK; rank++) {
			int numRank = winLotto[rank];

			price += getPrice(rank, numRank);
		}
		return price;
	}

	private long getPrice(int rank, int numRank) {
		long price = 0;
		for (Rank rankEnum : Rank.values()) {
			if (rank == rankEnum.getRanking()) {
				price = rankEnum.getPrice() * numRank;
				break;
			}
		}
		return price;
	}

	private void statistic() {
		ConsoleOut.printStatistic();
		ConsoleOut.printStatisticResult(winLotto, yield);
	}
}