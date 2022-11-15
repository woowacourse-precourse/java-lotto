package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoService {
    ArrayList<Lotto> lottos = new ArrayList<>();
    WinningLotto winningLotto;

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


}
