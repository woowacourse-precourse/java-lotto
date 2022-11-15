package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Lotto> buyLottery(int money) {
        List<Lotto> all_lottery = new ArrayList<>();
        int lottery_cnt = money / 1000;

        for (int i = 0; i < lottery_cnt; i++) {
            Lotto lottery = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            all_lottery.add(lottery);
        }
        return all_lottery;
    }

}
