package lotto.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.domain.LottoTicket;

public class OutputView {
	private static final String PRINT_LOTTO_NUMBER = "개를 구매했습니다.";
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
		List<List<Integer>> lottoTickets = lottoTicket.getLottoTickets();
		for (List<Integer> lotto : lottoTickets) {
			StringBuilder lottoNumbers = new StringBuilder("[");
			for (Integer integer : lotto) {
				lottoNumbers.append(integer).append(", ");
			}
			lottoNumbers.delete(lottoNumbers.length()-2, lottoNumbers.length());
			lottoNumbers.append("]");
			System.out.println(lottoNumbers);
		}
	}

	public static void printPrize(HashMap<String, Integer> prizeResult) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---");
		System.out.println(PRINT_FIFTH_PRIZE_RESULT + prizeResult.get("winThree")+ PRINT_PRIZE_NUMBER);
		System.out.println(PRINT_FOURTH_PRIZE_RESULT + prizeResult.get("winFour") + PRINT_PRIZE_NUMBER);
		System.out.println(PRINT_THIRD_PRIZE_RESULT + prizeResult.get("winFive") + PRINT_PRIZE_NUMBER);
		System.out.println(PRINT_SECOND_PRIZE_RESULT + prizeResult.get("winFiveBonus") + PRINT_PRIZE_NUMBER);
		System.out.println(PRINT_FIRST_PRIZE_RESULT + prizeResult.get("winSix") + PRINT_PRIZE_NUMBER);
	}

	public static void printRateReturn(double rateReturn){
		System.out.printf("총 수익률은 %.1f%%입니다.%n", rateReturn);
	}
 }
