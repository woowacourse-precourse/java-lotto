package lotto.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExceptionHandler {

    public void emptyException(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
    }

    public void noNumberException(String input) throws IllegalArgumentException {
        for (int index = 0; index < input.length(); index++) {
            if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
                throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다.");
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
                throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다.");
            }
            if (!number.matches("[+-]?\\d*(\\.\\d+)?")) {
                throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다.");
            }
        }
    }

    public void numberRangeException(int number) throws IllegalArgumentException {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 범위가 아닙니다.");
        }
    }

    public void getLottoBuyAmountException(String input) throws IllegalArgumentException {
        emptyException(input);
        noNumberException(input);
        amountUnitException(input);
    }

    public void createLottoNumberException(List<Integer> numbers) throws IllegalArgumentException {
        lottoNumberException(numbers);
        overlapException(numbers);
    }

    public void getLottoWinnerNumberException(String input) throws IllegalArgumentException {
        emptyException(input);
        splitResultNoNumberException(input);
        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split(",")) {
            numbers.add(Integer.valueOf(number));
        }
        lottoNumberException(numbers);
        for (int number : numbers) {
            numberRangeException(number);
        }
        overlapException(numbers);
    }

    public void getLottoBonusNumberException(String input) throws IllegalArgumentException {
        emptyException(input);
        noNumberException(input);
        numberRangeException(Integer.parseInt(input));
    }

}
