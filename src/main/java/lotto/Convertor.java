package lotto;

import java.util.ArrayList;
import java.util.List;

public class Convertor {
    private final static String COMMA = ",";

    public static Integer toPurchasePrice(String input) {
        Validator.checkIfNumeric(input);
        Validator.checkIfInThousands(input);

        Integer purchasePrice = getNumericValue(input);
        return purchasePrice;
    }

    public static List<Integer> separate(String input) {
        String[] inputSplitted = input.split(COMMA);
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
