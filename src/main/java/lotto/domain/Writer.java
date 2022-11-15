package lotto.domain;

import static lotto.Constants.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Calculator.Result;

public class Writer {

	private static final String INPUT_PURCHASE_AMOUNT_ANNOUNCEMENT = "구입금액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBERS_ANNOUNCEMENT = "당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER_ANNOUNCEMENT = "보너스 번호를 입력해 주세요.";
	private static final String WINNING_STATS_ANNOUNCEMENT = "당첨 통계";
	private static final String PURCHASE_ANNOUNCEMENT = "%s개를 구매했습니다.";
	private static final String RATE_OF_RETURN_ANNOUNCEMENT = "총 수익률은 %.1f%%입니다.";

	public static void writeInputPurchaseAnnouncement() {
		System.out.println(INPUT_PURCHASE_AMOUNT_ANNOUNCEMENT);
	}

	public static void writePurchasedLottoTickets(List<Lotto> tickets) {
		System.out.println(String.format(PURCHASE_ANNOUNCEMENT, tickets.size()));
		tickets.stream()
				.map(Lotto::getNumbers)
				.map(List::toString)
				.forEach(System.out::println);
	}

	public static void writeInputWinningNumbers() {
		System.out.println(INPUT_WINNING_NUMBERS_ANNOUNCEMENT);
	}

	public static void writeInputBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER_ANNOUNCEMENT);
	}

	public static void writeWinningStats(List<Lotto> tickets, LotteryMachine machine) {
		System.out.println(WINNING_STATS_ANNOUNCEMENT);
		System.out.println(DIVISION_LINE);
		System.out.println(generateWinningStats(Calculator.calculate(machine, tickets)));
	}

	public static void writeExceptionMessage(Exception e) {
		System.out.println(e.getMessage());
	}

	private static String generateWinningStats(Result result) {
		return result.getCounts()
				.entrySet()
				.stream()
				.filter(entry -> !entry.getKey().equals(Lottery.BANG))
				.sorted(Comparator.comparing(entry -> entry.getKey().ordinal()))
				.map(entry -> String.format(entry.getKey().getMessage(), entry.getValue()))
				.collect(Collectors.joining(LINE_BREAK))
				+ LINE_BREAK + String.format(RATE_OF_RETURN_ANNOUNCEMENT, result.getRateOfReturn());
	}

}
