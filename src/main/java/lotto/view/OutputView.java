package lotto.view;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;

public class OutputView {
	private static final String LOTTO_NUMBER_MESSAGE = "\n%d개를 구매했습니다.\n";
	private static final String LOTTO_NUMBER_INTRO = "[";
	private static final String LOTTO_NUMBER_BOUNDARY = ", ";
	private static final String LOTTO_NUMBER_OUTRO = "]";
	private static final int LOTTO_NUMBER_CONTROL_LENGTH = 2;
	private static final String PRIZE_RESULT_INTRO_MESSAGE = "\n당첨 통계\n---";
	private static final String PRIZE_RESULT_MESSAGE = "%d개 일치%s(%s원) - %d개";
	private static final String PRIZE_RESULT_BONUS_MESSAGE = ", 보너스 볼 일치 ";
	private static final String PRIZE_RESULT_BLANK_MESSAGE = " ";
	private static final String RATE_RETURN_MESSAGE = "총 수익률은 %,.1f%%입니다.%n";

	public static void printLottoNumber(int lottoNumber) {
		System.out.printf(LOTTO_NUMBER_MESSAGE, lottoNumber);
	}

	public static void printLottoTickets(LottoTicket lottoTicket) {
		List<Lotto> lottoTickets = lottoTicket.getLottoTickets();
		for (Lotto lotto : lottoTickets) {
			StringBuilder lottoNumbers = new StringBuilder(LOTTO_NUMBER_INTRO);
			createTicketPrint(lottoNumbers, lotto);
			lottoNumbers.delete(lottoNumbers.length() - LOTTO_NUMBER_CONTROL_LENGTH, lottoNumbers.length())
				.append(LOTTO_NUMBER_OUTRO);
			System.out.println(lottoNumbers);
		}
	}

	private static void createTicketPrint(StringBuilder lottoNumbers, Lotto lotto) {
		for (Integer integer : lotto.getNumbers()) {
			lottoNumbers.append(integer).append(LOTTO_NUMBER_BOUNDARY);
		}
	}

	public static void printPrizeResult(LottoResult lottoResult) {
		String prizeResult;
		System.out.println(PRIZE_RESULT_INTRO_MESSAGE);
		List<Map.Entry<LottoRanking, Integer>> prizeRanking = createPrizeRanking(lottoResult);
		for (Map.Entry<LottoRanking, Integer> entry : prizeRanking) {
			prizeResult = createPrizeResult(entry);
			System.out.println(prizeResult);
		}
	}

	private static List<Map.Entry<LottoRanking, Integer>> createPrizeRanking(LottoResult lottoResult) {
		return lottoResult.getLottoResult().entrySet().stream()
			.filter(entry -> LottoRanking.noWin != entry.getKey())
			.sorted(Comparator.comparingInt(money -> money.getKey().getPrizeMoney()))
			.collect(Collectors.toList());
	}

	private static String createPrizeResult(Map.Entry<LottoRanking, Integer> entry) {
		LottoRanking lottoRanking = entry.getKey();
		int prizeCount = entry.getValue();
		String prizeMoney = NumberFormat.getInstance().format(lottoRanking.getPrizeMoney());
		return String.format(PRIZE_RESULT_MESSAGE, lottoRanking.getWinNumber()
			, isMatchBonusNumber(lottoRanking), prizeMoney, prizeCount);
	}

	private static String isMatchBonusNumber(LottoRanking lottoRanking) {
		if (lottoRanking.isMatchBonus()) {
			return PRIZE_RESULT_BONUS_MESSAGE;
		}
		return PRIZE_RESULT_BLANK_MESSAGE;
	}

	public static void printRateReturn(double rateReturn) {
		System.out.printf(RATE_RETURN_MESSAGE, rateReturn);
	}
}
