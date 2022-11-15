package lotto.handler;

import lotto.service.InputMoney;
import lotto.view.Output;

public class InputMoneyHandler {
    Output output = new Output();

    public void checkException(String inputMoney) {
        checkExist(inputMoney);
        checkIsNumber(inputMoney);
        checkPositiveNumber(inputMoney);
        checkIsValidMoney(inputMoney);
    }

    private void checkExist (String inputMoney) {
        if(inputMoney.length() == 0){
            throw new IllegalArgumentException(output.ERROR_ORDER+" 숫자를 입력하여야 합니다.");
        }
    }

    public void checkIsNumber(String inputMoney) {
        boolean checkNumeric = inputMoney.matches("[+-]?\\d*(\\.\\d+)?");

        if(!checkNumeric){
            throw new IllegalArgumentException(output.ERROR_ORDER+" 입력 금액은 숫자여야 합니다.");
        }
    }

    public void checkPositiveNumber(String inputMoney) {
        int money = Integer.parseInt(inputMoney);

        if(money <= 0) {
            throw new IllegalArgumentException(output.ERROR_ORDER+" 입력 금액은 0원 보다 크게 입력해야 합니다.");
        }
    }

    public void checkIsValidMoney(String inputMoney) {
        InputMoney userLottoService = new InputMoney();

        int money = Integer.parseInt(inputMoney);

        if(money % userLottoService.LOTTO_PRICE  != 0) {
            throw new IllegalArgumentException(output.ERROR_ORDER+" 입력 금액은 1000단위로 나누어져야 합니다.");
        }
    }
}
