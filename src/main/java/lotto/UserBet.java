package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class UserBet {
	private int bettingMoney;
	private int amount;

	private List<List<Integer>> myLottos;

	public UserBet(String userInput){
		bettingMoney = Integer.parseInt(userInput);
	}

	public int getBettingMoney() {
		return bettingMoney;
	}

	public void checkAmount() {
		amount = bettingMoney / 1000;
	}

	public int getAmount() {
		return amount;
	}

	public void buyLottos() {
		myLottos = new ArrayList<>();

		while(myLottos.size() < amount) {
			List<Integer> randomLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);

			myLottos.add(randomLotto);
		}
	}
}