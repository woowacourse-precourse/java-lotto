package lotto.viewer;

import lotto.domain.Buyer;
import lotto.domain.Lotto;

public class inputView {
    public static final String PURCHASE_REQUEST = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_NUMBER = "개를 구매했습니다.";
    public static final String WINNING_REQUEST = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_REQUEST = "보너스 번호를 입력해 주세요.";


    public static void showPurchaseRequest() {
        System.out.println(PURCHASE_REQUEST);
    }

    public static void showPurchaseNumber(int number) {
        System.out.println(number + PURCHASE_NUMBER);
    }
    public static void showWinningRequest() {
        System.out.println(WINNING_REQUEST);
    }
    public static void showBonusRequest() {
        System.out.println(BONUS_REQUEST);
    }
    public static void showAllLotto(Buyer buyer) {
        buyer.showAllLotto();
    }
}
