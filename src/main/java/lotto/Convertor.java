package lotto;

import java.util.ArrayList;
import java.util.List;

public class Convertor {
    public static List<Integer> separate(String input) {
        String[] inputSplitted = input.split(",");
        Validator.checkFormat(inputSplitted);

        List<Integer> inputConverted = new ArrayList<>();
        for (String element : inputSplitted) {
            Validator.checkIfNumeric(element);
            Integer numericValue = Integer.valueOf(element);
            inputConverted.add(numericValue);
        }
        return inputConverted;
    }

    public static Integer getNumericValue(String input) {
        Validator.checkIfNumeric(input);
        Integer numericValue = Integer.valueOf(input);
        return numericValue;
    }
}
