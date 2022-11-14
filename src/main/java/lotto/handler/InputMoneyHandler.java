package lotto.handler;

import lotto.service.InputMoney;

public class InputMoneyHandler {
    public final String ERROR_ORDER = "[ERROR]";
    public void checkException(String inputMoney) {
        checkIsNumber(inputMoney);
        checkIsNonzero(inputMoney);
        checkIsValidMoney(inputMoney);
    }

    public void checkIsNumber(String inputMoney) {
        boolean checkNumeric = inputMoney.matches("[+-]?\\d*(\\.\\d+)?");

        if(!checkNumeric){
            throw new IllegalArgumentException(ERROR_ORDER+" 입력 금액은 숫자여야 합니다.");
        }
    }

    public void checkIsNonzero(String inputMoney) {
        int money = Integer.parseInt(inputMoney);

        if(money == 0) {
            throw new IllegalArgumentException(ERROR_ORDER+" 입력 금액은 0이 아니어야 합니다.");
        }
    }

    public void checkIsValidMoney(String inputMoney) {
        InputMoney userLottoService = new InputMoney();
        int money = Integer.parseInt(inputMoney);

        if(money % userLottoService.LOTTO_PRICE  != 0) {
            throw new IllegalArgumentException(ERROR_ORDER+" 입력 금액은 1000단위로 나누어저야 합니다.");
        }
    }
}
