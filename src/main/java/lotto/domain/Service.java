package lotto.domain;

import static java.util.Collections.sort;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.Validator;
import lotto.view.Input;

public class Service {

    public static Integer inputMoney() {
        String payMoney = Input.input();
        Validator.validatePayMoney(payMoney);
        return Check.countBuyLotto(payMoney);
    }

    public static List<List<Integer>> makeLottoByRandomNumbers (int countPurchasing) {
        List<List<Integer>> purchasedLotteries = new ArrayList<>();

        for(int i = 0; i<countPurchasing; i++) {
            List<Integer> individualLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(individualLotto);
            purchasedLotteries.add(individualLotto);
        }
        return purchasedLotteries;
    }
}
