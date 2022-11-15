package lotto;

import lotto.domain.Computer;
import lotto.domain.Lucky;
import lotto.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현
        game();
    }

    public static void game() {
        User user = new User();
        int price = user.inputPrice();
        int count = user.countLotto(price);
        List<List<Integer>> userLotto = new ArrayList<>(user.showLotto(count));

        Computer com = new Computer();
        String str = com.inputNumbers();
        String [] arr = com.splitNumbers(str);
        List<Integer> list = new ArrayList<>(com.checkNumbers(arr));
        com.checkDuplication(list);
        int bns = com.bonusNumber();

        Lucky lucky = new Lucky();
        List<Integer> res = new ArrayList<>(lucky.compareNumbers(userLotto, list, bns));
        HashMap<Integer, Integer> map = new HashMap<>(lucky.compareResult(res));
        lucky.showResult(map);
        lucky.showProfit(lucky.profitResult(map, price));
    }
}
