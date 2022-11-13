package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyLotto {

    private List<Lotto> myLotto;
    private int totalPrize;
    private HashMap<Integer, Integer> eachLottoPrize;

    public MyLotto(int purchaseAmount) {
        List<Lotto> tmpMyLotto = createMyLotto(purchaseAmount);
        this.myLotto = tmpMyLotto;
    }

    public void printMyLotto() {
        for (Lotto lotto : this.myLotto) {
            System.out.println(lotto.getLotto());
        }
    }

    public void setEachLottoPrize(int rank) {
        this.eachLottoPrize.put(rank, this.eachLottoPrize.get(rank)+1);
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

    public void checkEachLotto(Lotto winNumbers, BonusNumber bonusNumber) {
        for (Lotto lotto : myLotto) {
            System.out.println(lotto.getLotto());
            int correctNumbers = lotto.compareWithWinNumber(winNumbers);
            System.out.println(correctNumbers);
            if (correctNumbers >= 3) {
                setEachLottoPrize(correctNumbers);
            }
        }
    }
}
