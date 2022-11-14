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
        for (int i = 0; i < inputNumber.size(); i++) {
            if (!(1 <= inputNumber.get(i) && inputNumber.get(i) <= 45)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void winNumberDuplicateValidate(List<Integer> inputNumber) throws IllegalArgumentException {
        List<Integer> checkInput = new ArrayList<>();

        for (int i = 0; i < inputNumber.size(); i++) {
            int checkNum = inputNumber.get(i);
            if (checkInput.contains(checkNum)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 입력되었습니다.");
            }
            checkInput.add(checkNum);
        }
    }

    public static void bonusNumberRangeValidate(int inputBonus) throws IllegalArgumentException {
        if (!(1 <= inputBonus && inputBonus <= 45)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
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
