package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserLotto {
    private final Map<Integer,List<Integer>> userLotto = new HashMap<>();
    
    //예외사항(입력단위가 1000원이 아니면)
    private int getLottoAmount(int money) {
        int amount = money/1000;

        return amount;
    }
    
    private List<Integer> createLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return lottoNumbers;
    }
    
    private void createUserLotto(int amount) {
        for (int key = 0; key < amount; key++) {
            userLotto.put(key, createLotto());
        }
    }
}
