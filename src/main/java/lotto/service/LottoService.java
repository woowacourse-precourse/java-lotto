package lotto.service;

import lotto.message.ErrorMessage;
import lotto.repository.LottoRepository;
import lotto.validation.Validator;
import lotto.view.input.Input;
import lotto.view.output.Output;

public class LottoService {

    LottoRepository lottoRepository;
    Validator validator;

    Input input;

    Output output;
    public LottoService() {
        this.lottoRepository = new LottoRepository();
        this.validator = new Validator();
        this.input = new Input();
        this.output = new Output();
    }

    public int getMoney() throws IllegalArgumentException{
        String money = input.scanMoneyInput();
        if (!validator.isNumeric(money)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_TYPE_ERROR.getErrorMessage());
        }
        if (!validator.isCorrectUnit(money)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_UNIT_ERROR.getErrorMessage());
        }
        return Integer.parseInt(money);
    }
}
