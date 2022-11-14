package lotto.domain;

import static lotto.domain.Check.countBuyLotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.util.Validator;

public class Service {

    public static Integer inputMoney(String payMoney) {
        Validator.validatePayMoney(payMoney);
        return countBuyLotto(payMoney);
    }

    public static List<List<Integer>> makeLottoByRandomNumbers (int countPurchasing) {
        List<List<Integer>> purchaseLottos = new ArrayList<>();
        for(int i = 0; i<countPurchasing; i++) {
            purchaseLottos.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return purchaseLottos;
    }

}
