package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputPreprocessUtils {
    public static List<Integer> preprocess(String input){
        String[] stringNumbers = splitByComma(input);
        isInteger(stringNumbers);

        List<String> list = Arrays.asList(stringNumbers);
        return list.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int stringToInteger(String input){
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private static String[] splitByComma(String input){
        return input.replace(" ", "").split(",");
    }

    private static void isInteger(String[] inputs){
        for(String input: inputs){
            validateNumber(input);
        }
    }

    private static void validateNumber(String input){
        if(!ValidateUtils.isNumber(input)){
            ValidateUtils.throwIllegalArgumentException(Constants.INVALID_PURCHASE_INPUT_MESSAGE);
        }
    }
}
