package lotto.view;

public class InputMessage {
    private final String GAME_START = "게임 시작";
    private final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요";
    public void gameStart() {
        System.out.println(GAME_START);
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public void purchaseAmountMessage(String amount) {
        System.out.println(amount);
    }
}
