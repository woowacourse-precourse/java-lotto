package lotto.controller;

import lotto.domain.LottoRank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.view.InputView.lottoPurchaseMoney;

public class LottoController {

    private final int LOTTO_ONE_GAME_PRICE = 1000;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoRank lottoRank;

    // 게임을 실행하는 메소드
    public void run(){
        outputView.printPriceInputMessage();

        int inputLottoMoney = inputView.inputLottoPurchaseMoney();
        int lottoTickets = createLottoTickets(inputLottoMoney);
        List<Integer> winningNumbers = createWinningNumbers();
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

    private int createLottoTickets (int inputMoney) {
        return inputMoney / LOTTO_ONE_GAME_PRICE;
    }

    private List<Integer> createWinningNumbers () {
        return inputView.createWinningNumber();
    }
}
