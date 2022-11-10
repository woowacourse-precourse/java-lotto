package lotto.domain.view;

import lotto.domain.lotto.domain.Lotto;
import lotto.global.util.Util;


public class OutputView {
    private static final String BUY_LOTTO = "%d개를 구매했습니다.";
    private static final String INPUT_PRIZE_NUMBERS = "당첨 번호를 입력해 주세요.";

    public static void printCountByBuyLotto(int lottoCount) {
        System.out.printf((BUY_LOTTO) + "%n", lottoCount);
    }

    public static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void enter() {
        System.out.println();
    }

    public static String printInputPrizeNumbers() {
        enter();
        System.out.println(INPUT_PRIZE_NUMBERS);
        return Util.input();
    }

    public static void printDividingLine() {
        enter();
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
