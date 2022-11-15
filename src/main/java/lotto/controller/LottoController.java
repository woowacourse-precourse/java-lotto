package lotto.controller;

import lotto.domain.Computer;
import lotto.domain.Lotto;
import lotto.domain.Resource;
import lotto.domain.User;
import lotto.view.Message;
import lotto.view.UserInterface;

public class LottoController {

    private String userInput;
    private long inputMoney;
    private long lottoCount;

    UserInterface userInterface = new UserInterface();
    User user;
    Computer computer;
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
        inputMoney = Long.parseLong(userInput);
        lottoCount = inputMoney / Resource.LOTTO_PRICE;
        computer = new Computer(lottoCount);
        userInterface.showAutoLottos(Computer.getAutoLottos(), lottoCount);
    }

    private void getUserWinningNumber() {
        userInput = userInterface.getUserInput(Message.WINNING_ENTER);
        user = new User(Message.WINNING_NUMBER);
        user.validateUserWinningNumber(userInput);
        computer.makeWinningNumbers(userInput);
        lotto = new Lotto(Computer.getWinningNumbers());
    }

    private void getUserBonusNumber() {
        userInput = userInterface.getUserInput(Message.BONUS_ENTER);
        user = new User(Message.BONUS_NUMBER);
        user.validateUserBonusNumber(userInput, Computer.getWinningNumbers());
    }

    private void resultCalculation() {
        computer.checkWining(Integer.parseInt(userInput));
        computer.yieldCalculation(inputMoney);
        userInterface.printResult();
    }


}
