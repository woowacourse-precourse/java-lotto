package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserBet {
	private int bettingMoney;
	private int amount;

	private List<List<Integer>> myLottos;

	public UserBet(String userInput){
		bettingMoney = Integer.parseInt(userInput);
		checkAmount();
		buyLottos();
		printResult();
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
			List<Integer> randomLotto = new ArrayList<>();
			randomLotto.addAll(Randoms.pickUniqueNumbersInRange(1, 45, 6));
			Collections.sort(randomLotto);

			myLottos.add(randomLotto);
		}
	}

	public List<List<Integer>> getMyLottos() {
		return myLottos;
	}

	public void printResult() {
		System.out.println(amount + "개를 구매했습니다.");

		for(List<Integer> lottos : myLottos) {
			System.out.println(lottos);
		}
	}
}