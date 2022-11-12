package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {
    private static final String PAY_NOTICE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_PREFIX = "[";
    private static final String LOTTO_SUFFIX = "]";
    private static final String PAY_COUNT_NOTICE = "개를 구매했습니다.";
    private static final String ERR_PREFIX = "[ERROR] ";
    private static final String WINNING_LOTTO_INPUT_NOTICE = "당첨 번호를 입력해 주세요.";
    private static final String BONUSBALL_INPUT_NOTICE = "보너스 번호를 입력해 주세요.";



    public static void announcePayNotice() {
        System.out.println(PAY_NOTICE);
    }

    public static void announceLottos(Lottos lottos) {
        System.out.println(lottos.countLottos()+ PAY_COUNT_NOTICE);
        for (Lotto lotto : lottos.provideLottos()) {
            System.out.println(LOTTO_PREFIX+lotto+LOTTO_SUFFIX);
        }
    }

    public static void announceError(String msg) {
        System.out.println(ERR_PREFIX+msg);
    }

    public static void announceWinningLottoInputNotice() {
        System.out.println(WINNING_LOTTO_INPUT_NOTICE);
    }

    public static void announceBonusBallInputNotice() {
        System.out.println(BONUSBALL_INPUT_NOTICE);
    }
}
