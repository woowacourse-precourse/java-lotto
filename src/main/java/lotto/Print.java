package lotto;

import java.util.List;
import java.util.Map;

public class Print {
    private static String MESSAGE_INSERT_MONEY = "구매금액을 입력해 주세요.";
    private static String MESSAGE_LOTTO_COUNT = "개를 구매했습니다.";
    private static String MESSAGE_WINNING_NUMBER = "당첨 번호를 입력해주세요.";
    private static String MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해주세요.";
    private static String MESSAGE_RANK_COUNTER_START = "당첨 통계\n---";

    public static void printInsertMoney() {
        System.out.println(MESSAGE_INSERT_MONEY);
    }

    public static void printLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + MESSAGE_LOTTO_COUNT);
        for (int lottoIndex = 0; lottoIndex < lottos.size(); lottoIndex++) {
            System.out.println(lottos.get(lottoIndex));
        }
    }

    public static void printWinningNumber() {
        System.out.println(MESSAGE_WINNING_NUMBER);
    }

    public static void printBonusNumber() {
        System.out.println(MESSAGE_BONUS_NUMBER);
    }

    public static void printRankCounter(RankCounter rankCounter) {
        System.out.println(MESSAGE_RANK_COUNTER_START);
        System.out.println(rankCounter);
    }
}
