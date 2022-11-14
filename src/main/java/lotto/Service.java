package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;

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

}
