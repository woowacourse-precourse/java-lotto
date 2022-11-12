package lotto.controller;

import lotto.domain.LottoValidationUtils;
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
        int purchasePrice = inputPurchasePrice();
        printLottos(purchasePrice);

        lottoGameService.createAnswer(inputAnswerNumbers(), inputBonusNumber());

        printWinningResult(lottoGameService.playGame(purchasePrice));
    }

    private int inputPurchasePrice() {
        OutputView.printInputPurchasePrice();
        return InputView.inputPurchasePrice();
    }

    private void printLottos(int purchasePrice) {
        OutputView.printBlankLine();
        LottosResponseDto lottosResponseDto = lottoGameService.purchaseLottos(purchasePrice);
        OutputView.printPurchaseLottos(lottosResponseDto);
    }

    private List<Integer> inputAnswerNumbers() {
        OutputView.printBlankLine();
        OutputView.printInputAnswerNumbers();
        List<Integer> answers = InputView.inputAnswerNumbers();
        LottoValidationUtils.validate(answers);
        return answers;
    }

    private int inputBonusNumber() {
        OutputView.printBlankLine();
        OutputView.printInputBonusNumber();
        return InputView.inputBonusNumber();
    }

    private void printWinningResult(GameResultResponseDtos gameResponseDto) {
        OutputView.printBlankLine();
        OutputView.printWinningStatisticsMessage();
        OutputView.printWinningStatistics(gameResponseDto);
    }
}
