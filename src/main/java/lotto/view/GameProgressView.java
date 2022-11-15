package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;

public class GameProgressView {
    public static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String COUNT_MESSAGE = "개를 구매했습니다.";
    public static final String ENTER_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String ENTER_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void showPurchaseMessage() {
        System.out.println(PURCHASE_MESSAGE);
    }

    public void showCountMessage(int count) {
        System.out.println(count + COUNT_MESSAGE);
    }

    public void showBuyLottery(ArrayList<Lotto> lottery) {
        for (Lotto lotto : lottery) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void showEnterWinningNumbersMessage() {
        System.out.println(ENTER_WINNING_NUMBERS_MESSAGE);
    }

    public void showEnterBonusNumberMessage() {
        System.out.println(ENTER_BONUS_NUMBER_MESSAGE);
    }

}
