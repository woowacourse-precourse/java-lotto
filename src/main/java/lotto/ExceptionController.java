package lotto;

import java.util.ArrayList;
import java.util.List;

public class ExceptionController {

    public ExceptionController() {
    }
    /**
     * judge money is constructed by digits
     * @param money served by setUserMoney
     * @return Is money variable is constructed by digits
     */
    private boolean validateMoneyIsInt(String money) {
        for(int i = 0; i < money.length(); i++) {
            if(!Character.isDigit(money.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    private boolean validateMoneyHasHundreds(int money) {
        return money % 1000 <= 0;
    }

    public void validateMoney(String money){
        if(!this.validateMoneyIsInt(money)) {
            throw new IllegalArgumentException("[ERROR] Please input Number only");
        }
        int moneyInt = Integer.parseInt(money);
        if(!this.validateMoneyHasHundreds(moneyInt)) {
            throw new IllegalArgumentException("[ERROR] Please enter in thousands");
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
        for(String str : numbers) {
            if(!this.isNumeric(str)) {
                throw new IllegalArgumentException("[ERROR] Please input Numbers only");
            }
        }

    }

    private static boolean validateHasDuplicated(List<Integer> numbers, int index) {
        for(int i = index+1; i < numbers.size(); i++) {
            if(numbers.get(index) == numbers.get(i)) {
                return false;
            }
        }
        return true;
    }
    private static boolean validateRangeError(List<Integer> integers) {
        for(int i : integers)
            if (i > 45 || i < 1) {
                return false;
            }
        return true;
    }

    public static void validateWinNumber(List<Integer> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] Please input 6 numbers only");
        }

        for(int i = 0; i < numbers.size(); i++) {

            if(!validateHasDuplicated(numbers, i)) {
                throw new IllegalArgumentException("[ERROR] Please input not duplicated numbers");
            }

        }
        if(!validateRangeError(numbers)) {
            throw new IllegalArgumentException("[ERROR] Please input 1~45 numbers");
        }


    }

    /**
     *  check bonus number is int
     * @param bonus
     * @return boolean
     */
    private boolean validateBonusIsInt(String bonus) {
        for(int i = 0; i < bonus.length(); i++) {
            if(!Character.isDigit(bonus.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * check bonus number is range 1 ~ 45
     * @param bonus
     * @return boolean
     */
    private boolean validateBonusOutOfRange(int bonus) {
        return bonus <= 45 && bonus >= 1;
    }

    /**
     * check bonus number is int, in range ( 1 ~ 45 )
     * @param bonus
     */
    public void validateBonus(String bonus) {
        if(!this.validateBonusIsInt(bonus)) {
            throw new IllegalArgumentException("[ERROR] please input only numbers");
        }
        int bonusInt = Integer.parseInt(bonus);
        if(!this.validateBonusOutOfRange(bonusInt)) {
            throw new IllegalArgumentException("[ERROR] Please input 1~45 numbers");
        }
    }

    /**
     * check bonus number is Duplicated
     * @param numbers set winning number
     * @param bonus bonus number
     */
    public static void validateDuplicateBonusWithWin(Lotto numbers, int bonus) {
        for(int i : numbers.getNumbers()) {
            if (i == bonus) {
                throw new IllegalArgumentException("[ERROR] Please input not duplicated with winning numbers");
            }
        }
    }
}
