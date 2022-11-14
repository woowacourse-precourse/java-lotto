package lotto.system;

import camp.nextstep.edu.missionutils.Console;
import lotto.generation.Lotto;

import java.util.List;

public class SystemUi {

    private static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ANNOUNCE_LOTTO_NUMBER_MESSAGE = "개를 구매했습니다.";
    private static final String GET_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static int getPurchaseAmount() {
        System.out.println(START_MESSAGE);
        return new Parser().validatePurchaseAmount(Console.readLine());
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
}
