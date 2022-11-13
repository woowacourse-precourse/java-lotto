package lotto.view;

public class OutputView {
    private static final String INPUT_PAID_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INFO_PAID_LOTTO = "\n%d개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    public static void printInputAmount() {
        System.out.println(INPUT_PAID_AMOUNT);
    }
}
