package lotto;

public class OutputUtil {
    public static final String PURCHASE_INPUT = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_RESULT = "개를 구매했습니다.";
    public static final String WINNING_NUMBER_NOTICE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NOTICE = "보너스 번호를 입력해 주세요.";

    public void purchaseNotice() {
        System.out.println(PURCHASE_INPUT);
    }

    public void purchaseResult(Purchase purchase) {
        // PURCHASE_RESULT+=purchase.lottoSize;
        System.out.println(PURCHASE_RESULT);
        for (; ; ) {
            //System.out.println(lotto);
        }
    }

    public void winningNumberNotice() {
        System.out.println(WINNING_NUMBER_NOTICE);
    }

    public void bonusNotice() {
        System.out.println(BONUS_NOTICE);
    }
}
