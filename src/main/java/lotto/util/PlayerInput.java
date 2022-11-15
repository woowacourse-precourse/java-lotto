package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.view.View;

/*
 * player의 입력을 담당하는 클래스
 * (최소한의 입력 값 유효성 검증 담당: 공백 여부, 정수 여부 검증)
 */

public class PlayerInput {

    public static int getInteger() {
        String input = Console.readLine().trim();
        int number;

        if (input.isEmpty()) {
            View.printInputIsEmpty();
            throw new IllegalArgumentException();
        }

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException ie) {
            View.printNotInteger();
            throw new IllegalArgumentException();
        }
        return number;
    }

    public static List<Integer> getLottoNumbers() {
        String input = Console.readLine().trim();
        List<Integer> numbers;

        if (input.isEmpty()) {
            View.printInputIsEmpty();
            throw new IllegalArgumentException();
        }

        try {
            numbers = Convertor.StringToInteger(Arrays.asList(input.split("\\s*,\\s*")));
        } catch (IllegalArgumentException ie) {
            View.printNotLottoNumber(Lotto.getStartNumber(), Lotto.getEndNumber());
            throw new IllegalArgumentException();
        }

        if (!input.contains(",")) {
            View.printNotComma();
            throw new IllegalArgumentException();
        }
        return numbers;
    }

}
