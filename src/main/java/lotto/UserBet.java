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
		amount = bettingMoney / EnumNumeric.PRICE_A_POP.getValue();
	}

	public void buyLottos() {
		myLottos = new ArrayList<>();

		while(myLottos.size() < amount) {
			List<Integer> randomLotto = new ArrayList<>();
			randomLotto.addAll(
					Randoms.pickUniqueNumbersInRange(
							EnumNumeric.LOTTO_START.getValue(),
							EnumNumeric.LOTTO_END.getValue(),
							EnumNumeric.LOTTO_NUMBERS_BOUND.getValue()
					)
			);
			Collections.sort(randomLotto);

			myLottos.add(randomLotto);
		}
	}

	public List<List<Integer>> getMyLottos() {
		return myLottos;
	}

	public void printResult() {
		System.out.println(amount + EnumResult.BET_RESULT.getValue());

		for(List<Integer> lottos : myLottos) {
			System.out.println(lottos);
		}
	}
}