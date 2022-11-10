package lotto.view;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO = "개를 구매했습니다.";

    public static void setInputMoney() {
        System.out.println(INPUT_MONEY);
    }

    public static void printLottoCount(int count) {
        System.out.println(count + PURCHASE_LOTTO);
    }
}
