package lotto.view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import lotto.domain.LottoTicket;
import lotto.domain.LottoType;

public class OutputView {
	public static void printLottoTickets(List<LottoTicket> lottoTickets) {
		System.out.println(lottoTickets.size() + "개를 구매했습니다.");
		for (LottoTicket lottoTicket : lottoTickets) {
			System.out.println(lottoTicket.getNumbers());
		}
	}

	public static void printLottoStat(Map<LottoType, Integer> stat) {
		System.out.println("당첨 통계");
		System.out.println("---");
		System.out.println("3개 일치 (5,000원) - " + stat.get(LottoType.FIFTH) + "개");
		System.out.println("4개 일치 (50,000원) - " + stat.get(LottoType.FOURTH) + "개");
		System.out.println("5개 일치 (1,500,000원) - " + stat.get(LottoType.THIRD) + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + stat.get(LottoType.SECOND) + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + stat.get(LottoType.FIRST) + "개");
	}

	public static void printEarningsRate(BigDecimal earningsRate) {
		DecimalFormat df = new DecimalFormat("#,##0.0%");
		System.out.println("총 수익률은 " + df.format(earningsRate.setScale(4, RoundingMode.HALF_UP)) + "입니다.");
	}
}
