package lotto.check;

import lotto.domain.Const;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumberCheck {

    private static final String rangeErrMsg = "1~45사이의 숫자를 입력해 주세요.";

    public static List<Integer> check(String winningNumber) {
        winningNumber = winningNumber.replace(" ", "");
        String[] split = winningNumber.split(",");
        List<String> numbers = Arrays.asList(split);
        if (!checkNumber(numbers)) {
            throw new IllegalArgumentException(rangeErrMsg);
        }
        return toIntegerList(numbers);
    }

    private static List<Integer> toIntegerList(List<String> split) {
        ArrayList<Integer> winningNumber = new ArrayList<>();
        for (String s : split) {
            winningNumber.add(Integer.parseInt(s));
        }
        return winningNumber;
    }

    private static boolean checkNumber(List<String> numbers) {
        for (String number : numbers) {
            if (!isRange(number)) return false;
        }
        return true;
    }

    private static boolean isRange(String number) {
        Integer n = stringTointeger(number);
        if (n < Const.START_NUMBER || n > Const.END_NUMBER) {
            return false;
        }
        return true;
    }

    private static Integer stringTointeger(String number) {
        return Integer.parseInt(number);
    }

}
