package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Validator {
    public static void validateLottoPrice(int inputNumber) {
        isMultiplesOfThousand(inputNumber);
        isZero(inputNumber);
    }

    public static void isMultiplesOfThousand(int inputNumber) {
        if (inputNumber % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000의 배수만 입력 가능합니다.");
        }
    }

    public static void isZero(int input) {
        if (input == 0) {
            throw new IllegalArgumentException("[ERROR] 하나 이상의 복권을 구매해야 합니다.");
        }
    }

    public static void isInRange(int input) {
        if (1 > input || input > 45) {
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
