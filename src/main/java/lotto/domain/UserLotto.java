package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class UserLotto {
    private final List<List<Integer>> userLotto = new ArrayList<>();

    public UserLotto(int amount) {
        createUserLotto(amount);
    }

    public List<Integer> createLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
    
    public void createUserLotto(int amount) {
        for (int num = 0; num < amount; num++) {
            userLotto.add(num, createLotto());
        }
    }

    public List<List<Integer>> getUserLotto() {
        return userLotto;
    }
}
