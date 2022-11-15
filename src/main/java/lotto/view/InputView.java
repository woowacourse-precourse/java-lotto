package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String SPLIT_COMMA = ",";
    private static String inputToQuestion() {
        return Console.readLine();
    }

    public static String inputMoney() {
        return Console.readLine();
    }

    public static int convertToNumber() {
        try {
            return Integer.parseInt(inputToQuestion());
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.getErrorMessage());
        }
    }

    public static List<Integer> convertToList() {
        try {
            return Arrays.stream(inputToQuestion().split(SPLIT_COMMA))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.getErrorMessage());
        }
    }

}
