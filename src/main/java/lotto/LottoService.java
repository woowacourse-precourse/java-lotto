package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoService {
    private final ArrayList<Lotto> lottos = new ArrayList<>();
    private WinningLotto winningLotto;

    public void makeRandomLottos(int number) {
        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public void setWinningLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public List<Integer> caculateAllRankings() {
        Integer[] allRankings = {0, 0, 0, 0, 0, 0};
        for (Lotto lotto : this.lottos) {
            int ranking = lotto.calculateMatchNumber(this.winningLotto).calculateRanking();
            allRankings[ranking]++;
        }
        return new ArrayList<>(Arrays.asList(allRankings));
    }

    public Float calculateEarningRate(List<Integer> allRankings, Integer buyingLottoNumber) {
        float allPrizes = 0f;
        allPrizes += allRankings.get(1) * MoneyConstant.FIRST_PRIZE.getValue();
        allPrizes += allRankings.get(2) * MoneyConstant.SECOND_PRIZE.getValue();
        allPrizes += allRankings.get(3) * MoneyConstant.THIRD_PRIZE.getValue();
        allPrizes += allRankings.get(4) * MoneyConstant.FOURTH_PRIZE.getValue();
        allPrizes += allRankings.get(5) * MoneyConstant.FIFTH_PRIZE.getValue();
        float buyingMoney = (float) (buyingLottoNumber * MoneyConstant.LOTTO_PRICE.getValue());
        return allPrizes / buyingMoney * 100;
    }
    public List<String> makeLottosString(){
        List<String> ret = new ArrayList<>();
        for(Lotto lotto : this.lottos){
            ret.add(lotto.toString());
        }
        return ret;
    }

}
