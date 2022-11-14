package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoProgram {

	Exception exception = new Exception();
	Lotto lotto;
	MessagePrint messagePrint = new MessagePrint();
	List<List<Integer>> randomNumbers = new ArrayList<>();
	List<Integer> lottoNumbers = new ArrayList<>();
	int count = 0;
	int bonusNum;

	public int conversion(String input) {
		return Integer.parseInt(input);
	}

	public void purchaseLotto() {
		messagePrint.purchaseLottoPrint();
		String inputPrice = Console.readLine();
		checkPrize(inputPrice);
		messagePrint.countLottoPrint(inputPrice);
		for (int i = 0; i < countLotto(inputPrice); i++) {
			randomNumbers.add(Randoms.pickUniqueNumbersInRange(Constants.START_INCLUSIVE, Constants.END_INCLUSIVE, 6));
		}
	}

}