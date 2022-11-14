package lotto.view;

import java.util.List;

public class InputMessage {
    private final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요";
    private final String GAME_START = "게임 시작";
    private final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요";
    private final String NUMBER_PURCAHSES = "%d개를 구매했습니다.";
    private final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요";

    public void gameStart() {
        System.out.println(GAME_START);
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public void purchaseAmountMessage(int amount) {
        String format = String.format(NUMBER_PURCAHSES, amount / 1000);
        System.out.println(amount);
        System.out.println(format);
    }

    public void purchasedLottoNumberMessage(List<List<Integer>> lotts) {
        lotts.forEach(System.out::println);
        System.out.println(INPUT_WINNING_NUMBER);
    }

    public void winningNumberMessage(String winningNumber){
        System.out.println(winningNumber);
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public void bonusNumberMessage(String bonusNumber) {
        System.out.println(bonusNumber);
    }
}
