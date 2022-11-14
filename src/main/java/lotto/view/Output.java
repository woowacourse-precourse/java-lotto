package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningCheck;
import lotto.domain.WinningNumbersIncludingBonus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Output {
	private static final String PRINT_PURCHASE_COUNT = "%d개를 구매했습니다.";
	private static final String PRINT_WINNING_STATISTICS = "당첨 통계";
	private static final String PRINT_HORIZONTAL_LINE = "---";
	private static final String PRINT_FIFTH_PRIZE = "3개 일치 (5,000원) - %d개";
	private static final String PRINT_FOURTH_PRIZE = "4개 일치 (50,000원) - %d개";
	private static final String PRINT_THIRD_PRIZE = "5개 일치 (1,500,000원) - %d개";
	private static final String PRINT_SECOND_PRIZE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
	private static final String PRINT_FIRST_PRIZE = "6개 일치 (2,000,000,000원) - %d개";
	private static final String PRINT_RETURN_RATIO = "총 수익률은 %s%%입니다.";
	public static void printLotteries(List<Lotto> lotteries) {
		System.out.printf(PRINT_PURCHASE_COUNT + "\n", lotteries.size());
		for (Lotto lotto : lotteries) {
			List<Integer> copiedLottoNumbers = new ArrayList<>(lotto.getNumbers());
			System.out.println(copiedLottoNumbers.toString());
		}
		System.out.println();
	}

	public static void printWinningStatistics(List<Lotto> lotteries, WinningNumbersIncludingBonus winnings) {
		List<Prize> prizes = WinningCheck.getPrizes(lotteries, winnings);

		System.out.println(PRINT_WINNING_STATISTICS);
		System.out.println(PRINT_HORIZONTAL_LINE);
		System.out.printf(PRINT_FIFTH_PRIZE + "\n", Collections.frequency(prizes, Prize.FIFTH));
		System.out.printf(PRINT_FOURTH_PRIZE + "\n", Collections.frequency(prizes, Prize.FOURTH));
		System.out.printf(PRINT_THIRD_PRIZE + "\n", Collections.frequency(prizes, Prize.THIRD));
		System.out.printf(PRINT_SECOND_PRIZE + "\n", Collections.frequency(prizes, Prize.SECOND));
		System.out.printf(PRINT_FIRST_PRIZE + "\n", Collections.frequency(prizes, Prize.FIRST));
		System.out.printf(PRINT_RETURN_RATIO + "\n", WinningCheck.getReturnRatio(prizes, lotteries.size() * 1_000));
		System.out.println();
	}


}
