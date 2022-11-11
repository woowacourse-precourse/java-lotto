package lotto;

public class ShowMessage {

    private final static String AMOUNT_BUY_MESSAGE = "구입 금액을 입력해 주세요.";
    private final static String HOW_MANY_BUY_MESSAGE = "개를 구매했습니다.";

    public void showInputAmountBuy() {
        System.out.println(AMOUNT_BUY_MESSAGE);
    }

    public void showHowManyBuy(int number) {
        System.out.println(number + HOW_MANY_BUY_MESSAGE);
    }

}
