package lotto.view;

public class InputView {
    public static final String REQUEST_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String REQUEST_WINNING_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void requestAmount() {
        System.out.println(REQUEST_AMOUNT);
    }

    public static void requestWinningLottoNumber() {
        System.out.println(REQUEST_WINNING_LOTTO_NUMBERS);
    }

    public static void requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
    }
}
