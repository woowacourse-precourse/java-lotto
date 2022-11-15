package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요");
        String moneyString = Console.readLine();
        int money = getMoney(moneyString);
        BuyLotto buyLotto = new BuyLottoImpl(LOTTO_PRICE,money);
        GoalLotto goalLotto = new GoalLottoImpl();
        Result result = new ResultImpl(buyLotto,goalLotto,money);
        result.printResult();
    }

    private static int getMoney(String moneyString) {
        int money = 0;
        try {
            money = Integer.parseInt(moneyString);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 입력된 금액이 올바르지 않습니다!");
        }
        return money;
    }
}
