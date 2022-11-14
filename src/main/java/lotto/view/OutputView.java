package lotto.view;

import java.util.List;
import java.util.Map;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.utils.LottoType;

public class OutputView {
	public static void printLottoTickets(LottoTickets lottoTickets) {
		System.out.println(lottoTickets.getLottoTickets().size() + "개를 구매했습니다.");
		List<LottoTicket> lottoTickets1 = lottoTickets.getLottoTickets();
		for (LottoTicket lottoTicket : lottoTickets1) {
			List<Integer> lottoNumbers = lottoTicket.getNumbers();
			System.out.println(lottoNumbers);
		}
	}

	public static void printLottoStat(Map<LottoType, Integer> stat, double earningsRate) {
		System.out.println("당첨 통계");
		System.out.println("---");
		System.out.println("3개 일치 (5,000원) - " + stat.get(LottoType.FIFTH) + "개");
		System.out.println("4개 일치 (50,000원) - " + stat.get(LottoType.FOURTH) + "개");
		System.out.println("5개 일치 (1,500,000원) - " + stat.get(LottoType.THIRD) + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + stat.get(LottoType.SECOND) + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + stat.get(LottoType.FIRST) + "개");
		System.out.println("총 수익률은 " + earningsRate + "%입니다.");
	}
}
