package lotto;

import java.util.List;

public class WinNumberInputController extends InputController {

    public String input() {
        printController.printWinNumberMessage();
        return readLine();
    }

    public void validate(Object input) {

        List<String> winNumber = (List<String>)input;

        long winNumberSize = winNumber.stream().filter(number -> isCorrectLottoNumber(number)).count();

        if(winNumberSize != 6)
            throw new IllegalArgumentException(ErrorMessage.SIX_NUMBER_MESSAGE.message);
    }

    public boolean isCorrectLottoNumber(String number) {

        try {
            int convertedNumber = Integer.parseInt(number);

            if(1 <= convertedNumber && convertedNumber <= 45)
                return true;
        } catch (Exception e) {
            return false;
        }

        return false;
    }
}
