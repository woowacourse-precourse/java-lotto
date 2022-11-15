package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import lotto.ui.Constants;
import lotto.ui.Display;
import lotto.ui.View;
import lotto.Lotto;

public class Controller {

	private User user;
	private List<Lotto> generatedLotto;
	private HashMap<Integer, Integer> rank = new HashMap<>();


	public void playLotto() {
		View.printInputMoney();
		inputMoney();
		generateLotto();
		View.printCount(user.money % Constants.LOTTO_PRICE);
		View.printGeneratedLotto(generatedLotto);
		inputWinning();
		View.printInputWinning();
		inputBonus();
		View.printInputBonus();
		checkRank(user.winningNumber);
		View.printResult();
	}
	public void generateLotto() {
		List<Integer> lottoNum = Randoms.pickUniqueNumbersInRange(Constants.MIN, Constants.MAX, Constants.COUNT);
		Collections.sort(lottoNum);
		Lotto lotto = new Lotto(lottoNum);
		generatedLotto.add(lotto);
	}

	public void inputMoney() {
		user.money = Integer.parseInt(Console.readLine());
		validateMoney(user.money);
	}

	public void inputWinning() {
		String[] winningNums = Console.readLine().split(",");
		List<Integer> winNums = new ArrayList<>();
		for(String winingNum : winningNums) {
			winNums.add(Integer.parseInt(winingNum));
		}
		user.winningNumber = new Lotto(winNums);
	}

	public void inputBonus() {
		user.bonusNumber = Integer.parseInt(Console.readLine());
		Lotto.validateNum(user.bonusNumber);
	}

	public int checkRank() {
		int match = 0;
		for(Lotto lottoNums : generatedLotto) {
			match = matchCount(lottoNums);
		}
	}
	public int matchCount(Lotto lottoNums) {
		int count = 0;
		for(Integer num : lottoNums.getNumbers()) {
			if(user.winningNumber.getNumbers().contains(num))
				count++;
		}
		if()
		return count;
	}
	private int matchBonus(Lotto lottoNums) {
		if(lottoNums.getNumbers().contains(user.bonusNumber)) {

		}
	}

	private void validateMoney(int money) {
		if (money % Constants.LOTTO_PRICE != 0) {
			throw new IllegalArgumentException("1000원 이외의 단위로는 로또를 구매하실 수 없습니다");
		}
	}


}
