package lotto.domain;

import lotto.validation.InputValidation;
import java.util.ArrayList;
import java.util.List;

public class WinNumber {

    private List<Integer> winLottoNumber = new ArrayList<>();

    public WinNumber(String userInput) {
        try {
            isValidInput(userInput);
            InputValidation.isNumber(userInput);
        } catch (IllegalArgumentException e) {
            e.getMessage();
            return;
        }
        winLottoNumber(userInput);
    }

    public List<Integer> getWinLottoNumber() {
        return winLottoNumber;
    }

    public List<String> splitInput(String input) {
        List<String> winLotto = List.of(input.split(","));
        return winLotto;
    }

    public void isValidInput(String userInput) {
        List<String> input = splitInput(userInput);
        InputValidation.isValidLottoWinInput(input);
    }

    public void winLottoNumber(String userInput) {
        List<String> orginInput = splitInput(userInput);
        for (String input: orginInput) {
            winLottoNumber.add(Integer.valueOf(input));
        }
    }
}
