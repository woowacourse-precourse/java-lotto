package lotto.controller;

import lotto.model.*;
import lotto.view.Message;

import java.util.HashMap;
import java.util.Map;

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

        Map<Grade, Integer> lottoResult = new HashMap<>();
        for (Lotto lotto : user.getLottos()) {
            Grade grade = winningNumber.getResult(lotto);
            lottoResult.put(grade, lottoResult.getOrDefault(grade, 0) + 1);
        }

        message.printResult(lottoResult);
    }
}
