package lotto;

import java.util.List;

public class Output {
	public static void printLotteries(List<Lotto> lotteries) {
		System.out.printf("%d개를 구매했습니다.\n", lotteries.size());
		for (Lotto lotto : lotteries) {
			System.out.println(lotto.getNumbers().toString());
		}
		System.out.println();
	}
}
