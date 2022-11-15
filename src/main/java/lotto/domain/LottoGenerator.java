package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.message.GameMessage;

import java.util.HashMap;
import java.util.List;

import static java.util.Collections.sort;

public class LottoGenerator {
    List<Integer> userNumbers;
    HashMap<Integer, List<Integer>> userLotto = new HashMap<>();
    int count;

    public LottoGenerator(int money) {
        this.count = money / 1000;
    }

    public HashMap<Integer, List<Integer>> userLottoNumbers() {
        System.out.print(count);
        System.out.println(GameMessage.Purchase_Count);

        for(int i = 0; i < count; i++) {
            userNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            sort(userNumbers);

            System.out.println(userNumbers);

            userLotto.put(i, userNumbers);
        }

        return userLotto;
    }
}
