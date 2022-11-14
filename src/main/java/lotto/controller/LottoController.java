package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoService;
import lotto.model.WinningNumber;
import lotto.view.OutputView;
import lotto.utils.Converter;
import lotto.utils.Validator;
import lotto.view.InputView;

import java.util.HashMap;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;
    private final LottoService lottoService;
    private final Converter converter;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
        validator = new Validator();
        lottoService = new LottoService();
        converter = new Converter();
    }

    public void start() {
        try {
            String purchasingAmountInput = inputView.inputPurchasingAmount();
            validatePurchasingAmount(purchasingAmountInput);
            int purchasingAmount = Integer.parseInt(purchasingAmountInput);

            List<Lotto> issuedLotteries = lottoService.issueLotto(purchasingAmount);
            outputView.outputLotto(issuedLotteries);

            String luckyNumberInput = inputView.inputLuckyNumber();
            validateLuckyNumber(luckyNumberInput);
            List<Integer> luckyNumber = converter.convertToLuckyNumber(luckyNumberInput);

            String bonusNumberInput = inputView.inputBonusNumber();
            validateBonusNumber(luckyNumber, bonusNumberInput);

            WinningNumber winningNumber = new WinningNumber(new Lotto(luckyNumber), Integer.parseInt(bonusNumberInput));
            HashMap<Integer, Integer> result = winningNumber.checkLotto(issuedLotteries);
            outputView.outputWinningStatistics(result);

            outputView.outputEarningRate(lottoService.getEarningRate(purchasingAmount, lottoService.getEarning(result)));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void validateBonusNumber(List<Integer> luckyNumber, String bonusNumber) {
        validator.validateBonusNumberSize(bonusNumber);
        validator.validateBonusNumberDigit(bonusNumber);
        validator.validateBonusNumberRange(bonusNumber);
        validator.validateDuplication(luckyNumber, bonusNumber);
    }

    private void validateLuckyNumber(String luckyNumber) {
        validator.validateLuckyNumberSize(luckyNumber);
        validator.validateLuckyNumberDigit(luckyNumber);
        validator.validateLuckyNumberRange(luckyNumber);
        validator.validateLuckyNumberDuplication(luckyNumber);
    }

    private void validatePurchasingAmount(String input) {
        validator.validateSize(input);
        validator.validateNumber(input);
        validator.validateMonetaryUnit(input);
    }
}
