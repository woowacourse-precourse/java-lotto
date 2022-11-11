package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.util.Convertor;
import lotto.view.View;

/*
 * player의 입력을 담당하는 객체
 */

public class Player {

    public int inputSingleNumber() {
        String input = input();
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (IllegalArgumentException ie) {
            View.printNotInteger();
            throw ie;
        }
        return number;
    }

    public List<Integer> inputLottoNumbers() {
        String input = input();
        List<String> checkComma;
        List<Integer> numbers;

        try {
            checkComma = new ArrayList<>(Arrays.asList(input.split("\\s*,\\s*")));
        } catch (IllegalArgumentException ie) {
            View.printNotComma();
            throw ie;
        }

        try {
            numbers = Convertor.StringToInteger(checkComma);
        } catch (IllegalArgumentException ie) {
            View.printNotInteger();
            throw ie;
        }
        return numbers;
    }

    private static String input() {
        return Console.readLine();
    }
}
