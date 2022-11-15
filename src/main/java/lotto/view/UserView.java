package lotto.view;

import java.util.List;

public class UserView {
    private static final int INIT = 0;
    private static final int ONE = 1;
    private static final String PURCHASE_AMOUNT_NOTICE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COUNT_NOTICE = "개를 구매했습니다.";
    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String RIGHT_SQUARE_BRACKET = "]";
    private static final String COMMA_SPACE = ", ";

    public UserView() {}

    public void printPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_NOTICE);
    }

    public void printNumberOfPurchases(int lottoCount){
        printNewLine();
        String numberOfPurchases = lottoCount+PURCHASE_COUNT_NOTICE;
        System.out.println(numberOfPurchases);
    }

    public void printPurchaseLottoNumbers(List<Integer> numbers) {
        String sb2 = LEFT_SQUARE_BRACKET;
        for (int i = INIT; i < numbers.size(); i++) {
            sb2 += numbers.get(i);
            if (i != numbers.size() - ONE) {
                sb2 += COMMA_SPACE;
            }
        }
        sb2 += RIGHT_SQUARE_BRACKET;
        System.out.println(sb2);
    }

    public void printNewLine() {
        System.out.println();
    }

}
