package lotto;

import java.util.List;

public class ConsoleOut {

	public static void printInputMoney() {
		System.out.println(Constants.PRINT_INPUT_MONEY);
	}

	public static void printLottos(List<Lotto> lottos) {
		for (Lotto lotto : lottos) {
			System.out.println(lotto);
		}
	}
}
