package lotto.system;

import static lotto.constant.Constants.*;

import java.util.List;

import lotto.view.NewInputView;
import lotto.view.OutputView;

public class NewLottoSystem {

	List<List<Integer>> lottoGames;
	List<Integer> places;
	int lottoCount;
	int firstPlace;
	int secondPlace;
	int thirdPlace;
	int fourthPlace;
	int fifthPlace;

	public NewLottoSystem() {
		this.firstPlace = 0;
		this.secondPlace = 0;
		this.thirdPlace = 0;
		this.fourthPlace = 0;
		this.fifthPlace = 0;
	}

	public void lottoLogic() {
		try {
			NewInputView input = new NewInputView();
			System.out.println(MONEY_INPUT_MESSAGE);
			input.getMoney();
			getLottoCount(input.money);
			System.out.println(lottoCount + PURCHASE_NOTIFICATION);
			lottoGames = Lotto.generateLotto(lottoCount);
			OutputView.printLotto(lottoGames);
			System.out.println(WIN_INPUT_MESSAGE);
			input.getWinNumbers();
			System.out.println(BONUS_INPUT_MESSAGE);
			input.getBonusNumber();
			Lotto lotto = new Lotto(input.winNumbers);
			compare(lotto.getNumbers(), lottoGames, input.bonusNumber);
			fillPlaces();
			OutputView.printStatistics(places, input.money);
		} catch (Exception exception){
			System.out.println(exception.getMessage());
		}
	}

	public void getLottoCount(int money) {
		lottoCount = money / 1000;
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
