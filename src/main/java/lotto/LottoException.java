package lotto;

import java.util.Collections;
import java.util.List;

public class LottoException {
    private final String INPUT_MONEY_UNIT_ERROR = "[ERROR]: 금액은 1000원 단위로 입력해야 합니다.";
    private final String DUPLICATE_ERROR = "[ERROR]: 중복된 숫자는 입력할 수 없습니다.";
    private final String NUMBER_RANGE_ERROR = "[ERROR]: 담청 번호는 총 6자리를 입력해야 합니다.";
    private final String INPUT_BONUS_NUMBER_ERROR = "[ERROR]: 보너스 번호의 입력 범위는 1~45까지 입니다.";

    public void inputMoneyException(int inputMoney) {
        if (!isNumber(inputMoney)) {
            throw new IllegalArgumentException();
        }
    }

    public void inputMoneyUnitException(int inputMoney, int lottoPrice) {
        if (inputMoney % lottoPrice != 0) {
            System.out.println(INPUT_MONEY_UNIT_ERROR);
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumber(int inputMoney) {
        if (inputMoney < 0) {
            return false;
        }
        return true;
    }

    public void winningNumberException(String winningNumber) {
        String[] winningNumbers = winningNumber.split(",");
        for (String number : winningNumbers) {
            int count = Collections.frequency(List.of(winningNumbers), number);
            if (count > 1) {
                System.out.println(DUPLICATE_ERROR);
                throw new IllegalArgumentException();
            }
            if (winningNumbers.length != 6) {
                System.out.println(NUMBER_RANGE_ERROR);
                throw new IllegalArgumentException();
            }
        }
    }

    public boolean isDuplicate(List<Integer> numbers) {
        for (int number : numbers) {
            int count = Collections.frequency(numbers, number);
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isOverNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }

    public void bonusNumberException(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            System.out.println(INPUT_BONUS_NUMBER_ERROR);
            throw new IllegalArgumentException();
        }
    }
}
