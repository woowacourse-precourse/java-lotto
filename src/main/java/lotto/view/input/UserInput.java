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

    public List<Integer> getWinningNumber(){
        String userInput = getUserInput();
        List<Integer> inputIntegers = getInputIntegers(userInput);
        Validator.validateSize(inputIntegers, 6);
        Validator.validateNumbersRange(inputIntegers, 1, 45);
        Validator.validateNonDuplicatedList(inputIntegers);
        return inputIntegers;
    }

    private List<Integer> getInputIntegers(String input){
        List<Integer> lst = new ArrayList<>();
        String[] split = getSplit(input);
        for (String s : split) {
            Validator.validateStringIsNumeric(s);
            lst.add(Integer.parseInt(s));
        }
        return lst;
    }

    private String[] getSplit(String input) {
        return input.split(",");
    }

    private String getUserInput() {
        return Console.readLine();
    }

}
