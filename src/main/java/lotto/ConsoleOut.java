package lotto;

import java.util.List;

public class ConsoleOut {

	public static void printInputMoney() {
		System.out.println(Constants.PRINT_INPUT_MONEY);
	}

	public static void printLottos(List<Lotto> lottos) {
		System.out.println();
		System.out.println(lottos.size() + Constants.PRINT_LOTTO_HISTORY);
		for (Lotto lotto : lottos) {
			System.out.println(lotto);
		}
	}
}
