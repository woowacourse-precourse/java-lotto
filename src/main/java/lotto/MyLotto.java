package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class MyLotto {

    private List<Lotto> myLotto;

    public MyLotto(int purchaseAmount) {
        List<Lotto> tmpMyLotto = createMyLotto(purchaseAmount);
        this.myLotto = tmpMyLotto;
    }

    public void printMyLotto() {
        for (Lotto lotto : this.myLotto) {
            System.out.println(lotto.getLotto());
        }
    }

    public List<Lotto> getMyLotto() {
        return this.myLotto;
    }

    public List<Lotto> createMyLotto(int purchaseAmount) {

        List<Lotto> tmpMyLotto = new ArrayList<>();

        for (int i = 0; i < purchaseAmount; i++) {
            tmpMyLotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return tmpMyLotto;
    }
}
