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

	public static void printResult(int result, String text) {
		System.out.println(result + text);
	}

	public static void printResult(int prizeMoney, int value) {
		NumberFormat numberFormat = NumberFormat.getInstance();

		System.out.println("(" + numberFormat.format(prizeMoney) +"원) - " + value +"개");
	}

	public static void printRank(Map<Rank, Integer> rank) {
		printNotice(Notice.STATISTICS.getNoticeMessage());

		for(Map.Entry<Rank, Integer> entry : rank.entrySet()) {
			printCount(entry.getKey().getCorrectNumber(), entry.getKey().isJudgmentBonus());
			printResult(entry.getKey().getPrizeMoney(), entry.getValue());
		}
	}

	public static void printCount(int matchCount, boolean check) {
		System.out.print(matchCount +"개 일치");
		isBonus(check);
	}

	public static void isBonus(boolean check) {
		if (check) {
			System.out.print(", 보너스 볼 일치");
		}
		System.out.print(" ");
	}

	public static void printRateOfReturn(String rateOfReturn) {
		System.out.println(Notice.RATE_OF_RETURN.getNoticeMessage() + rateOfReturn + "%입니다.");
	}

	public static void printPublishLotteries(List<Integer> lotto) {
		System.out.println(lotto);
	}
}
