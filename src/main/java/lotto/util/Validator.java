package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    private static final String INVALID_NUMBER = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String INVALID_MONEY = "[ERROR] 1000원 단위로 입력이 가능합니다.";
    private static final int MONEY_UNIT = 1000;
    private static final int NOTHING_CHANGES = 0;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;


    public int moneyInputValidator(String money) {
        int moneyNumber = changeNumber(money);
        checkChanges(moneyNumber);
        return moneyNumber;
    }

    public static int changeNumber(String money) {
        try {
            return Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }

    public void checkChanges(int money) {
        if (money % MONEY_UNIT == NOTHING_CHANGES) {
            return;
        }
        throw new IllegalArgumentException(INVALID_MONEY);
    }

    public List<Integer> winningNumberInputValidator(String money) {
        try {
            List<Integer> winningNumbers = Arrays.stream(money.split(","))
                    .map(Validator::changeNumber)
                    .filter((n) -> checkValidNumber(n))
                    .collect(Collectors.toList());
            checkLength(winningNumbers);
            checkDuplication(winningNumbers);
            return winningNumbers;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void checkLength(List list) {
        if (list.size() > LOTTO_LENGTH || list.size() < LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkValidNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private static void checkDuplication(List<Integer> numbers) {
        List<Integer> check = numbers.stream().distinct().collect(Collectors.toList());
        if (numbers.size() == check.size()) {
            return;
        }
        throw new IllegalArgumentException();
    }

}
