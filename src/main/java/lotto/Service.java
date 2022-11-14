package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Service {
	LottoException exception = new LottoException();
	NumberCount numberCount = new NumberCount();
	BonusLotto bonusLotto = new BonusLotto();
	Lotto lotto;
	List<Integer> lottoNumber = new ArrayList<>();
	List<List<Integer>> purchaseLotto = new ArrayList<>();
	Map<Integer, Integer> prize = new HashMap<>();
	int count;
	int money;

	public void userInputMoney() {
		String inputmoney = Console.readLine();
		money = (Integer.parseInt(inputmoney));
		count = (Integer.parseInt(inputmoney) / Constant.PRICE);
	}

	public void lottoIssued() {
		for (int i = 0; i < count; i++) {
			purchaseLotto.add(Randoms.pickUniqueNumbersInRange(1, 45, Constant.LOTTO_LENGTH));
		}
	}

	public List<Integer> userInputNumber() {
		String number = Console.readLine();
		String[] splitLottoNumber = number.split(",");
		for (int i = 0; i < Constant.LOTTO_LENGTH; i++) {
			lottoNumber.add(Integer.parseInt(splitLottoNumber[i]));
		}
		return lottoNumber;
	}

	public void inputLotto(List<Integer> lottoNumber) {
		lotto = new Lotto(lottoNumber);
	}

	public void inputLottoBonusNumber() {
		String number = Console.readLine();
		bonusLotto.setBonus(Integer.parseInt(number));
	}

	public void numberComparAferStore() {
		for (List<Integer> onePurchaseLotto : purchaseLotto) {
			for (int i = 0; i < lotto.getNumbers().size(); i++) {
				checkNumberSame(lotto.getNumbers().get(i), onePurchaseLotto);
			}
			checkBonusNumberSame(bonusLotto.getBonus(), onePurchaseLotto);
		}
	}

	public void checkNumberSame(int number, List<Integer> onePurchaseLotto) {
		if (onePurchaseLotto.contains(number)) {
			numberCount.guessCount();
		}
	}

	public void checkBonusNumberSame(int bonus, List<Integer> onePurchaseLotto) {
		if (onePurchaseLotto.contains(bonus)) {
			numberCount.bonusGuessCount();
			System.out.println(numberCount.getBonusGuess());
		}
	}

}