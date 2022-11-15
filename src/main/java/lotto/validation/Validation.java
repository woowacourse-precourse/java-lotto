package lotto.validation;

import java.util.List;

public class Validation {

    public boolean isValidMoney(String input) {
        try {
            validateMoneyInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void validateMoneyInput(String input) {
        validateStringIsNumeric(input);
        validateDivideThousand(Integer.parseInt(input));
    }

    public void validateWinNumberInput(String input) {
        String[] token = input.split(",");
        if (token.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요");
        }

        for (String s : token) {
            validateStringIsNumeric(s);
        }

        for (String s : token) {
            int num = Integer.parseInt(s);
            validateNumberInBound(1, 45, num);
        }
    }

    public void validateBonusNumberInput(List<Integer> winNumbers, String bonusNumber) {
        validateStringIsNumeric(bonusNumber);
        int bonus = Integer.parseInt(bonusNumber);
        checkBonusNumberAlreadyPicked(winNumbers, bonus);
        validateNumberInBound(1, 45, bonus);
    }

    private void checkBonusNumberAlreadyPicked(List<Integer> winNumbers, int bonus) {
        if (winNumbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호에 이미 보너스 번호가 있습니다.");
        }
    }


    private void validateStringIsNumeric(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자여야 합니다.");
        }
    }

    private void validateNumberInBound(int min, int max, int input) {
        if (input < min) {
            throw new IllegalArgumentException("[ERROR]" + min + "이상의 수를 입력해야 합니다.");
        }
        if (input > max) {
            throw new IllegalArgumentException("[ERROR] " + max + " 이하의 수를 입력해야 합니다.");
        }
    }

    private void validateDivideThousand(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 1,000 이상의 금액을 입력해야 합니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액을 1,000으로 나눌 수 있어야 합니다.");
        }
    }
}
