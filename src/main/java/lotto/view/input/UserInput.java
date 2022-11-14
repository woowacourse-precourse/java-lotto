package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class UserInput {

    public int getLottoCount(){
        int price = getPrice();
        return price / 1000;
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
        return input.split(",");
    }

    private String getUserInput() {
        return Console.readLine();
    }

}
