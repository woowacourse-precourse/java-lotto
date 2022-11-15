package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Application {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요\n");
        int money = 0;
        try{

            money = getMoney();
            BuyLotto buyLotto = new BuyLottoImpl(LOTTO_PRICE, money);
        GoalLotto goalLotto = new GoalLottoImpl();
        Result result = new ResultImpl(buyLotto, goalLotto, money);
        result.printResult();
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 올바른 금액을 입력하세요");
        }
    }

    private static int getMoney() {
        int money;
        try {
        money = Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        return money;
    }


}