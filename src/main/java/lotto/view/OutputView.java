package lotto.view;

import static lotto.domain.LottoRanking.FIFTH;
import static lotto.domain.LottoRanking.FIRST;
import static lotto.domain.LottoRanking.FOURTH;
import static lotto.domain.LottoRanking.SECOND;
import static lotto.domain.LottoRanking.THIRD;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRanking;

public class OutputView {

	public static final int EMPTY_COUNT = 0;
	private static final String OUTPUT_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
	private static final String OUTPUT_WINNING_STATISTICS = "당첨 통계\n---";
	private static final String OUTPUT_YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.\n";
	private static final String ERROR_LOG_PREFIX = "[ERROR] ";
	private static final Map<LottoRanking, String> LOTTO_RANKING_STRING_MAP = Map.of(
		FIRST, "6개 일치 (2,000,000,000원) - %d개\n",
		SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
		THIRD, "5개 일치 (1,500,000원) - %d개\n",
		FOURTH, "4개 일치 (50,000원) - %d개\n",
		FIFTH, "3개 일치 (5,000원) - %d개\n"
	);

	public void printLottoCount(int lottoCount) {
		System.out.printf(OUTPUT_LOTTO_COUNT_MESSAGE, lottoCount);
	}

	public void printLottoNumbers(List<Lotto> lottos) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Lotto lotto : lottos) {
			stringBuilder.append(lotto);
			stringBuilder.append('\n');
		}
		System.out.print(stringBuilder);
	}

	public void printStatistics(Map<LottoRanking, Integer> winningResult, Double yield) {
		System.out.println(OUTPUT_WINNING_STATISTICS);
		List<LottoRanking> rankings = List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
		for (LottoRanking ranking : rankings) {
			printMatches(winningResult, ranking);
		}
		printYield(yield);
	}

	private void printMatches(Map<LottoRanking, Integer> winningResult, LottoRanking ranking) {
		System.out.printf(LOTTO_RANKING_STRING_MAP.get(ranking), winningResult.getOrDefault(ranking,
			EMPTY_COUNT));
	}

	private void printYield(Double yield) {
		System.out.printf(OUTPUT_YIELD_MESSAGE, yield);
	}

	public void printNewLine() {
		System.out.println();
	}

	public void logErrorMessage(String errorMessage) {
		System.out.println(ERROR_LOG_PREFIX + errorMessage);
	}
}
