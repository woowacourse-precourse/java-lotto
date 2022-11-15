package lotto.view;

import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String INPUT_MONEY_MSG = "구입금액을 입력해 주세요.";
    private static final String NUMBER_OF_LOTTO_MSG = "개를 구매했습니다.";
    private static final String INPUT_WINNING_LOTTO_MSG = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MSG = "\n보너스 번호를 입력해 주세요.";
    private static final String START_GET_RESULT_MSG = "\n당첨 통계\n---";
    private static final String LOTTO_RESULT_MSG = "\n%d개 일치 (%s원) - %d개";
    private static final String LOTTO_BONUS_RESULT_MSG = "\n%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RATE_OF_RETURN_MSG = "\n총 수익률은 %.1f%%입니다.";

    public static void printInputMoneyMessage() {
        System.out.println(INPUT_MONEY_MSG);
    }

    public static void printNumberOfLottoMessage(int numberOfLotto) {
        System.out.println("\n" + numberOfLotto + NUMBER_OF_LOTTO_MSG);
    }

    public static void printNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printInputWinningNumbersMessage() {
        System.out.println(INPUT_WINNING_LOTTO_MSG);
    }

    public static void printInputBonusNumbersMessage() {
        System.out.println(INPUT_BONUS_NUMBER_MSG);
    }

    public static void printStartResultMessage() {
        System.out.print(START_GET_RESULT_MSG);
    }

    public static void printResult(Map<String, Integer> ranking) {
        for (Rank rank : Rank.values()) {
            if (rank.getBonus()) {
                System.out.printf(LOTTO_BONUS_RESULT_MSG,
                        rank.getMatchCount(), rank.getReward(), ranking.get(rank.name()));
                continue;
            }
            System.out.printf(LOTTO_RESULT_MSG,
                    rank.getMatchCount(), rank.getReward(), ranking.get(rank.name()));
        }
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MSG, rateOfReturn);
    }
}
