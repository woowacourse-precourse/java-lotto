package lotto.controller;

import lotto.domain.Computer;
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
    Computer auto;
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
        auto = new Computer(lottoCount);
        userInterface.showAutoLottos(Computer.getAutoLottos(), lottoCount);
    }

    private void getUserWinningNumber() {
        userInput = userInterface.getUserInput(Message.WINNING_ENTER);
        user = new User(Message.WINNING_NUMBER);
        user.validateUserWinningNumber(userInput);
        auto.makeWinningNumbers(userInput);
        lotto = new Lotto(Computer.getWinningNumbers());
    }

    private void getUserBonusNumber() {
        userInput = userInterface.getUserInput(Message.BONUS_ENTER);
        user = new User(Message.BONUS_NUMBER);
        user.validateUserBonusNumber(userInput, Computer.getWinningNumbers());
    }

    private void resultCalculation() {
        auto.checkWining(Integer.parseInt(userInput));
        auto.yieldCalculation(inputMoney);
        userInterface.printResult();
    }


}
