package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {
    public static void isNumberOrNot(String input) {
        boolean isNumber = Pattern.matches("^[0-9]*$", input);
        if (!isNumber) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public static void isMultiplesOfThousand(String input) {
        int inputNumber = Integer.parseInt(input);
        if (inputNumber % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000의 배수만 입력 가능합니다.");
        }
    }

    public static void isFilledString(String input) {
        if (Objects.equals(input, "")) {
            throw new IllegalArgumentException("[ERROR] 구매하실 금액을 입력해주세요.");
        }
    }

    public static void isZero(String input) {
        if (Objects.equals(input, "0")) {
            throw new IllegalArgumentException("[ERROR] 하나 이상의 복권을 구매해야 합니다.");
        }
    }

    public static void isInRange(String input) {
        int inputNumber = Integer.parseInt(input);
        if (1 > inputNumber || inputNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1과 45 사이의 정수만 입력 가능합니다.");
        }
    }

    public static void containDuplicate(List<Integer> inputs) {
        Set<Integer> inputSet = new HashSet<>(inputs);
        if (inputSet.size() != inputs.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 값만 입력 가능합니다.");
        }
    }

    public static void listLengthCheck(List<Integer> inputs, int length) {
        if(inputs.size() != length) {
            throw new IllegalArgumentException("[ERROR] 6개의 번호를 입력해주세요.");
        }
    }
}
