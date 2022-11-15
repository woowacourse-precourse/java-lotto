package lotto.view;

import java.util.ArrayList;
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
		for (Lotto lottoTicket : lottoMachine.getLottoTickets()) {
			System.out.println(Arrays.toString(lottoTicket.getLottoNumbers().toArray()));
		}
	}

	public static void printWinningResult(Map<Rank, Integer> scoreBoard) {
		System.out.println(RESULT_HEADER_MESSAGE);

		for (Rank rank : getRanksWithoutMiss()) {
			System.out.printf(
				createWinningResultMessage(rank),
				rank.getHitNumberCount(),
				rank.getPrizeMoneyWithComma(),
				scoreBoard.get(rank));
		}
	}

	public static void printProfitRate(double getProfitRate) {
		System.out.printf(PROFIT_RATE_MESSAGE, getProfitRate);
	}

	private static List<Rank> getRanksWithoutMiss() {
		List<Rank> list = new ArrayList<>(List.of(Rank.values()));
		list.remove(Rank.MISS);
		return list;
	}

	private static String createWinningResultMessage(Rank rank) {
		if (rank == Rank.SECOND) {
			return SECOND_RESULT_MESSAGE;
		}
		return WINNING_RESULT_MESSAGE;
	}
}
