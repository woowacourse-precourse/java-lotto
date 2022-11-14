package lotto.view;

import java.util.Map.Entry;

import lotto.domain.LottoGameResult;
import lotto.domain.Rank;
import lotto.ticket.LottoTicket;
import lotto.ticket.LottoTickets;

public class OutputView {

	private static final String DEFAULT_RANK_PRINT_FORMAT = "%d개 일치 (%d원)- %d개";
	private static final String BONUS_RANK_PRINT_FORMAT = "%d개 일치, 보너스 볼 일치(%d원) - %d개";

	public static void printLottoTickets(final LottoTickets lottoTickets) {
		System.out.println(lottoTickets.size() + "개를 구매했습니다.");
		lottoTickets.getPrint();
		System.out.println();
	}

	public static void printLottoGameResult(final LottoGameResult lottoGameResult) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---------");
		for (Entry<Rank, Integer> rank : lottoGameResult.getRanks().entrySet()) {
			System.out.println(printLottoRank(rank.getKey(), rank.getValue()));
		}
	}

	private static String printLottoRank(Rank rank, Integer count) {
		if (rank.isBonusMatch()) {
			return String.format(BONUS_RANK_PRINT_FORMAT,
					rank.getMatchCount(), rank.getPrice(), count);
		}
		return String.format(DEFAULT_RANK_PRINT_FORMAT,
				rank.getMatchCount(), rank.getPrice(), count);
	}

	public static void printLottoGameYield(final double yield) {
		System.out.format("총 수익률은 %.1f%입니다.", yield);
		System.out.println();
	}
}
