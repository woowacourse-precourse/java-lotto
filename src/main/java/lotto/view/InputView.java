package lotto.view;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";

    private InputView() {}

    public static void inputLottoAmountMessage() {
        System.out.println(INPUT_LOTTO_AMOUNT);
    }

    public static void inputWinLottoNumberMessage() {
        System.out.println(INPUT_WIN_LOTTO_NUMBER);
    }
}
