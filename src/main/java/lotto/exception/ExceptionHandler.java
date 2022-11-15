package lotto.exception;

import java.util.Collections;
import java.util.List;

public class ExceptionHandler {

    public void noNumberException(String input) throws IllegalArgumentException {
        for (int index = 0; index < input.length(); index++) {
            if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
                throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다");
            }
        }
    }

    public void amountUnitException(String money) throws IllegalArgumentException {
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위입니다.");
        }
    }

    public void lottoNumberException(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public void overlapException(List<Integer> numbers) throws IllegalArgumentException {
        for (int number : numbers) {
            if (Collections.frequency(numbers, number) != 1) {
                throw new IllegalArgumentException("[ERROR] 서로 다른 수가 아닙니다.");
            }
        }
    }

    public void splitResultNoNumberException(String input) throws IllegalArgumentException {
        for (String number : input.split(",")) {
            if (number.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다");
            }
            if (!number.matches("[+-]?\\d*(\\.\\d+)?")) {
                throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다");
            }
        }
    }


}
