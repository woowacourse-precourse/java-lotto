package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LottoAnalysis {

    public final List<Lotto> lottoList;

    public LottoAnalysis() {
        this.lottoList = new ArrayList<>();
    }

    public void makeLottoList(int amount) {
        for (int i = 0; i < amount; i++) {
            lottoList.add( new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            Collections.sort(lottoList.get(i).numbers);
        }
    }

    public void countWinning(int amount, List<Integer> winningNum, int bonusNum) {
        for (int i = 0; i < amount; i++) {
            lottoList.get(i).getRank(winningNum, bonusNum);
        }
    }

    public double getTotalReward() {
        double totalReward = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            totalReward += lottoRank.getReward() * lottoRank.count;
        }
        return totalReward;
    }

}
