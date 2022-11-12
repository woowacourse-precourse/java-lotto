package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.util.Convertor;
import lotto.view.View;

/*
 * player의 입력을 담당하는 객체
 */

public class Player {

    public String input() {
        return Console.readLine();
    }

    public List<Integer> inputLottoNumbers() {
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
