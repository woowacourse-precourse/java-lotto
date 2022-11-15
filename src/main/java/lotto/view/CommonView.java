package lotto.view;

public class CommonView {
    public static void printExceptionMessage(Exception err) {
        System.out.println("[ERROR] " + err.getMessage());
    }

    public static void printInputAnswerMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printInputBonusMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printInputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }
}
