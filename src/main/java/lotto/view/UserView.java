package lotto.view;

import java.util.List;

public class UserView {
    private static final int INIT = 0;
    private static final int ONE = 1;
    private static final String PURCHASE_AMOUNT_NOTICE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COUNT_NOTICE = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_NOTICE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_NOTICE = "보너스 번호를 입력해 주세요.";
    private static final String WIN_STATISTICS_NOTICE = "당첨 통계";
    private static final String RATE_OF_RETURN_NOTICE_FRONT = "총 수익률은 ";
    private static final String RATE_OF_RETURN_NOTICE_BACK = "%입니다.";
    private static final String DOTTED_LINES = "---";
    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String RIGHT_SQUARE_BRACKET = "]";
    private static final String COMMA_SPACE = ", ";

    public UserView() {}

    public void printPurchaseAmountNotice() {
        System.out.println(PURCHASE_AMOUNT_NOTICE);
    }

    public void printNumberOfPurchases(int lottoCount){
        printNewLine();
        String numberOfPurchases = lottoCount+PURCHASE_COUNT_NOTICE;
        System.out.println(numberOfPurchases);
    }

    public void printPurchaseLottoNumbers(List<Integer> numbers) {
        String lottoNumbers = LEFT_SQUARE_BRACKET;
        for (int i = INIT; i < numbers.size(); i++) {
            lottoNumbers += numbers.get(i);
            if (i != numbers.size() - ONE) {
                lottoNumbers += COMMA_SPACE;
            }
        }
        lottoNumbers += RIGHT_SQUARE_BRACKET;
        System.out.println(lottoNumbers);
    }

    public void printWinningNumbersNotice() {
        printNewLine();
        System.out.println(WINNING_NUMBER_NOTICE);
    }

    public void printBonusNumbersNotice() {
        printNewLine();
        System.out.println(BONUS_NUMBER_NOTICE);
    }

    public void printWinStatistics() {
        printNewLine();
        System.out.println(WIN_STATISTICS_NOTICE);
        System.out.println(DOTTED_LINES);
    }

    public void printRateOfReturn(String rateOfReturn){
        String rateOfReturnNotice = RATE_OF_RETURN_NOTICE_FRONT + rateOfReturn + RATE_OF_RETURN_NOTICE_BACK;
        System.out.println(rateOfReturnNotice);
    }

    public void printNewLine() {
        System.out.println();
    }

}
