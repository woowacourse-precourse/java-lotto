package lotto.view;

import java.text.NumberFormat;
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
	private static final String LOTTO_NUMBER_INTRO = "[";
	private static final String LOTTO_NUMBER_BOUNDARY = ", ";
	private static final String LOTTO_NUMBER_OUTRO = "]";
	private static final int LOTTO_NUMBER_CONTROL_LENGTH = 2;
	private static final String PRINT_PRIZE_RESULT_INTRO = "\n당첨 통계";
	private static final String PRINT_PRIZE_RESULT_BORDER_LINE = "---";
	private static final String PRINT_PRIZE_RESULT_FRONT = "%d개 일치";
	private static final String PRINT_PRIZE_RESULT_BONUS = ", 보너스 볼 일치";
	private static final String PRINT_PRIZE_RESULT_LAST = " (%s원) - %d개";
	private static final String PRINT_RATE_RETURN = "총 수익률은 %.1f%%입니다.%n";

	public static void printLottoNumber(int lottoNumber) {
		System.out.printf((PRINT_LOTTO_NUMBER) + "%n", lottoNumber);
	}

	public static void printLottoTickets(LottoTicket lottoTicket) {
		List<Lotto> lottoTickets = lottoTicket.getLottoTickets();
		for (Lotto lotto : lottoTickets) {
			StringBuilder lottoNumbers = new StringBuilder(LOTTO_NUMBER_INTRO);
			createTicketPrint(lottoNumbers, lotto);
			lottoNumbers.delete(lottoNumbers.length() - LOTTO_NUMBER_CONTROL_LENGTH, lottoNumbers.length());
			lottoNumbers.append(LOTTO_NUMBER_OUTRO);
			System.out.println(lottoNumbers);
		}
	}

	private static void createTicketPrint(StringBuilder lottoNumbers, Lotto lotto) {
		for (Integer integer : lotto.getNumbers()) {
			lottoNumbers.append(integer).append(LOTTO_NUMBER_BOUNDARY);
		}
	}

	public static void printPrizeResult(LottoResult lottoResult) {
		printPrizeResultIntro();
		List<Map.Entry<LottoRanking, Integer>> prizeRanking = createPrizeRanking(lottoResult);
		for (Map.Entry<LottoRanking, Integer> entry : prizeRanking) {
			StringBuilder printResult = new StringBuilder();
			createPrintResult(entry, printResult);
			System.out.println(printResult);
		}
	}

	private static void printPrizeResultIntro() {
		System.out.println(PRINT_PRIZE_RESULT_INTRO);
		System.out.println(PRINT_PRIZE_RESULT_BORDER_LINE);
	}

	private static List<Map.Entry<LottoRanking, Integer>> createPrizeRanking(LottoResult lottoResult) {
		return lottoResult.getLottoResult().entrySet().stream()
			.filter(entry -> LottoRanking.noWin != entry.getKey())
			.sorted(Comparator.comparingInt(money -> money.getKey().getPrizeMoney()))
			.collect(Collectors.toList());
	}

	private static void createPrintResult(Map.Entry<LottoRanking, Integer> entry, StringBuilder printResult) {
		LottoRanking lottoRanking = entry.getKey();
		int prizeCount = entry.getValue();
		printResult.append(String.format(PRINT_PRIZE_RESULT_FRONT, lottoRanking.getWinNumber()));
		isMatchBonusNumber(lottoRanking, printResult);
		String prizeMoney = NumberFormat.getInstance().format(lottoRanking.getPrizeMoney());
		printResult.append(String.format(PRINT_PRIZE_RESULT_LAST, prizeMoney, prizeCount));
	}

	private static void isMatchBonusNumber(LottoRanking lottoRanking, StringBuilder printResult) {
		if (lottoRanking.isMatchBonus()) {
			printResult.append(PRINT_PRIZE_RESULT_BONUS);
		}
	}

	public static void printRateReturn(double rateReturn) {
		System.out.printf(PRINT_RATE_RETURN, rateReturn);
	}
}
