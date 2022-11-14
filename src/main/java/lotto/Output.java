package lotto;

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

	public static void printResult() {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---");
		System.out.println("3개 일치 (5,000원) - " + WinningLotto.result.getOrDefault("Fifth", 0) + "개");
		System.out.println("4개 일치 (50,000원) - " + WinningLotto.result.getOrDefault("Fourth", 0) + "개");
		System.out.println("5개 일치 (1,500,000원) - " + WinningLotto.result.getOrDefault("Third", 0) + "개");
		System.out.println("5개 일치, 보너스 볼 일치(30,000,000원) - " + WinningLotto.result.getOrDefault("Second", 0) + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + WinningLotto.result.getOrDefault("First", 0) + "개");
	}

	public static void printEarningRate(int earningMoney, int paidMoney) {
		System.out.println("총 수익률은 " + EarningRate.calculate(earningMoney, paidMoney) + "입니다.");
	}
}
