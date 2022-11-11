package lotto.validation;


public class Validator {
    public boolean isNumeric(String money) {
        try {
            Integer.parseInt(money);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isCorrectUnit(String inputMoney) {
        int money = Integer.parseInt(inputMoney);
        if (money % 1000 != 0) {
            return false;
        }
        return true;
    }
}
