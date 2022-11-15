package lotto;

import utils.UserInput;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constant.*;

public class GameController {
    List<List<Integer>> myLottos = new ArrayList<>();
    List<Integer> winningNumbers = new ArrayList<>();
    int bonusNumber;

    public void buyLotto() {
        LottoSeller orderLotto = new LottoSeller();

        orderLotto.getPayAmount();
        orderLotto.countNumberOfTickets();
        myLottos = orderLotto.generateTickets();
        orderLotto.printTicket();
    }

    public void drawLotto() {
        UserInput input = new UserInput();
        LottoDrawing winningNumbers = input.getWinningNumber();

        this.winningNumbers = winningNumbers.winningNumbers;
        this.bonusNumber = winningNumbers.bonusNumber;
    }

    public void getResult() {
        NumberChecker numberChecker = new NumberChecker(winningNumbers, bonusNumber, myLottos);

        numberChecker.countRanks();

        LottoResult result = new LottoResult();

        result.printResult(myLottos.size());
    }
}
