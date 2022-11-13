package lotto.controller;

import lotto.model.Auto;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.UserInterface;

public class LottoController {

    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";

    private String userInput ;
    public static int lottoCount;

    UserInterface userInterface = new UserInterface();

    public void gameStart() throws IllegalArgumentException {
        userInput = userInterface.getUserInput(PURCHASE_AMOUNT);
        User user = new User("구매금액");
        user.validateUserMoney(userInput);
        lottoCount = Integer.parseInt(userInput)/1000;
        Auto auto = new Auto(lottoCount);
        userInterface.showAutoLottos(Auto.AUTO_LOTTOS, lottoCount);
        userInput = userInterface.getUserInput(WINNING_NUMBER);
        user = new User("당첨번호");
        user.validateUserWinningNumber(userInput);
        auto.makeWinningNumbers(userInput);
        Lotto lotto = new Lotto(Auto.WINNING_NUMBERS);


    }
}
