package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.service.Service;
import lotto.utils.Utils;
import lotto.view.InputMessage;
import lotto.view.OutputMessage;
import java.util.List;

public class Controller {
    private static final int LOTTO_LEAST_AMOUNT = 1_000;

    private final Service service = new Service();
    private Buyer buyer;
    private LottoGame lottoGame;

    public void run() {
        beforeLottoGame();
        initLottoGame();
        showGameResult();
    }

    private void beforeLottoGame() {
        buyer = new Buyer(getInputAmount());
        service.buyAllLotto(buyer);
        showBuyingResult();
    }

    private void initLottoGame() {
        lottoGame = new LottoGame(getInputWinningNumbers(), getInputBonusNumber());
    }

    private void showGameResult() {
        service.checkBuyerLotteries(buyer, lottoGame);
        OutputMessage.winningStatistics();
        OutputMessage.showRankResult(buyer.getLottoResult());
        OutputMessage.showYieldResult(buyer.getYield());
    }

    private int getInputAmount() {
        InputMessage.inputAmount();
        String userInput = readLine().trim();
        return Utils.stringToInteger(userInput);
    }

    private void showBuyingResult() {
        OutputMessage.purchaseComplete(buyer.getPurchaseAmount() / LOTTO_LEAST_AMOUNT);
        for (Lotto lotto : buyer.getPurchasedLotteries()) {
            OutputMessage.lottoNumbers(lotto.getNumbers());
        }
    }

    private List<Integer> getInputWinningNumbers() {
        InputMessage.inputWinningNumbers();
        return Utils.stringToIntegerList(readLine().trim());
    }

    private int getInputBonusNumber() {
        InputMessage.inputBonusNumber();
        return Utils.stringToInteger(readLine().trim());
    }
}
