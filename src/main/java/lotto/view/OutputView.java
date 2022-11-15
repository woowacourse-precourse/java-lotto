package lotto.view;

public class OutputView {

    public static final String INPUT_AMOUNT = "구입금액을 입력해주세요";
    public static final String BUY_COMPLETE = "개를 구매했습니다.";
    public static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String RESULT = "당첨 통계\n---\n";

    public void print(String message) {
        System.out.print(message);
    }

    public void printWithLine(String message) {
        System.out.println(message);
    }
}
