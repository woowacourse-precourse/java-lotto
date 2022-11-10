package lotto.view;

import java.util.Arrays;
import java.util.List;

import lotto.Notice;

public class Output {
	public static void printNotice(String text) {
		System.out.println(text);
	}

	public static void printResult(int result, String text) {
		System.out.print(result + text);
	}

	public static void printCount(List<Integer> numbers) {
		List<String> msg = Arrays.asList("3개 일치 (5,000원)", "4개 일치 (50,000원)", "5개 일치 (1,500,000원)", "5개 일치, 보너스 볼 일치 (30,000,000원)",
				"6개 일치 (2,000,000,000원)");

		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(msg.get(i) + " - " + numbers.get(i) + "개");
		}
	}
	public static void printRateOfReturn(double rateOfReturn) {
		System.out.println(Notice.profit.getNoticeMessage() + rateOfReturn + "%입니다.");
	}
}
