package lotto.system;

import static lotto.constant.Constants.*;

import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSystem {

	List<List<Integer>> lottoGames;
	List<Integer> winNumbers;
	List<Integer> places;

	int money;
	int lottoCount;

	int bonusNumber;
	int firstPlace;
	int secondPlace;
	int thirdPlace;
	int fourthPlace;
	int fifthPlace;

	public LottoSystem() {
		this.firstPlace = 0;
		this.secondPlace = 0;
		this.thirdPlace = 0;
		this.fourthPlace = 0;
		this.fifthPlace = 0;
	}

	public void lottoLogic() {
		try {
			System.out.println(MONEY_INPUT_MESSAGE);
			getMoney();
			getLottoCount();
			System.out.println(lottoCount + PURCHASE_NOTIFICATION);
			lottoGames = Lotto.generateLotto(lottoCount);
			OutputView.printLotto(lottoGames);
			System.out.println(WIN_INPUT_MESSAGE);
			getWinNumbers();
			System.out.println(BONUS_INPUT_MESSAGE);
			getBonusNumber();
			Lotto lotto = new Lotto(winNumbers);
			compare(lotto.getNumbers(), lottoGames, bonusNumber);
			fillPlaces();
			OutputView.printStatistics(places, money);
		} catch (Exception exception){
			System.out.println(exception.getMessage());
		}
	}

	public void getMoney() {
		String inputNumber = Console.readLine();
		try {
			money = Integer.parseInt(inputNumber);
		} catch (Exception exception){
			throw new IllegalArgumentException(INVALID_INPUT);
		}
	}

	public void getLottoCount() {
		lottoCount = money / 1000;
	}

	public void getWinNumbers() {
		String[] inputNumbers = InputView.getLottoNumbers();
		for (String inputNumber : inputNumbers) {
			Validator.isInRange(inputNumber);
		}
		winNumbers = InputView.convertIntoIntegerList(inputNumbers);
		Validator.isListValidate(winNumbers);
		Collections.sort(winNumbers);
	}

	public void getBonusNumber() {
		String inputNumber = Console.readLine();
		Validator.isDuplicate(winNumbers, inputNumber);
		Validator.isInRange(inputNumber);
		try {
			bonusNumber = Integer.parseInt(inputNumber);
		} catch (Exception exception){
			throw new IllegalArgumentException(INVALID_INPUT);
		}
	}

	public void compare(List<Integer> lotto, List<List<Integer>> lottoGames, int bonusNumber) {
		for (List<Integer> lottoGame : lottoGames) {
			int count = 0;
			count = getCount(lotto, lottoGame, count);
			if (count == 6) {
				firstPlace++;
			}
			if (count == 5 && lottoGame.contains(bonusNumber)) {
				secondPlace++;
			}
			if (count == 5 && !lottoGame.contains(bonusNumber)) {
				thirdPlace++;
			}
			if (count == 4) {
				fourthPlace++;
			}
			if (count == 3) {
				fifthPlace++;
			}
		}
	}

	public void fillPlaces() {
		places = List.of(firstPlace, secondPlace, thirdPlace, fourthPlace, fifthPlace);
	}

	private static int getCount(List<Integer> lotto, List<Integer> lottoGame, int count) {
		for (Integer integer : lottoGame) {
			if (lotto.contains(integer)) {
				count++;
			}
		}
		return count;
	}
}
