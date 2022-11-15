package lotto;

import java.util.List;

public class ConsoleOut {

	public static void printEmptyLine() {
		System.out.println();
	}

	public static void printInputMoney() {
		System.out.println(Constants.PRINT_INPUT_MONEY);
	}

	public static void printLottos(List<Lotto> lottos) {
		printEmptyLine();
		System.out.println(lottos.size() + Constants.PRINT_LOTTO_HISTORY);
		for (Lotto lotto : lottos) {
			System.out.println(lotto);
		}
	}

	public static void printInputGoal() {
		printEmptyLine();
		System.out.println(Constants.PRINT_INPUT_GOAL);
	}
}
