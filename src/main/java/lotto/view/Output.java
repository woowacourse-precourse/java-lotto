package lotto.view;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;

import lotto.service.EarningRate;
import lotto.service.Lotto;
import lotto.util.Rank;

public class Output {
	static DecimalFormat formatter = new DecimalFormat("###,###");

	public static void printTicketCount(int totalNumberOfLotto) {
		System.out.println(totalNumberOfLotto + "개를 구매했습니다.");
	}

	public static void printLotto(List<Lotto> lotteryTickets) {
		for (Lotto lotteryTicket : lotteryTickets) {
			System.out.println(lotteryTicket.getLotto());
		}
	}

	public static void printResult(EnumMap<Rank, Integer> result) {
		System.out.println("당첨 통계");
		System.out.println("---");
		for (Rank rank : Rank.values()) {
			if (rank == Rank.NOTHING) {
				continue;
			}
			if (rank == Rank.SECOND) {
				System.out.println(
					rank.getMatchCount() + "개 일치, 보너스 볼 일치 (" + formatter.format(rank.getMoney()) + "원) - "
						+ result.get(rank) + "개");
				continue;
			}
			System.out.println(
				rank.getMatchCount() + "개 일치 (" + formatter.format(rank.getMoney()) + "원) - " + result.get(rank) + "개");
		}
	}

	public static void printEarningRate(int paidMoney, Long earningMoney) {
		System.out.println("총 수익률은 " + EarningRate.calculate(paidMoney, earningMoney) + "%입니다.");
	}
}
