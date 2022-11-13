package lotto.view;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;

public class OutputView {
	private static final String PRINT_LOTTO_NUMBER = "\n%d개를 구매했습니다.";
	private static final String PRINT_PRIZE_RESULT_INTRO = "\n당첨 통계";
	private static final String PRINT_PRIZE_RESULT_BORDER_LINE = "---";
	private static final String PRINT_PRIZE_RESULT_FRONT = "%d개 일치";
	private static final String PRINT_PRIZE_RESULT_BONUS = ", 보너스 볼 일치";
	private static final String PRINT_PRIZE_RESULT_LAST = " (%d) - %d개";
	private static final String PRINT_RATE_RETURN = "총 수익률은 %.1f%%입니다.%n";

	public static void printLottoNumber(int lottoNumber) {
		System.out.printf((PRINT_LOTTO_NUMBER) + "%n", lottoNumber);
	}

	public static void printLottoTickets(LottoTicket lottoTicket) {
		List<Lotto> lottoTickets = lottoTicket.getLottoTickets();
		for (Lotto lotto : lottoTickets) {
			StringBuilder lottoNumbers = new StringBuilder("[");
			for (Integer integer : lotto.getNumbers()) {
				lottoNumbers.append(integer).append(", ");
			}
			lottoNumbers.delete(lottoNumbers.length() - 2, lottoNumbers.length());
			lottoNumbers.append("]");
			System.out.println(lottoNumbers);
		}
	}

	public static void printPrizeResult(LottoResult lottoResult) {
		printPrizeResultIntro();
		Set<Map.Entry<LottoRanking, Integer>> rankResult = lottoResult.getLottoResult().entrySet();
		List<Map.Entry<LottoRanking, Integer>> prizeRanking = rankResult.stream()
			.filter(entry -> LottoRanking.noWin != entry.getKey())
			.sorted(Comparator.comparingInt(money -> money.getKey().getPrizeMoney()))
			.collect(Collectors.toList());
		for (Map.Entry<LottoRanking, Integer> entry : prizeRanking) {
			StringBuilder printResult = new StringBuilder();
			LottoRanking lottoRanking = entry.getKey();
			int prizeCount = entry.getValue();
			printResult.append(String.format(PRINT_PRIZE_RESULT_FRONT, lottoRanking.getWinNumber()));
			if (lottoRanking.isMatchBonus()) {
				printResult.append(PRINT_PRIZE_RESULT_BONUS);
			}
			printResult.append(String.format(PRINT_PRIZE_RESULT_LAST, lottoRanking.getPrizeMoney(), prizeCount));
			System.out.println(printResult);
		}
	}

	private static void printPrizeResultIntro() {
		System.out.println(PRINT_PRIZE_RESULT_INTRO);
		System.out.println(PRINT_PRIZE_RESULT_BORDER_LINE);
	}

	public static void printRateReturn(double rateReturn) {
		System.out.printf(PRINT_RATE_RETURN, rateReturn);
	}
}
