package lotto;

import java.util.ArrayList;
import java.util.List;


public class LottoStore {

	private int moneyBuyLotto;
	private List<Lotto> lottos;
	private boolean[] goal;
	private int bonusNumber;

	public LottoStore() {
		moneyBuyLotto = 0;
		lottos = new ArrayList<>();
		bonusNumber = 0;
	}

	public void open() {
		buy();
		publish();
		win();
		bonus();
		checkWin();
	}

	private void buy() {
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
			Lotto lotto = new Lotto(
					Util.pickUniqueNumbersInRange(Constants.LOTTO_UNDER_BOUNDARY, Constants.LOTTO_UPPER_BOUNDARY,
							Constants.LOTTO_LENGTH));
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
//			checkLotto(lotto);
		}
	}
}