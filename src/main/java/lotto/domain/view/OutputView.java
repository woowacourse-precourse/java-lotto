package lotto.domain.view;

import lotto.domain.lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String BUY_LOTTO = "%d개를 구매했습니다.";
    public static void printCountByBuyLotto(int lottoCount) {
        System.out.printf((BUY_LOTTO) + "%n", lottoCount);
    }

    public static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }
}
