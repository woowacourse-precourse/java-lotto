package lotto.system;

import camp.nextstep.edu.missionutils.Console;
import lotto.calculation.Rank;
import lotto.generation.Lotto;

import java.util.Collections;
import java.util.List;

public class SystemUi {

    private static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ANNOUNCE_LOTTO_NUMBER_MESSAGE = "개를 구매했습니다.";
    private static final String GET_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_RESULT_MESSAGE = "당첨 통계";
    private static final Parser parser = new Parser();

    public static int getPurchaseAmount() {
        System.out.println(START_MESSAGE);
        return parser.validatePurchaseAmount(Console.readLine());
    }

    public static void printLotto(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size()+ANNOUNCE_LOTTO_NUMBER_MESSAGE);
        for (int index = 0; index < lottos.size(); index++) {
            System.out.println(lottos.get(index).getNumbers());
        }
    }

    public static String getWinningNumber() {
        System.out.println();
        System.out.println(GET_WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static int getBonusNumber() {
        System.out.println();
        System.out.println(GET_BONUS_NUMBER_MESSAGE);
        return parser.validateBonusNumber(Console.readLine());
    }

    public static void printResult(List<Rank> rankCount) {
        System.out.println();
        System.out.println(WINNING_RESULT_MESSAGE);
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getTitle() + " - " +
                    Collections.frequency(rankCount, rank) + "개");
        }
    }
}
