package lotto.message.input;

import lotto.message.ErrorMessage;
import lotto.domain.LottoMachine;

import java.util.List;

public class BonusNumberInputController extends InputController {

    public String input() {
        printController.printBonusNumberMessage();
        return readLine();
    }

    public void validate(Object input) {
        validateNumber((String) input);
        validateRange((String) input);
        validateDuplicate((String) input);
    }

    public void validateNumber(String input) {
        try {
            Integer.parseInt(input);

        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_MESSAGE.message);
        }
    }

    public void validateRange(String input) {
        int bonusNumber = Integer.parseInt(input);

        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_MESSAGE.message);
        }
    }

    public void validateDuplicate(String input) {
        int bonusNumber = Integer.parseInt(input);

        List<Integer> winNumber = new LottoMachine().getWinNumber().getLotto();

        if (winNumber.contains(bonusNumber))
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER_MESSAGE.message);
    }
}
