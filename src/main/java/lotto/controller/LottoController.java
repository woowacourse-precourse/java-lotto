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
            int purchasingAmount = inputPurchasingAmount();

            List<Lotto> issuedLotteries = lottoService.issueLotto(purchasingAmount);
            outputView.outputLotto(issuedLotteries);

            List<Integer> luckyNumber = inputLuckyNumber();
            String bonusNumberInput = inputBonusNumber(luckyNumber);

            HashMap<Integer, Integer> result = checkLotto(issuedLotteries, luckyNumber, bonusNumberInput);
            outputView.outputWinningStatistics(result);
            outputView.outputEarningRate(lottoService.getEarningRate(purchasingAmount, lottoService.getEarning(result)));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private String inputBonusNumber(List<Integer> luckyNumber) {
        String bonusNumberInput = inputView.inputBonusNumber();
        validateBonusNumber(luckyNumber, bonusNumberInput);
        return bonusNumberInput;
    }

    private HashMap<Integer, Integer> checkLotto(List<Lotto> issuedLotteries, List<Integer> luckyNumber, String bonusNumberInput) {
        WinningNumber winningNumber = new WinningNumber(new Lotto(luckyNumber), Integer.parseInt(bonusNumberInput));
        return winningNumber.checkLotto(issuedLotteries);
    }

    private List<Integer> inputLuckyNumber() {
        String luckyNumberInput = inputView.inputLuckyNumber();
        validateLuckyNumber(luckyNumberInput);
        return converter.convertToLuckyNumber(luckyNumberInput);
    }

    private int inputPurchasingAmount() {
        String purchasingAmountInput = inputView.inputPurchasingAmount();
        validatePurchasingAmount(purchasingAmountInput);
        return Integer.parseInt(purchasingAmountInput);
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
