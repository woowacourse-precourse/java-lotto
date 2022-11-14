package lotto;

import static lotto.LottoRank.*;

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
		checkMoney(inputmoney);
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
		exception.checkInputSize(splitLottoNumber, Constant.LOTTO_LENGTH);
		for (int i = 0; i < Constant.LOTTO_LENGTH; i++) {
			checkUserNumber(splitLottoNumber[i]);
			lottoNumber.add(Integer.parseInt(splitLottoNumber[i]));
		}
		return lottoNumber;
	}

	public void inputLotto(List<Integer> lottoNumber) {
		lotto = new Lotto(lottoNumber);
	}

	public void inputLottoBonusNumber() {
		String number = Console.readLine();
		checkbonusNumber(number);
		bonusLotto.setBonus(Integer.parseInt(number));
	}

	public void numberCompareAferStore() {
		for (List<Integer> onePurchaseLotto : purchaseLotto) {
			for (int i = 0; i < lotto.getNumbers().size(); i++) {
				checkNumberSame(lotto.getNumbers().get(i), onePurchaseLotto);
			}
			checkBonusNumberSame(bonusLotto.getBonus(), onePurchaseLotto);
			checkRank(numberCount.getGuess(), numberCount.getBonusGuess());
			numberCount.setCount();
		}
	}

	public void setPrize() {
		prize.put(FIRST_PLACE.getWinnerPrize(), 0);
		prize.put(SECOND_PLACE.getWinnerPrize(), 0);
		prize.put(THIRD_PLACE.getWinnerPrize(), 0);
		prize.put(FOURTH_PLACE.getWinnerPrize(), 0);
		prize.put(FIFTH_PLACE.getWinnerPrize(), 0);
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

	public void checkRank(int guess, int bonusGuess) {
		if (guess == 6)
			prize.put(FIRST_PLACE.getWinnerPrize(), prize.get(FIRST_PLACE.getWinnerPrize()) + 1);
		if (guess == 5 && bonusGuess == 1)
			prize.put(LottoRank.SECOND_PLACE.getWinnerPrize(), prize.get(SECOND_PLACE.getWinnerPrize()) + 1);
		if (guess == 5 && bonusGuess != 1)
			prize.put(LottoRank.THIRD_PLACE.getWinnerPrize(), prize.get(THIRD_PLACE.getWinnerPrize()) + 1);
		if (guess == 4)
			prize.put(LottoRank.FOURTH_PLACE.getWinnerPrize(), prize.get(FOURTH_PLACE.getWinnerPrize()) + 1);
		if (guess == 3)
			prize.put(LottoRank.FIFTH_PLACE.getWinnerPrize(), prize.get(FIFTH_PLACE.getWinnerPrize()) + 1);
	}

	public int totalPrize() {
		int total = 0;
		for (int key : prize.keySet()) {
			total += key * prize.get(key);
		}
		return total;
	}

	public double yield() {
		return Math.round((double)totalPrize() / money * 1000) / 10.0;
	}

	public void checkUserNumber(String splitLottoNumber) {
		exception.checkMissMatch(splitLottoNumber);
		exception.checkNumberSize(splitLottoNumber);
	}

	public void checkbonusNumber(String number) {
		exception.checkMissMatch(number);
		exception.checkNumberSize(number);
		exception.chackBonusNumberSameLottoNumber(number, lotto.getNumbers());
	}

	public void checkMoney(String inputMoney) {
		exception.checkMissMatch(inputMoney);
		exception.checkMoneySize(inputMoney);
		exception.checkUnitMoney(inputMoney, Constant.PRICE);
	}
}