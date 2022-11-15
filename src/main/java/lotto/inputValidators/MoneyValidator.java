package lotto.inputValidators;

public class MoneyValidator {
    static public boolean isValidMoneyInput(String inputMoney) {
        if (NumberValidator.includeNotNumericCharacter(inputMoney)) {
            return false;
        }

        int userMoney = Integer.parseInt(inputMoney);
        if (!isMultipleOfOneThousand(userMoney)) {
            return false;
        }
        return true;
    }

    static private boolean isMultipleOfOneThousand(int userMoney) {
        if (userMoney % 1000 == 0) {
            return true;
        }
        return false;
    }

}
