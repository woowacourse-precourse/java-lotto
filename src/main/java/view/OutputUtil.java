package view;

import domain.Lotto;
import domain.Lottos;

public class OutputUtil {
    public static final int MIN_HIT = 3;
    public static final int MAX_HIT = 6;
    private static final String START_STATISTICS = "\n당첨통계\n---";
    private static final String PURCHASE_INPUT = "구입금액을 입력해 주세요.";
    private static String PURCHASE_RESULT = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_NOTICE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NOTICE = "\n보너스 번호를 입력해 주세요.";

    public void noticePurchase() {
        System.out.println(PURCHASE_INPUT);
    }

    public void showPurchaseResult(Lottos lottos) {
        Integer size = lottos.getSize();
        PURCHASE_RESULT= "\n"+Integer.toString(size)+PURCHASE_RESULT;
        System.out.println(PURCHASE_RESULT);
        for (Lotto lotto: lottos.getLottos() ) {
            System.out.println(lotto);
        }
    }

    public void winningNumberNotice() {
        System.out.println(WINNING_NUMBER_NOTICE);
    }

    public void noticeBonus() {
        System.out.println(BONUS_NOTICE);
    }

    public void showResult(){
        System.out.println(START_STATISTICS);
        for(int hitNumber = MIN_HIT; hitNumber<= MAX_HIT ; hitNumber++){
            //System.out.println("N개 일치 (N원) - N개");
        }
        //System.out.println("총 수익률은 62.5%입니다.");
    }
}
