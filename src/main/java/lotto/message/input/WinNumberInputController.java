package lotto.message.input;

import lotto.message.ErrorMessage;

import java.util.List;

public class WinNumberInputController extends InputController {

    public String input() {
        printController.printWinNumberMessage();
        return readLine();
    }

    public void validate(Object input) {
        List<String> winNumber = (List<String>) input;

        long winNumberSize = winNumber.stream().filter(number -> isCorrectLottoNumber(number)).count();

        if (winNumberSize != LOTTO_NUMBER_LENGTH)
            throw new IllegalArgumentException(ErrorMessage.SIX_NUMBER_MESSAGE.message);
    }

    public boolean isCorrectLottoNumber(String number) {
        try {
            int convertedNumber = Integer.parseInt(number);

            if (MIN_NUMBER <= convertedNumber && convertedNumber <= MAX_NUMBER)
                return true;
        } catch (Exception e) {
            return false;
        }

        return false;
    }
}
