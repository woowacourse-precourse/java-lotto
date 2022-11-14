package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static String inputToQuestion() {
        return Console.readLine();
    }

    public static int convertToNumber() {
        try {
            return Integer.parseInt(inputToQuestion());
        }
        catch(Exception e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public static List<Integer> convertToList() {
        try {
            return Arrays.stream(inputToQuestion().split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
