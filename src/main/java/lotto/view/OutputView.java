package lotto.view;

import lotto.model.domain.LottoCollection;

public class OutputView {

    private static final String REQUEST_MONEY = "구입금액을 입력해 주세요.";
    private static final String BUY_SOME = "개를 구매했습니다.";
    private static final String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void printRequestMoney() {
        System.out.println(REQUEST_MONEY);
    }

    public static void printLottoCollection(LottoCollection lottoCollection) {
        System.out.println();
        System.out.println(lottoCollection.size() + BUY_SOME);
        System.out.println(lottoCollection);
    }

    public static void printRequestWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);
    }

    public static void printRequestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
    }

}
