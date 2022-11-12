package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Rank;

public class OutputView {
	private static final String NUMBER_OF_TICKETS_MESSAGE = "%d개를 구매했습니다.%n";
	private static final String WINNING_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개%n";
	private static final String SECOND_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
	private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.%n";
	private static final String RESULT_HEADER_MESSAGE = "당첨 통계\n---";

	private OutputView() {
	}

	public static void printNumberOfTickets(int getNumberOfTickets) {
		System.out.printf(NUMBER_OF_TICKETS_MESSAGE, getNumberOfTickets);
	}

	public static void printLottoTickets(LottoMachine lottoMachine) {
		for (Lotto lottoTickets : lottoMachine.getLottoTickets()) {
			System.out.println(Arrays.toString(lottoTickets.getNumbers().toArray()));
		}
	}

	public static void printWinningResult(Map<Rank, Integer> getRanks) {
		System.out.println(RESULT_HEADER_MESSAGE);

		List<Rank> rankValue = List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
		for (Rank ranking : rankValue) {
			System.out.printf(
				createWinningResultMessage(ranking),
				ranking.getHitNumberCount(),
				ranking.getPrizeMoneyWithComma(),
				getRanks.get(ranking));
		}
	}

	public static void printProfitRate(double getProfitRate) {
		System.out.printf(PROFIT_RATE_MESSAGE, getProfitRate);
	}

	private static String createWinningResultMessage(Rank ranking) {
		if (ranking == Rank.SECOND) {
			return SECOND_RESULT_MESSAGE;
		}
		return WINNING_RESULT_MESSAGE;
	}

}
