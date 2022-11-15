package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputPreprocessUtils {
    public static List<Integer> preprocess(String input){
        String[] stringNumbers = splitByComma(input);
        isInterger(stringNumbers);

        List<String> list = Arrays.asList(stringNumbers);
        return list.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private static String[] splitByComma(String input){
        return input.replace(" ", "").split(",");
    }

    private static void isInterger(String[] inputs){
        for(String input: inputs){
            if(ValidateUtils.isNumber(input)){
                ValidateUtils.throwIllegalArgumentException(Constants.INVALID_PURCHASE_INPUT_MESSAGE);
            }
        }
    }
}
