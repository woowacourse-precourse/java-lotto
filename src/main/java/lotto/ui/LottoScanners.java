package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class LottoScanners {

    private final LottoValidator validator;

    public LottoScanners() {
        this.validator = new LottoValidator();
    }

    public String inputPrice() {
        String input = Console.readLine();
        validator.validatePrice(input);

        return input;
    }

    public String inputWiningNumber() {
        String input = Console.readLine();
        validator.validateWinningNumbers(input);

        return input;
    }

    public String inputBonusNumber() {
        String input = Console.readLine();
        validator.validateBonusNumber(input);

        return input;
    }
}
