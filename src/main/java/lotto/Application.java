package lotto;

import lotto.domain.LottoRank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.InputView.lottoPurchaseMoney;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoRank lottoRank;

        outputView.printPriceInputMessage();



        List<Integer> winningNumbers = inputView.createWinningNumber();
        int bonusNumber = inputView.inputBonusNumber();

        inputView.allLottoNumber = inputView.createAllGameLottoNumber(lottoTickets);
        outputView.printLottoPurchaseCompleteMessage(lottoTickets);
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
