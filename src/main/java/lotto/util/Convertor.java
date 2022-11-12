package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.machine.Lotto;

public class Convertor {
    private final static String COMMA = ",";

    public static Integer toPurchasePrice(String arg) {
        Validator.checkIfNumeric(arg);
        Validator.checkIfInThousands(arg);

        Integer purchasePrice = toNumericValue(arg);
        return purchasePrice;
    }

    public static List<Integer> separate(String arg) {
        String[] argSplitted = arg.split(COMMA);
        Validator.checkFormat(argSplitted);

        List<Integer> numbers = new ArrayList<>();
        for (String element : argSplitted) {
            numbers.add(toNumericValue(element));
        }
        return numbers;
    }

    public static Integer toNumericValue(String arg) {
        Validator.checkIfNumeric(arg);
        Integer numericValue = Integer.valueOf(arg);
        return numericValue;
    }
}
