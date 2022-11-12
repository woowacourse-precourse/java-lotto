package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.view.View;

/*
 * player의 입력을 담당하는 클래스
 */

public class PlayerInput {

    public static int getInteger() {
        String input = Console.readLine();

        if (!Validator.isInteger(input)) {
            View.printNotInteger();
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }

    public static List<Integer> getLottoNumbers() {
        String input = Console.readLine();
        List<Integer> numbers;

        if (!input.contains(",")) {
            View.printNotComma();
            throw new IllegalArgumentException();
        }

        try {
            numbers = Convertor.StringToInteger(Arrays.asList(input.split("\\s*,\\s*")));
        } catch (IllegalArgumentException ie) {
            View.printNotInteger();
            throw new IllegalArgumentException();
        }
        return numbers;
    }

}
