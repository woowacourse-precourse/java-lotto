package lotto;

import lotto.domain.PlayerLottoAmount;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        PlayerLottoAmount playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerAmount());
        int result = playerLottoAmount.calculateLottoCount();
        System.out.println(result);
    }
}
