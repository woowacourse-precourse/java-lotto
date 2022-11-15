package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.validator.LottoNumberValidator;
import lotto.domain.validator.PriceValidator;
import lotto.util.ProcessMessages;

public class Input {
    private final LottoNumberValidator numberValidator;
    private final PriceValidator priceValidator;
    private final Output output;


    public Input() {
        this.numberValidator = new LottoNumberValidator();
        this.priceValidator = new PriceValidator();
        this.output = new Output();
    }

    public List<String> scanNumbers() {
        output.printMessage(ProcessMessages.REQUEST_WINNING_NUMBER.getMessage());
        String inputValue = Console.readLine();
        output.printMessage(ProcessMessages.EMPTY_LINE.getMessage());
        numberValidator.validateFomula(inputValue);
        return Arrays.asList(inputValue.split(","));
    }

    public String scanBonus() {
        output.printMessage(ProcessMessages.REQUEST_BONUS_NUMBER.getMessage());
        String inputValue = Console.readLine();
        output.printMessage(ProcessMessages.EMPTY_LINE.getMessage());
        numberValidator.validateBonus(inputValue);
        return inputValue;
    }

    public String scanMoney() {
        output.printMessage(ProcessMessages.REQUEST_MONEY_INPUT.getMessage());
        String inputValue = Console.readLine();
        output.printMessage(ProcessMessages.EMPTY_LINE.getMessage());
        priceValidator.validateMoneyInput(inputValue);
        return inputValue;
    }
}
