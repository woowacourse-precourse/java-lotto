package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Output {
	public static void printLotteries(List<Lotto> lotteries) {
		System.out.printf("%d개를 구매했습니다.\n", lotteries.size());
		for (Lotto lotto : lotteries) {
			List<Integer> copiedLottoNumbers = new ArrayList<>(lotto.getNumbers());
			System.out.println(copiedLottoNumbers.toString());
		}
		System.out.println();
	}

	public static void printWinningStatistics(List<Lotto> lotteries, Lotto winningNumbers, int bonusNumber) {
		List<Prize> prizes = getPrizes(lotteries, winningNumbers, bonusNumber);

		System.out.println("당첨 통계");
		System.out.println("---");
		System.out.printf("3개 일치 (5,000원) - %d개\n", Collections.frequency(prizes, Prize.FIFTH));
		System.out.printf("4개 일치 (50,000원) - %d개\n", Collections.frequency(prizes, Prize.FOURTH));
		System.out.printf("5개 일치 (1,500,000원) - %d개\n", Collections.frequency(prizes, Prize.THIRD));
		System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", Collections.frequency(prizes, Prize.SECOND));
		System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", Collections.frequency(prizes, Prize.FIRST));
		System.out.printf("총 수익률은 %s%%입니다.", getReturnRatio(prizes, lotteries.size() * 1_000));
	}

	private static List<Prize> getPrizes(List<Lotto> lotteries, Lotto winningNumbers, int bonusNumber) {
		List<Prize> prizes = new ArrayList<>();
		for (Lotto lotto : lotteries) {
			int hitCount = getHitCount(lotto, winningNumbers);
			boolean bonusWinning = lotto.getNumbers().contains(bonusNumber);
			prizes.add(Prize.valueOf(hitCount, bonusWinning));
		}

		return prizes;
	}

	private static int getHitCount(Lotto lotto, Lotto winningNumbers) {
		int count = 0;
		for (int number : lotto.getNumbers()) {
			if (winningNumbers.getNumbers().contains(number)) {
				count++;
			}
		}

		return count;
	}

	private static String getReturnRatio(List<Prize> prizes, int purchasePrice) {
		int winningPrice = Collections.frequency(prizes, Prize.FIFTH) * Prize.FIFTH.getWinningPrice()
				+ Collections.frequency(prizes, Prize.FOURTH) * Prize.FOURTH.getWinningPrice()
				+ Collections.frequency(prizes, Prize.THIRD) * Prize.THIRD.getWinningPrice()
				+ Collections.frequency(prizes, Prize.SECOND) * Prize.SECOND.getWinningPrice()
				+ Collections.frequency(prizes, Prize.FIRST) * Prize.FIRST.getWinningPrice();

		double returnRatio = (double)winningPrice / purchasePrice * 100;

		String roundReturnRatio = String.format("%.1f", returnRatio);

		DecimalFormat decFormat = new DecimalFormat("###,###.##");
		String formattedRoundReturnRatio = decFormat.format(Double.parseDouble(roundReturnRatio));

		return formattedRoundReturnRatio;
	}
}
