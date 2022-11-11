package lotto;

public class ShowMessage {

    private final static String INPUT_AMOUNT_BUY_MESSAGE = "구입 금액을 입력해 주세요.";
    private final static String HOW_MANY_BUY_MESSAGE = "개를 구매했습니다.";
    private final static String INPUT_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";

    public void showInputAmountBuy() {
        System.out.println(INPUT_AMOUNT_BUY_MESSAGE);
    }

    public void showHowManyBuy(int number) {
        System.out.println(number + HOW_MANY_BUY_MESSAGE);
    }

    public void showInputLottoNumber() {
        System.out.println(INPUT_LOTTO_NUMBER);
    }

}
