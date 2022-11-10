package lotto.check;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumberCheck {

    private final String rangeErrMsg = "1~45사이의 숫자를 입력해 주세요.";
    private final int startNum = 1;
    private final int endNum = 45;

    public List<Integer> check(String winningNumber) {
        winningNumber = winningNumber.replace(" ", "");
        String[] split = winningNumber.split(",");
        List<String> numbers = Arrays.asList(split);
        if (!checkNumber(numbers)) {
            throw new IllegalArgumentException(rangeErrMsg);
        }
        return toIntegerList(numbers);
    }

    private List<Integer> toIntegerList(List<String> split) {
        ArrayList<Integer> winningNumber = new ArrayList<>();
        for (String s : split) {
            winningNumber.add(Integer.parseInt(s));
        }
        return winningNumber;
    }

    private boolean checkNumber(List<String> numbers) {
        for (String number : numbers) {
            if (!isRange(number)) return false;
        }
        return true;
    }

    private boolean isRange(String number) {
        Integer n = stringTointeger(number);
        if (n < startNum || n > endNum) {
            return false;
        }
        return true;
    }

    private Integer stringTointeger(String number) {
        return Integer.parseInt(number);
    }

}
