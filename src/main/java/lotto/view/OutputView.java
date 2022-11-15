package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Money;
import lotto.exception.ErrorMessage;

public class OutputView {
	private static final String BUY_LOTTO_MESSAGE = "%d개를 구매했습니다.\n";
	private static final String WIN_MESSAGE = "%d개 일치 (%s원) - %d개\n";
	private static final String BONUS_WIN_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
	private static final String LOTTO_YIELD = "총 수익률은 %.1f%%입니다.";
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###");

	public static void printLottos(List<Lotto> lottos) {
		System.out.printf(BUY_LOTTO_MESSAGE, lottos.size());
		for (Lotto lotto : lottos) {
			printLotto(lotto);
		}
	}

	private static void printLotto(Lotto lotto) {
		System.out.print("[");
		System.out.print(String.join(", ", convertToStringList(lotto.getNumbers())));
		System.out.println("]");
	}

	private static List<String> convertToStringList(List<Integer> numbers) {
		return numbers.stream()
			.sorted()
			.map(number -> Integer.toString(number))
			.collect(Collectors.toList());
	}

	public static void printError(ErrorMessage error) {
		System.out.println(error.getMessage());
	}

	public static void printLottoResults(Map<LottoRank, Integer> results) {
		LottoRank[] values = LottoRank.values();
		for (LottoRank rank : values) {
			printRank(rank, results);
		}

	}

	private static void printRank(LottoRank rank, Map<LottoRank, Integer> results) {

		String winMessage = WIN_MESSAGE;

		if (rank.equals(LottoRank.NON_PRIZE)) {
			return;
		} else if (rank.isCorrectBonus()) {
			winMessage = BONUS_WIN_MESSAGE;
		}

		System.out.printf(winMessage, rank.getNumberCount(), DECIMAL_FORMAT.format(rank.getReward()),
			results.getOrDefault(rank, 0));
	}

	public static void printLottoYield(int revenue, Money money) {
		System.out.printf(LOTTO_YIELD, revenue / (float)money.getAmount() * 100);
	}
}
