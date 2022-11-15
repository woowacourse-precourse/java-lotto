package lotto.view;

import java.text.DecimalFormat;
import java.util.Map.Entry;

import lotto.domain.LottoGameResult;
import lotto.domain.Rank;
import lotto.ticket.LottoTickets;

public class OutputView {

	private static final String DEFAULT_RANK_PRINT_FORMAT = "%d개 일치 (%s원) - %d개";
	private static final String BONUS_RANK_PRINT_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
	private static final DecimalFormat form = new DecimalFormat("#.##");

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
					rank.getMatchCount(), rank.getPriceConvertString(), count);
		}
		return String.format(DEFAULT_RANK_PRINT_FORMAT,
				rank.getMatchCount(), rank.getPriceConvertString(), count);
	}

	public static void printLottoGameYield(final double yield) {
		System.out.println("총 수익률은 "+form.format(yield)+"%입니다.");
		System.out.println();
	}
}
