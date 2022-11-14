package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constant.*;

public class GameController {
    List<List<Integer>> myLottos = new ArrayList<>();
    List<Integer> winningNumbers = new ArrayList<>();
    int bonusNumber;

    public void buyLotto() {
        LottoSeller lottoPurchase = new LottoSeller();

        lottoPurchase.getPayAmount();
        lottoPurchase.countTicket();
        lottoPurchase.printTicket();
    }

    public void drawLotto() {
        LottoDrawing numberDrawing = new LottoDrawing();

        numberDrawing.getWinningNumber();
        numberDrawing.getBonusNumber();

        Lotto winningNumbers = new Lotto(numberDrawing.winningNumbers);

        this.winningNumbers = winningNumbers.getNumbers();
        bonusNumber = numberDrawing.bonusNumber;
    }

    public void getResult() {
        NumberChecker numberChecker = new NumberChecker(winningNumbers, bonusNumber, myLottos);

        numberChecker.compareNumber();
        numberChecker.countRanks();

        LottoResult result = new LottoResult();

        result.printResult(myLottos.size());
    }
}
