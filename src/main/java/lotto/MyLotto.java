package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyLotto {

    private final List<Lotto> myLotto;
    private final HashMap<String, Integer> eachLottoRank = new HashMap<>();
    private double profit = 0;

    public MyLotto(Purchase purchase) {
        int purchaseAmount = purchase.getLottoNumber();
        List<Lotto> tmpMyLotto = createMyLotto(purchaseAmount);
        initializeEachLottoRank();
        this.myLotto = tmpMyLotto;
    }

    public void setEachLottoPrize(int rank, boolean containBonusNumber) {
        String rankName = Rank.findRank(rank, containBonusNumber).name();
        this.eachLottoRank.put(rankName, this.eachLottoRank.get(rankName) + 1);
    }

    public List<Lotto> getMyLotto() {
        return this.myLotto;
    }

    public HashMap<String, Integer> getEachLottoRank() {
        return this.eachLottoRank;
    }

    public double getProfit() {
        return this.profit;
    }

    public List<Lotto> createMyLotto(int purchaseAmount) {

        List<Lotto> tmpMyLotto = new ArrayList<>();

        for (int i = 0; i < purchaseAmount; i++) {
            try {
                tmpMyLotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            } catch (Exception e) {
            }
        }

        return tmpMyLotto;
    }

    public void initializeEachLottoRank() {
        for (Rank rank : Rank.values()) {
            this.eachLottoRank.put(rank.name(), 0);
        }
    }

    public void checkEachLotto(WinNumber winNumbers, BonusNumber bonusNumber) {

        for (Lotto lotto : myLotto) {

            int correctNumbers = lotto.compareWithWinNumber(winNumbers);

            if (correctNumbers == 3 || correctNumbers == 4 || correctNumbers == 6) {
                setEachLottoPrize(correctNumbers, false);
            }
            if (correctNumbers == 5) {
                setEachLottoPrize(correctNumbers, lotto.compareWithBonusNumber(bonusNumber));
            }
        }
    }

    public void calculateProfit() {

        int purchaseAmount = this.myLotto.size() * 1000;

        for (Rank rank : Rank.values()) {
            this.profit = this.profit + (this.eachLottoRank.get(rank.name()) * rank.getPrize());
        }

        this.profit = (this.profit / purchaseAmount * 100);
    }
}
