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

	private static final String OUTPUT_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
	private static final String OUTPUT_WINNING_STATISTICS = "당첨 통계\n---";

	private static final Map<LottoRanking, String> LOTTO_RANKING_STRING_MAP = Map.of(
		FIRST, "6개 일치 (2,000,000,000원) - ",
		SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
		THIRD, "5개 일치 (1,500,000원) - ",
		FOURTH, "4개 일치 (50,000원) - ",
		FIFTH, "3개 일치 (5,000원) - "
	);

	public void printLottoCount(int lottoCount) {
		System.out.println(lottoCount + OUTPUT_LOTTO_COUNT_MESSAGE);
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
		System.out.println(
			LOTTO_RANKING_STRING_MAP.get(ranking) + winningResult.getOrDefault(ranking, 0) + "개");
	}

	private void printYield(Double yield) {
		String roundYield = String.format("%.1f", yield);
		System.out.println("총 수익률은 " + roundYield + "%입니다.");
	}

	public void printNewLine() {
		System.out.println();
	}

	public void printErrorMessage(String errorMessage) {
		System.out.println(errorMessage);
	}
}
