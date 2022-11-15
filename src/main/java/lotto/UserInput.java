package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final String ERROR_NUMBER_MESSAGE = " 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String MONEY_AMOUNT_MESSAGE = " 로또는 1000원 단위로만 구매할 수 있습니다.";

    static String money(){
        return Console.readLine();
    }

    static void validateMoney(String coin){
        if(!coin.matches("[0-9]+")){
            throw new IllegalArgumentException(ERROR_NUMBER_MESSAGE);
        }
        if(Integer.parseInt(coin)<1000){
            throw new IllegalArgumentException(MONEY_AMOUNT_MESSAGE);
        }
        if(Integer.parseInt(coin) % 1000 != 0){
            throw new IllegalArgumentException(MONEY_AMOUNT_MESSAGE);
        }
    }

    static int coin(String money) {
        validateMoney(money);
        return Integer.parseInt(money)/1000;
    }

}
