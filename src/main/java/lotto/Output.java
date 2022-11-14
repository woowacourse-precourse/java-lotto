package lotto;

import java.util.HashMap;
import java.util.List;

public class Output {

	public static void printTicketCount(int totalNumberOfLotto) {
		System.out.println();
		System.out.println(totalNumberOfLotto + "개를 구매했습니다.");
	}

	public static void printLotto(List<List<Integer>> lotteryTickets) {
		for (List<Integer> lotteryTicket : lotteryTickets) {
			System.out.println(lotteryTicket);
		}
	}

	public static void printResult(HashMap<Integer, Integer> result) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---");
		for (Rank rank : Rank.values()) {
			if (rank == Rank.NOTHING) {
				continue;
			}
			if (rank == Rank.SECOND) {
				System.out.println(rank.getMatchCount() + "개 일치, 보너스 볼 일치 (" + rank.getMoney() + "원) - "
					+ result.get(rank.getMatchCount()) + "개");
				continue;
			}
			System.out.println(
				rank.getMatchCount() + "개 일치 (" + rank.getMoney() + "원) - " + result.get(rank.getMatchCount()) + "개");
		}
	}

	public static void printEarningRate(int paidMoney, Long earningMoney) {
		System.out.println("총 수익률은 " + EarningRate.calculate(paidMoney, earningMoney) + "%입니다.");
	}
}
