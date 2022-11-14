package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.message.gameMessages.*;
import static lotto.message.errorMessages.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = buyLotto();
        List<List> purchaseLotto = autoLotto(purchaseAmount);
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

    public static List<List> autoLotto(int lottoAmount){
        System.out.println("\n"+lottoAmount+PURCHASE_AMOUNT);
        List<List> autoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> autoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            new Lotto(autoNumber);
            System.out.println(autoNumber);
            autoNumbers.add(autoNumber);
        }
        return autoNumbers;
    }

}
