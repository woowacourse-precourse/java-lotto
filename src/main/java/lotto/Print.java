package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.LongToDoubleFunction;

public class Print {

	public static void PrintUserPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
	}

	public static void PrintUserPurchaseLottoAmount(Integer lottoMoney) {
		System.out.println(lottoMoney + "개를 구매했습니다.");
	}

	public static void PrintUserLottoNumbers(UserLotto userLottoes) {

		for (Lotto l : userLottoes.getUserLottoes()) {
			List<Integer> numbers = l.getNumbers();
			System.out.println(Arrays.toString(numbers.toArray()));
		}
	}

	public static void PrintTypingWinLotto() {
		System.out.println("당첨 번호를 입력해 주세요.");
	}

	public static void PrintTypingBonusNumber() {
		System.out.println("보너스 번호를 입력해 주세요.");
	}

	public static void printCorrectness(List<Integer> correctNumbers) {
		System.out.println("당첨 통계");
		System.out.println(" ---");
		System.out.println("3개 일치 (5,000원) - " + correctNumbers.get(0) + "개");
		System.out.println("4개 일치 (50,000원) - " + correctNumbers.get(1) + "개");
		System.out.println("5개 일치 (1,500,000원) - " + correctNumbers.get(2) + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + correctNumbers.get(3) + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + correctNumbers.get(4) + "개");
	}

	public static void printYield(List<Integer> correctNumbers, Integer lottoCount) {
		long winnings = 0;
		List<LottoWinMoney> winningAmount = List.of(LottoWinMoney.CALC_5, LottoWinMoney.CALC_4, LottoWinMoney.CALC_3, LottoWinMoney.CALC_2, LottoWinMoney.CALC_1);
		for (int i = 0; i < correctNumbers.size(); i++) {
			winnings += winningAmount.get(i).calculate(correctNumbers.get(i));

		}
		Float winningPercent = (winnings / (float)(lottoCount * 1000)) * 100;
		System.out.println("총 수익률은 " + winningPercent + "%입니다.");
	}
}
