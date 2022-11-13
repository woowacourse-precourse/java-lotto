package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyLotto {

    private List<Lotto> myLotto;
    private int totalPrize;
    private HashMap<String, Integer> eachLottoRank = new HashMap<>();

    public MyLotto(int purchaseAmount) {
        List<Lotto> tmpMyLotto = createMyLotto(purchaseAmount);
        initializeEachLottoRank();
        this.myLotto = tmpMyLotto;
    }

    public void printMyLotto() {
        for (Lotto lotto : this.myLotto) {
            System.out.println(lotto.getLotto());
        }
    }

    public void setEachLottoPrize(int rank, boolean containBonusNumber) {
        String rankName = Rank.findRank(rank, containBonusNumber).name();
        this.eachLottoRank.put(rankName, this.eachLottoRank.get(rankName)+1);
    }

    public List<Lotto> getMyLotto() {
        return this.myLotto;
    }

    public HashMap<String, Integer> getEachLottoRank() {
        return this.eachLottoRank;
    }

    public List<Lotto> createMyLotto(int purchaseAmount) {

        List<Lotto> tmpMyLotto = new ArrayList<>();

        for (int i = 0; i < purchaseAmount; i++) {
            tmpMyLotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return tmpMyLotto;
    }

    public void initializeEachLottoRank() {
        for (Rank rank : Rank.values()) {
            this.eachLottoRank.put(rank.name(), 0);
        }
    }

    public void checkEachLotto(Lotto winNumbers, BonusNumber bonusNumber) {

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

    public void calculateTotalPrize() {

        int prize;
        String lottoRank;

        for (Rank rank : Rank.values()) {
            lottoRank = rank.name();
            prize = rank.getPrize();

            this.totalPrize += (this.eachLottoRank.get(lottoRank)*prize);
        }
    }
}
