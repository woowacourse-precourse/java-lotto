package lotto;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.veiw.InputHandler;

public class Application {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        inputHandler.inputMoney();

        // print 구매된 로도 목록

        Lotto lotto = inputHandler.inputLotto();
        BonusNumber bonusNumber = inputHandler.inputBonus(lotto);
    }
}
