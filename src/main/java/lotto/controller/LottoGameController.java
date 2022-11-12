package lotto.controller;

import lotto.dto.GameResultResponseDtos;
import lotto.dto.LottosResponseDto;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {

    private final LottoGameService lottoGameService;

    public LottoGameController(LottoGameService lottoGameService) {
        this.lottoGameService = lottoGameService;
    }

    public void run() {
        OutputView.printInputPurchasePrice();
        int purchasePrice = InputView.inputPurchasePrice();

        LottosResponseDto lottosResponseDto = lottoGameService.purchaseLottos(purchasePrice);
        OutputView.printPurchaseLottos(lottosResponseDto);

        OutputView.printInputAnswerNumbers();
        List<Integer> answerNumbers = InputView.inputAnswerNumbers();
        OutputView.printInputBonusNumber();
        int bonusNumber = InputView.inputBonusNumber();
        lottoGameService.createAnswer(answerNumbers, bonusNumber);

        GameResultResponseDtos gameResponseDto = lottoGameService.playGame(purchasePrice);
        OutputView.printWinningStatisticsMessage();
        OutputView.printWinningStatistics(gameResponseDto);
    }
}
