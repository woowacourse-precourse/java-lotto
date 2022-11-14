package lotto.controller;

import lotto.domain.Auto;
import lotto.domain.Lotto;
import lotto.domain.Resource;
import lotto.domain.User;
import lotto.view.Message;
import lotto.view.UserInterface;

public class LottoController {

    private String userInput;
    private int inputMoney;
    private int lottoCount;

    UserInterface userInterface = new UserInterface();
    User user;
    Auto auto;
    Lotto lotto;

    public void gameStart() throws IllegalArgumentException {
        sellLottos();
        getUserWinningNumber();
        getUserBonusNumber();
        resultCalculation();
    }

    private void sellLottos() {
        userInput = userInterface.getUserInput(Message.PURCHASE_ENTER);
        user = new User(Message.PURCHASE_AMOUNT);
        user.validateUserMoney(userInput);
        inputMoney = Integer.parseInt(userInput);
        lottoCount = inputMoney / Resource.LOTTO_PRICE;
        auto = new Auto(lottoCount);
        userInterface.showAutoLottos(Auto.AUTO_LOTTOS, lottoCount);
    }

    private void getUserWinningNumber() {
        userInput = userInterface.getUserInput(Message.WINNING_ENTER);
        user = new User(Message.WINNING_NUMBER);
        user.validateUserWinningNumber(userInput);
        auto.makeWinningNumbers(userInput);
        lotto = new Lotto(Auto.WINNING_NUMBERS);
    }

    private void getUserBonusNumber() {
        userInput = userInterface.getUserInput(Message.BONUS_ENTER);
        user = new User(Message.BONUS_NUMBER);
        user.validateUserBonusNumber(userInput, Auto.WINNING_NUMBERS);
    }

    private void resultCalculation() {
        auto.checkWining(Integer.parseInt(userInput));
        auto.yieldCalculation(inputMoney);
        userInterface.printResult();
    }


}
