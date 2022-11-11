package lotto.view;

import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
	private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
	private static final String PRINT_LOTTO_QUANTITY = "\n%d개를 구매했습니다.\n";
	private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
	private static final String PRINT_WINNING_STATS_MESSAGE = "\n당첨 통계\n---";
	private static final String PRINT_WINNING_RANK = "%d개 일치 (%d원) - %d개\n";
	private static final String PRINT_WINNING_2ND_RANK = "%d개 일치, 보너스 볼 일치 (%d원) - %d개\n";

	public static void printAmountMessage() {
		System.out.println(INPUT_AMOUNT_MESSAGE);
	}

	public static void printWinningNumberMessage() {
		System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
	}

	public static void printAllLottoNumber(List<Lotto> lottos) {
		System.out.printf(PRINT_LOTTO_QUANTITY, lottos.size());
		lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
	}

	public static void printBonusNumberMessage() {
		System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
	}

	public static void printStats() {
		System.out.println(PRINT_WINNING_STATS_MESSAGE);
	}

	public static void printRankCount(Map.Entry<Rank, Integer> stat) {
		System.out.printf(PRINT_WINNING_RANK, stat.getKey().getSameWinningNumberCount(), stat.getKey().getReward(),
			stat.getValue());
	}

	public static void printSecondRankCount(Map.Entry<Rank, Integer> stat) {
		System.out.printf(PRINT_WINNING_2ND_RANK, stat.getKey().getSameWinningNumberCount(), stat.getKey().getReward(),
			stat.getValue());
	}
}
