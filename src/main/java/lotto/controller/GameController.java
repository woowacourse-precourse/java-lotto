package lotto.controller;

import lotto.model.Computer;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.model.WinningNumber;
import lotto.view.Message;

public class GameController {
    private final Message message = new Message();
    private final User user = new User();
    private final Computer computer = new Computer();
    private final WinningNumber winningNumber = new WinningNumber();

    public void buyLotto() {
        message.inputPrice();
        user.inputPrice();
        message.countLotto(user.getCountLotto());

        for (int i = 0; i < user.getCountLotto(); i++) {
            Lotto lotto = computer.buyLotto();
            message.printLottoNumbers(lotto);
            user.addLotto(lotto);
        }
    }

    public void checkWinningNumbers() {
        message.inputWinningNumbers();
        winningNumber.inputWinningNumbers();

        message.inputBonusNumber();
        winningNumber.inputBonusNumber();
    }

    public void getResult() {
        message.startResult();
    }
}
