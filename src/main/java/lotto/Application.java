package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printPriceInputMessage();
        int lottoPurchaseMoney = inputView.inputLottoPurchaseMoney();
        int lottoChance = inputView.getLottoChance(lottoPurchaseMoney);

        List<Integer> winningNumbers = inputView.createWinningNumber();
        int bonusNumber = inputView.inputBonusNumber();

        inputView.allLottoNumber = inputView.createAllGameLottoNumber(lottoChance);
        outputView.printLottoPurchaseCompleteMessage(lottoChance);
        outputView.printLottoNumber(inputView.allLottoNumber);

        for (int i = 0; i < inputView.allLottoNumber.size(); i++) {
            inputView.compareWinningNumber(inputView.allLottoNumber.get(i),winningNumbers,bonusNumber);
        }
        outputView.printLottoRankResult(inputView.lottoResult);
        int lottoEarningMoney = inputView.calculrateLottoEarningMoney(inputView.lottoResult);
        String lottoEarningRate = inputView.calculrateLottoEarningRate(lottoEarningMoney, lottoPurchaseMoney);
        outputView.printLottoEarningRate(lottoEarningRate);
    }
}
