package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.view.View;

/*
 * player의 입력을 담당하는 클래스
 * (최소한의 입력 값 유효성 검증 담당: 공백 여부, 정수 여부 검증)
 */

public class PlayerInput {

    public static int getInteger() {
        String input = Console.readLine().trim();

        if (input.isEmpty()) {
            View.printInputIsEmpty();
            throw new IllegalArgumentException();
        }

        if (!isPositiveInteger(input)) {
            View.printNotInteger();
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
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
            View.printNotInteger();
            throw new IllegalArgumentException();
        }

        if (!input.contains(",")) {
            View.printNotComma();
            throw new IllegalArgumentException();
        }

        return numbers;
    }

    private static boolean isPositiveInteger(String number) {
        for (int i = 0; i < number.length(); i++) {
            char needVerify = number.charAt(i);

            if (!Character.isDigit(needVerify)) {
                return false;
            }
        }
        return true;
    }

}
