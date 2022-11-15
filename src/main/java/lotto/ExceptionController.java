package lotto;

import java.util.List;

public class ExceptionController {
    public ExceptionController() {
    }

    private boolean validateMoneyIsInt(String money) {
        for (int i = 0; i < money.length(); i++) {
            if (!Character.isDigit(money.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    private boolean validateMoneyHasHundreds(int money) {
        return money % 1000 <= 0;
    }
    public void validateMoney(String money) {
        if (!this.validateMoneyIsInt(money)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요");
        }
        int moneyInt = Integer.parseInt(money);
        if (!this.validateMoneyHasHundreds(moneyInt)) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요");
        }
    }
    private boolean isNumeric(String number) {
        if (number == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    public void validateWinNumIsInt(List<String> numbers) {
        for (String str : numbers) {
            if (!this.isNumeric(str)) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요");
            }
        }
    }
    private static boolean validateHasDuplicated(List<Integer> numbers, int index) {
        for (int i = index + 1; i < numbers.size(); i++) {
            if (numbers.get(index) == numbers.get(i)) {
                return false;
            }
        }
        return true;
    }
    private static boolean validateRangeError(List<Integer> integers) {
        for (int i : integers) {
            if (i > 45 || i < 1) {
                return false;
            }
        }
        return true;
    }
    public static void validateWinNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요");
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (!validateHasDuplicated(numbers, i)) {
                throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자들을 넣어주세요");
            }
        }
        if (!validateRangeError(numbers)) {
            throw new IllegalArgumentException("[ERROR] 1~45의 숫자를 넣어주세요");
        }
    }
    private boolean validateBonusIsInt(String bonus) {
        for (int i = 0; i < bonus.length(); i++) {
            if (!Character.isDigit(bonus.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean validateBonusOutOfRange(int bonus) {
        return bonus <= 45 && bonus >= 1;
    }

    public void validateBonus(String bonus) {
        if (!this.validateBonusIsInt(bonus)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요");
        }
        int bonusInt = Integer.parseInt(bonus);
        if (!this.validateBonusOutOfRange(bonusInt)) {
            throw new IllegalArgumentException("[ERROR] 1~45의 숫자만 입력해주세요");
        }
    }
    public static void validateDuplicateBonusWithWin(Lotto numbers, int bonus) {
        for (int i : numbers.getNumbers()) {
            if (i == bonus) {
                throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자를 당첨번호로 입력해주세요");
            }
        }
    }
}
