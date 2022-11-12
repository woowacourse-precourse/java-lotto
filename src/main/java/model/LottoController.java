package model;

import utils.Validator;
import view.InputView;
import view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;
    private final LottoService lottoService;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
        validator = new Validator();
        lottoService = new LottoService();
    }

    public void start() {
        String money = inputView.inputMoney();
        validatePurchasingAmount(money);

        outputView.outputLotto(lottoService.issueLotto(Integer.parseInt(money)));

        String luckyNumber = inputView.inputLuckyNumber();
        validateLuckyNumber(luckyNumber);

        String bonusNumber = inputView.inputBonusNumber();
        validator.validateBonusNumberSize(bonusNumber);
        validator.validateBonusNumberDigit(bonusNumber);
        validator.validateBonusNumberRange(bonusNumber);

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
