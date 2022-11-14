package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {

    private List<List<Integer>> userAllLotto = new ArrayList<>();
    private final int lottoCount;

    public LottoNumber(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public void createLottoNumber() {
        List<Integer> myLotto = Randoms.pickUniqueNumbersInRange(1,45,6);
        userAllLotto.add(myLotto);
    }

    public void createCountOfLotto() {
        for (int count = 0; count < lottoCount; count++) {
            createLottoNumber();
        }
    }

    public List<List<Integer>> getUserAllLotto() {
        return userAllLotto;
    }

    public void printUserAllLotto() {
        for (List<Integer> lotto: userAllLotto) {
            System.out.println(lotto);
        }
    }
}
