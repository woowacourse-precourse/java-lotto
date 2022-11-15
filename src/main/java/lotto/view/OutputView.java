package lotto.view;

import lotto.domain.Match;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String INPUT_MONEY_MSG = "구입금액을 입력해 주세요.";
    private static final String NUMBER_OF_LOTTO_MSG = "개를 구매했습니다.";
    private static final String INPUT_WINNING_LOTTO_MSG = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MSG = "\n보너스 번호를 입력해 주세요.";
    private static final String START_GET_RESULT_MSG = "\n당첨 통계\n---";

    public static void printInputMoneyMessage() {
        System.out.println(INPUT_MONEY_MSG);
    }

    public static void printNumberOfLottoMessage(int numberOfLotto) {
        System.out.println("\n" + numberOfLotto + NUMBER_OF_LOTTO_MSG);
    }

    public static void printNumbers(List<Integer> numbers){
        System.out.println(numbers);
    }

    public static void printInputWinningNumbersMessage() {
        System.out.println(INPUT_WINNING_LOTTO_MSG);
    }

    public static void printInputBonusNumbersMessage() {
        System.out.println(INPUT_BONUS_NUMBER_MSG);
    }

    public static void printStartResultMessage() {
        System.out.println(START_GET_RESULT_MSG);
    }

    public static void printResult(Map<String, Integer> matchCount) {
        for (Match match: Match.values()) {
            if (match.getBonus()) {
                System.out.println(match.getMatchCount() + "개 일치, 보너스 볼 일치 (" + match.getReward() + "원) - "
                        + matchCount.get("5+") + "개");
                continue;
            }
            System.out.println(match.getMatchCount() + "개 일치 (" + match.getReward() + "원) - "
                    + matchCount.get(String.valueOf(match.getMatchCount())) + "개");
        }
    }
}
