package lotto.controller;

import lotto.domain.Auto;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.view.UserInterface;

public class LottoController {

    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private String userInput ;
    public static int lottoCount;

    UserInterface userInterface = new UserInterface();
    User user;
    Auto auto;
    Lotto lotto;

    public void gameStart() throws IllegalArgumentException {
        userInput = userInterface.getUserInput(PURCHASE_AMOUNT);
        user = new User("구매금액");
        user.validateUserMoney(userInput);
        lottoCount = Integer.parseInt(userInput)/1000;
        auto = new Auto(lottoCount);
        userInterface.showAutoLottos(Auto.AUTO_LOTTOS, lottoCount);
        userInput = userInterface.getUserInput(WINNING_NUMBER);
        user = new User("당첨 번호");
        user.validateUserWinningNumber(userInput);
        auto.makeWinningNumbers(userInput);
        lotto = new Lotto(Auto.WINNING_NUMBERS);
        userInput = userInterface.getUserInput(BONUS_NUMBER);
        user = new User("보너스 번호");
        user.validateUserBonusNumber(userInput, Auto.WINNING_NUMBERS);
        auto.checkWining(Integer.parseInt(userInput));
        auto.yieldCalculation(lottoCount*1000);
        userInterface.printResult();
    }
}
