package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.PurchasingAmount;
import lotto.dto.ResultResponse;
import lotto.service.LottoService;
import lotto.domain.WinningNumber;
import lotto.view.OutputView;
import lotto.utils.Converter;
import lotto.utils.Validator;
import lotto.view.InputView;
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
            PurchasingAmount purchasingAmount = inputPurchasingAmount();

            List<Lotto> issuedLotteries = lottoService.issueLotto(purchasingAmount.getMoney());
            outputView.outputLotto(issuedLotteries);

            List<Integer> luckyNumber = inputLuckyNumber();
            String bonusNumberInput = inputBonusNumber(luckyNumber);

            ResultResponse result = checkLotto(issuedLotteries, luckyNumber, Integer.parseInt(bonusNumberInput));
            outputResult(purchasingAmount, result);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void outputResult(PurchasingAmount purchasingAmount, ResultResponse result) {
        outputView.outputWinningStatistics(result);
        outputView.outputEarningRate(lottoService.getEarningRate(
                purchasingAmount.getMoney(), lottoService.getEarning(result)));
    }

    private String inputBonusNumber(List<Integer> luckyNumber) {
        String bonusNumberInput = inputView.inputBonusNumber();
        validateBonusNumber(luckyNumber, bonusNumberInput);
        return bonusNumberInput;
    }

    private ResultResponse checkLotto(List<Lotto> issuedLotteries, List<Integer> luckyNumber, int bonusNumber) {
        WinningNumber winningNumber = new WinningNumber(new Lotto(luckyNumber), bonusNumber);
        return winningNumber.checkLotto(issuedLotteries);
    }

    private List<Integer> inputLuckyNumber() {
        String luckyNumberInput = inputView.inputLuckyNumber();
        validateLuckyNumber(luckyNumberInput);
        return converter.convertToLuckyNumber(luckyNumberInput);
    }

    private PurchasingAmount inputPurchasingAmount() {
        String purchasingAmountInput = inputView.inputPurchasingAmount();
        validatePurchasingAmount(purchasingAmountInput);
        return new PurchasingAmount(Integer.parseInt(purchasingAmountInput));
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
        validator.validatePurchasingAmountSize(input);
        validator.validatePurchasingAmountNumber(input);
        validator.validateMonetaryUnit(input);
    }
}
