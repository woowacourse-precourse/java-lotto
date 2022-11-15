package lotto.validator;

import java.util.ArrayList;
import java.util.List;

public class UserInputValidator {
    public static void moneyUnitValidate(int money) throws IllegalArgumentException {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액만 입력해야 합니다.");
        }
    }

    public static void winNumberCountValidate(List<Integer> inputNumber) throws IllegalArgumentException {
        if (inputNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6자리만 입력해야 합니다.");
        }
    }

    public static void winNumberRangeValidate(List<Integer> inputNumber) throws IllegalArgumentException {
        for (Integer num : inputNumber) {
            if (!(1 <= num && num <= 45)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void winNumberDuplicateValidate(List<Integer> inputNumber) throws IllegalArgumentException {
        List<Integer> checkInput = new ArrayList<>();

        for (Integer num : inputNumber) {
            if (checkInput.contains(num)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 입력되었습니다.");
            }
            checkInput.add(num);
        }
    }

    public static void bonusNumberRangeValidate(int inputBonus) throws IllegalArgumentException {
        if (!(1 <= inputBonus && inputBonus <= 45)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void bonusNumberInWinNumber(int inputBonus, List<Integer> inputNumber) throws IllegalArgumentException {
        if (inputNumber.contains(inputBonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복되면 안됩니다..");
        }
    }

    public static void isNumValidate(String input) throws IllegalArgumentException {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("[ERROR] 숫자인 값만 입력해야 합니다.");
            }
        }
    }
}
