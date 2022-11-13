package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Validator {
    public static void isMultiplesOfThousand(int inputNumber) {
        if (inputNumber % LottoInfo.PRICE.getNumber() != 0) {
            String message = String.format("[ERROR] %d의 배수만 입력 가능합니다.", LottoInfo.PRICE.getNumber());
            throw new IllegalArgumentException(message);
        }
    }

    public static void isUnderZero(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("[ERROR] 0 보다 큰 숫자를 입력해주세요.");
        }
    }

    public static void isInRange(int input) {
        if (LottoInfo.START_NUMBER.getNumber() > input
                || input > LottoInfo.END_NUMBER.getNumber()) {
            String message = String.format("[ERROR] %d과 %d 사이의 정수만 입력 가능합니다.",
                    LottoInfo.START_NUMBER.getNumber(), LottoInfo.END_NUMBER.getNumber());
            throw new IllegalArgumentException(message);
        }
    }

    public static void containDuplicate(List<Integer> inputs) {
        Set<Integer> inputSet = new HashSet<>(inputs);
        if (inputSet.size() != inputs.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 값만 입력 가능합니다.");
        }
    }

    public static void listLengthCheck(List<Integer> inputs, int length) {
        if (inputs.size() != length) {
            String message = String.format("[ERROR] %d개의 번호를 입력해주세요.", length);
            throw new IllegalArgumentException(message);
        }
    }
}
