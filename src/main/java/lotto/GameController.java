package lotto;

import utils.UserInput;

import java.util.ArrayList;
import java.util.List;

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

        this.winningNumbers = winningNumbers.winningNumber;
        this.bonusNumber = winningNumbers.bonusNumber;
    }

    public void getResult() {
        PrizeEnum.reset();
        NumberChecker numberChecker = new NumberChecker(winningNumbers, bonusNumber, myLottos);

        numberChecker.countRanks();

        LottoResult result = new LottoResult();

        result.printResult(myLottos.size());
    }
}
