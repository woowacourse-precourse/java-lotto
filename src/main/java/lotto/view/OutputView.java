package lotto.view;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoRanking;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;

public class OutputView {
	private static final String PRINT_LOTTO_NUMBER = "개를 구매했습니다.";
	private static final String PRINT_PRIZE_RESULT_FRONT = "%d개 일치";
	private static final String PRINT_PRIZE_RESULT_BONUS = ", 보너스 볼 일치";
	private static final String PRINT_PRIZE_RESULT_LAST = " (%d) - %d개";
	private static final String PRINT_RATE_RETURN = "총 수익률은 %.1f%%입니다.%n";
	private static final int REQUIRE_FOR_YIELD_NUMBER = 100;
	private static final String PRINT_FIRST_PRIZE_RESULT = "6개 일치 (2,000,000,000원) - ";
	private static final String PRINT_SECOND_PRIZE_RESULT = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
	private static final String PRINT_THIRD_PRIZE_RESULT = "5개 일치 (1,500,000원) - ";
	private static final String PRINT_FOURTH_PRIZE_RESULT = "4개 일치 (50,000원) - ";
	private static final String PRINT_FIFTH_PRIZE_RESULT = "3개 일치 (5,000원) - ";
	private static final String PRINT_PRIZE_NUMBER = "개";

	public static void printLottoNumber(int lottoNumber) {
		System.out.println();
		System.out.println(lottoNumber + PRINT_LOTTO_NUMBER);
	}

	public static void printLottoTickets(LottoTicket lottoTicket) {
		List<Lotto> lottoTickets = lottoTicket.getLottoTickets();
		for (Lotto lotto : lottoTickets) {
			StringBuilder lottoNumbers = new StringBuilder("[");
			for (Integer integer : lotto.getNumbers()) {
				lottoNumbers.append(integer).append(", ");
			}
			lottoNumbers.delete(lottoNumbers.length()-2, lottoNumbers.length());
			lottoNumbers.append("]");
			System.out.println(lottoNumbers);
		}
	}

	public static void printPrizeResult(LottoResult lottoResult) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---");
		Set<Map.Entry<LottoRanking, Integer>> rankResult = lottoResult.getLottoResult().entrySet();
		List<Map.Entry<LottoRanking, Integer>> prizeRanking = rankResult.stream()
			.filter(entry -> LottoRanking.noWin != entry.getKey())
			.sorted(Comparator.comparingInt(money -> money.getKey().getPrizeMoney()))
			.collect(Collectors.toList());
		long sum = 0;
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

	public static void printRateReturn(double rateReturn){
		System.out.printf(PRINT_RATE_RETURN, rateReturn);
	}
 }
