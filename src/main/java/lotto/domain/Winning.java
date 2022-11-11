package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.ConsoleUtils;
import lotto.validate.NumberValidator;

public class Winning {
    private List<Integer> numbers = new ArrayList<>();
    private NumberValidator validator = new NumberValidator();

    public void inputNumber() {
        String input = ConsoleUtils.input();
        String[] splitNumbers = input.split(",");

        validateInputNumber(splitNumbers);

        convertStringToInteger(splitNumbers);
    }

    private void validateInputNumber(String[] splitNumbers) {
        validator.validateSize(splitNumbers);

        for (String splitNumber : splitNumbers) {
            validator.validateInputNumber(splitNumber);
        }
    }

    private void convertStringToInteger(String[] splitNumbers) {
        for (String splitNumber : splitNumbers) {
            numbers.add(Integer.parseInt(splitNumber));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
