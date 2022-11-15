package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoService {
    private ArrayList<Lotto> lottos = new ArrayList<>();
    private WinningLotto winningLotto;

    public ArrayList<Lotto> getLottos() {
        return lottos;
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }

    public void makeRandomLottos(int number) {
        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
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
    public Float calculateEarningRate(List<Integer> allRankings, Integer buyingLottoNumber){
        Float allPrizes = 0f;
        allPrizes += allRankings.get(1)*2_000_000_000;
        allPrizes += allRankings.get(2)*30_000_000;
        allPrizes += allRankings.get(3)*1_500_000;
        allPrizes += allRankings.get(4)*50_000;
        allPrizes += allRankings.get(5)*5_000;
        Float buyingMoney = Float.valueOf(buyingLottoNumber*1000);
        return allPrizes*100/buyingMoney;
    }


}
