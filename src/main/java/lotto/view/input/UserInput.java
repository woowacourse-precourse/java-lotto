package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.Validator;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.Constants.INPUT_SEPARATOR;
import static lotto.util.Constants.MONETARY_UNIT;

public class UserInput {

    public int getLottoCount(){
        int price = getPrice();
        return price / MONETARY_UNIT;
    }

    private int getPrice() {
        int price = getNumericPrice();
        Validator.validatePriceRange(price);
        Validator.validateUnit(price);
        return price;
    }

    private int getNumericPrice() {
        String userInput = getUserInput();
        Validator.validateStringIsNumeric(userInput);
        return Integer.parseInt(userInput);
    }

    public List<Integer> getWinningNumbersCandidate(){
        List<Integer> candidateNumbers = new ArrayList<>();

        String userInput = getUserInput();
        String[] splitString = getSplit(userInput);

        for (String str : splitString) {
            Validator.validateStringIsNumeric(str);
            candidateNumbers.add(Integer.parseInt(str));
        }

        return candidateNumbers;
    }

    public int getBonusNumber(){
        String userInput = getUserInput();
        Validator.validateStringIsNumeric(userInput);
        return Integer.parseInt(userInput);
    }

    private String[] getSplit(String input) {
        return input.split(INPUT_SEPARATOR);
    }

    private String getUserInput() {
        return Console.readLine();
    }

}
