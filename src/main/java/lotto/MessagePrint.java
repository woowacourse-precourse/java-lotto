package lotto;

import java.text.NumberFormat;
import java.util.List;
import java.util.SortedMap;

public class MessagePrint {

	public void purchaseLottoPrint() {
		System.out.println(Constants.PURCHASE_PRIZE_MESSAGE);
	}

	public void changeList(List<Integer> list) {
		System.out.println(list);
	}

	public void countLottoPrint(String inputPrice) {
		LottoProgram lottoProgram = new LottoProgram();
		System.out.println(lottoProgram.countLotto(inputPrice) + Constants.COUNT_LOTTO_PRINT);
	}

	public void inputWinNumPrint() {
		System.out.println(Constants.INPUT_LOTTO_NUMBER_PRINT);
	}

	public void inputBonusNumPrint() {
		System.out.println(Constants.INPUT_BONUS_NUMBER_PRINT);
	}
}
