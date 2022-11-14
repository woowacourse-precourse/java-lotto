package lotto.controller;

import lotto.domain.validutils.LottoValidationUtils;
import lotto.dto.GameResultResponseDtos;
import lotto.dto.LottoResponseDtos;
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
        lottoGameService.createPlayer(purchasePrice);
        printLottos(lottoGameService.getPurchaseLottos());

        List<Integer> answers = inputAnswerNumbers();
        int bonusNumber = inputBonusNumber();
        lottoGameService.createAnswer(answers, bonusNumber);

        printWinningResult(lottoGameService.playGame());
    }

    private int inputPurchasePrice() {
        OutputView.printInputPurchasePrice();
        return InputView.inputPurchasePrice();
    }

    private void printLottos(LottoResponseDtos lottoResponseDtos) {
        OutputView.printBlankLine();
        OutputView.printPurchaseLottos(lottoResponseDtos);
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
