package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {
    private static final String PAY_NOTICE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_PREFIX = "[";
    private static final String LOTTO_SUFFIX = "]";
    private static final String PAY_COUNT_NOTICE = "개를 구매했습니다.";
    private static final String ERR_PREFIX = "[ERROR] ";

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
}
