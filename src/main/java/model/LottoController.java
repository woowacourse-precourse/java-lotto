package model;

import utils.Converter;
import utils.Validator;
import view.InputView;
import view.OutputView;

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
        String money = inputView.inputMoney();
        validatePurchasingAmount(money);

        outputView.outputLotto(lottoService.issueLotto(Integer.parseInt(money)));

        String luckyNumber = inputView.inputLuckyNumber();
        validateLuckyNumber(luckyNumber);

        String bonusNumber = inputView.inputBonusNumber();
        validateBonusNumber(luckyNumber, bonusNumber);
    }

    private void validateBonusNumber(String luckyNumber, String bonusNumber) {
        validator.validateBonusNumberSize(bonusNumber);
        validator.validateBonusNumberDigit(bonusNumber);
        validator.validateBonusNumberRange(bonusNumber);
        validator.validateDuplication(converter.convertToLuckyNumber(luckyNumber), bonusNumber);
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

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.start();
    }
}
