package view;

public class InputView {
    public static final String PUSH_PURCHASING_MONEY = "구입금액을 입력해 주세요.";
    public static final String SHOW_MONEY_ERROR = "[ERROR] 로또 구입 금액을 바르게 입력해주시기 바랍니다.";
    public static final String PUSH_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String PUSH_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void pushPurchasingMoney(){
        System.out.println(PUSH_PURCHASING_MONEY);
    }
    public static void showMoneyError() {
        System.out.println(SHOW_MONEY_ERROR);
    }

    public static void pushWinningNumber() {
        System.out.println(PUSH_WINNING_NUMBER);
    }

    public static void pushBonusNumber() {
        System.out.println(PUSH_BONUS_NUMBER);
    }
}
