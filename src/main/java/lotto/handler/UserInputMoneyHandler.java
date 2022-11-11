package lotto.handler;

import lotto.view.OutputView;

public class UserInputMoneyHandler {
    private final String ERROR_ORDER = "[ERROR]";
    public void checkException(String inputMoney) {
        checkIsNumber(inputMoney);
        checkIsNonzero(inputMoney);
        checkIsValidMoney(inputMoney);
    }
    public void checkIsNumber(String inputMoney){
        boolean checkNumeric = inputMoney.matches("[+-]?\\d*(\\.\\d+)?");
        if(!checkNumeric){
            throw new IllegalArgumentException(ERROR_ORDER);
        }
    }
    public void checkIsNonzero(String inputMoney){
        int money = Integer.parseInt(inputMoney);
        if(money == 0) {
            throw new IllegalArgumentException(ERROR_ORDER);
        }
    }
    public void checkIsValidMoney(String inputMoney){
        int money = Integer.parseInt(inputMoney);
        if(money%1000  != 0) {
            throw new IllegalArgumentException(ERROR_ORDER);
        }
    }
}
