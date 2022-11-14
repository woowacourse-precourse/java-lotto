package lotto.view;
import java.lang.Enum;
import java.sql.SQLOutput;

public class OutputView {
    private static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NOTIFICATION_MESSAGE = "개를 구매했습니다.";
    private static final String RECEIVE_MESSAGE = "를 입력해 주세요.";
    private static final String WINNING_MESSAGE = "당첨 번호";
    private static final String BONUS_MESSAGE = "보너스 번호";
    private static final String RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String YIELD_MESSAGE = "총 수익률은 %f%입니다.";

    public static void printBlank() {
        System.out.println();
    }

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printNotificationMessage(int count) {
        System.out.println(count + NOTIFICATION_MESSAGE);
    }

    public static void printLottoTickets(String lotto) {
        System.out.println(lotto);
    }

    public static void printReceiveWinningMessage() {
        System.out.println(WINNING_MESSAGE + RECEIVE_MESSAGE);
    }

    public static void printReceiveBonusMessage() {
        System.out.println(BONUS_MESSAGE + RECEIVE_MESSAGE);
    }

    public static void printBeforeResultMessage() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printResultMessage(int count, String reword, int winningNumber) {
        System.out.printf(RESULT_MESSAGE, count, reword, winningNumber);
    }

    public static void printYieldMessage(float yield) {
        System.out.printf(YIELD_MESSAGE, yield);
    }
}
