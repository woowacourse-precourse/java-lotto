package lotto.view;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO = "개를 구매했습니다.";
    private static final String INPUT_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void setInputMoney() {
        System.out.println(INPUT_MONEY);
    }

    public static void printLottoPurchaseCount(int count) {
        System.out.println(count + PURCHASE_LOTTO);
    }

    public static void printInputLottoNumber() {
        System.out.println(INPUT_LOTTO_NUMBER);
    }

    public static void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }
}
