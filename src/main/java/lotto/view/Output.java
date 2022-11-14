package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

import lotto.utils.Notice;
import lotto.domain.Rank;

public class Output {
	public static void printNotice(String text) {
		System.out.println(text);
	}

	public static void printPurchaseQuantity(int result, String text) {
		System.out.println(result + text);
	}

	public static void printResult(int prizeMoney, int value) {
		NumberFormat numberFormat = NumberFormat.getInstance();

		System.out.println(Notice.PARENTHESIS.getNoticeMessage() +
				numberFormat.format(prizeMoney) + Notice.RESULT_WON.getNoticeMessage() +
				value + Notice.RESULT_VALUE.getNoticeMessage());
	}

	public static void printRank(Map<Rank, Integer> rank) {
		printNotice(Notice.STATISTICS.getNoticeMessage());

		for(Map.Entry<Rank, Integer> entry : rank.entrySet()) {
			printCount(entry.getKey().getCorrectNumber(), entry.getKey().isJudgmentBonus());
			printResult(entry.getKey().getPrizeMoney(), entry.getValue());
		}
	}

	public static void printCount(int matchCount, boolean check) {
		System.out.print(matchCount + Notice.RESULT_COUNT.getNoticeMessage());
		isBonus(check);
	}

	public static void isBonus(boolean check) {
		if (check) {
			System.out.print(Notice.RESULT_BONUS.getNoticeMessage());
		}
		System.out.print(Notice.SPACE.getNoticeMessage());
	}

	public static void printRateOfReturn(String rateOfReturn) {
		System.out.println(Notice.RATE_OF_RETURN.getNoticeMessage()
				+ rateOfReturn + Notice.RESULT_PERCENT.getNoticeMessage());
	}

	public static void printPublishLotteries(List<Integer> lotto) {
		System.out.println(lotto);
	}
}
