package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class UserLotto {
    private final List<List<Integer>> userLotto = new ArrayList<>();

    public UserLotto(int amount) {
        createUserLotto(amount);
    }

    //예외사항(입력단위가 1000원이 아니면)
    public int getLottoAmount(int money) {
        int amount = money/1000;

        return amount;
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
