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

	public static void printInputBonus() {
		printEmptyLine();
		System.out.println(Constants.PRINT_INPUT_BONUS);
	}

	public static void printStatistic() {
		printEmptyLine();
		System.out.println(Constants.PRINT_STATISTIC);
		System.out.println(Constants.PRINT_LINE);
	}

	public static void printStatisticResult(int[] winLotto, double yield) {
		StringBuilder sb = new StringBuilder();
		sb.append("3개 일치 (5,000원) - ").append(winLotto[5]).append("개\n");
		sb.append("4개 일치 (50,000원) - ").append(winLotto[4]).append("개\n");
		sb.append("5개 일치 (1,500,000원) - ").append(winLotto[3]).append("개\n");
		sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(winLotto[2]).append("개\n");
		sb.append("6개 일치 (2,000,000,000원) - ").append(winLotto[1]).append("개\n");
		sb.append("총 수익률은 ").append(yield).append("%입니다.");

		System.out.println(sb.toString());
	}
}
