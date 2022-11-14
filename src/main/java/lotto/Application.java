package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.message.gameMessages.*;
import static lotto.message.errorMessages.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        buyLotto();
    }

    public static int buyLotto(){
        System.out.println(AMOUNT_MONEY_INPUT);
        String moneyInput = Console.readLine();
        int buyAmount = 0;
        checkPurchaseException(moneyInput);
        buyAmount = Integer.parseInt(moneyInput)/1000;
        return buyAmount;
    }
    private static void checkPurchaseException(String moneyInput){
        int money = 0;
        try{
            money = Integer.parseInt(moneyInput);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(USER_INPUT_ERROR);
        }
        if(money%1000!=0){
            throw new IllegalArgumentException(USER_INPUT_ERROR);
        }
    }

}
