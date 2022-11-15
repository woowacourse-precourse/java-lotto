package lotto.handler;

import lotto.service.InputMoney;
import lotto.view.Output;

public class InputMoneyHandler {
    Output output = new Output();

    public void checkException(String inputMoney) {
        checkIsNumber(inputMoney);
        checkPositiveNumber(inputMoney);
        checkIsValidMoney(inputMoney);
    }

    public void checkExist (String inputMoney) {
        if(inputMoney.length() == 0){
            throw new IllegalArgumentException(output.ERROR_ORDER+" 숫자를 입력하여야 합니다.");
        }
    }

    public void checkIsNumber(String inputMoney) {
        boolean checkNumeric = inputMoney.matches("[+-]?\\d*(\\.\\d+)?");
        String[] checkInputMoney = inputMoney.split("");

        if(!checkNumeric){
            throw new IllegalArgumentException(output.ERROR_ORDER+" 입력 금액은 숫자여야 합니다.");
        }

        if(checkInputMoney.length > 1 && inputMoney.charAt(0) == '0'){
            throw new IllegalArgumentException(output.ERROR_ORDER+" 입력 금액의 맨 앞에 0이 들어갈 수 없습니다.");
        }
    }

    public void checkPositiveNumber(String inputMoney) {
        long money = Long.parseLong(inputMoney);

        if(money <= 0){
            throw new IllegalArgumentException(output.ERROR_ORDER+" 입력 금액은 0원 보다 크게 입력해야 합니다.");
        }
        if(money > Integer.MAX_VALUE){
            throw new IllegalArgumentException(output.ERROR_ORDER+" 입력 금액이 입력해야 할 범위를 벗어났습니다.");
        }
    }

    public void checkIsValidMoney(String inputMoney) {
        InputMoney userLottoService = new InputMoney();

        int money = Integer.parseInt(inputMoney);

        if(money % userLottoService.LOTTO_PRICE  != 0){
            throw new IllegalArgumentException(output.ERROR_ORDER+" 입력 금액은 1000단위로 나누어져야 합니다.");
        }
    }
}