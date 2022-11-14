package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

import lotto.Notice;
import lotto.Rank;

public class Output {
	public static void printNotice(String text) {
		System.out.println(text);
	}

	public static void printResult(int result, String text) {
		System.out.print(result + text);
	}

	public static void printCount(int prizeMoney, int value) {
		NumberFormat numberFormat = NumberFormat.getInstance();

		System.out.println("(" + numberFormat.format(prizeMoney) +"원) - " + value +"개");


	}

	public static void printRank(Map<Rank, Integer> rank) {
		for (int i = 0; i < Rank.getKeyWithoutDefault().size(); i++) {
			Rank key = Rank.getKeyWithoutDefault().get(i);

			rank.put(key, rank.getOrDefault(key, 0));

		}
		rank.remove(Rank.valueOf("NO_PRIZE"));

		for(Map.Entry<Rank, Integer> entry : rank.entrySet()) {
			printSame(entry.getKey().getCorrectNumber(), entry.getKey().isJudgmentBonus());
			Output.printCount(entry.getKey().getPrizeMoney(), entry.getValue());
		}
	}
	public static void printSame(int matchCount, boolean check) {
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
