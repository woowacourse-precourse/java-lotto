package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class Output {
	public static void printNumberOfPurchaseLotto(int numberOfPurchaseLotto) {
		System.out.println(numberOfPurchaseLotto + "개를 구매했습니다.");
	}

	public static void printLottos(List<Lotto> lottos) {
		for (Lotto lotto : lottos) {
			System.out.println(lotto.getNumbers());
		}
	}

	public static void printProfit(double profit) {
		System.out.println("총 수익률은 " + profit + "%입니다.");
	}

	public static void printRank(Map<Rank, Integer> result) {
		StringBuilder sb = new StringBuilder("당첨 통계\n" + "---\n");

		for(Rank rank: Rank.values()) {
			if(rank.getNumberOfMatching() != 0) {
				sb.append(rank.getMessage())
					.append(" (" + toNumberFormat(rank.getPrize()) + "원)")
					.append(" - " + result.getOrDefault(rank, 0) + "개\n");
			}
		}

		System.out.println(sb.toString());
	}

	public static String toNumberFormat(int number) {
		DecimalFormat decFormat = new DecimalFormat("###,###");
		return decFormat.format(number);
	}
}
