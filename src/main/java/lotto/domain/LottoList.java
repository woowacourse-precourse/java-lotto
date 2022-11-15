package lotto.domain;

import lotto.view.ConsoleOutput;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    List<Lotto> lottoList = new ArrayList<>();

    public void addLottoList(Lotto lotto) {
        this.lottoList.add(lotto);
    }

    public List<LottoRank> lottoResult(WinningLotto winningLotto) {
        List<LottoRank> results = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            int matchCount = winningLotto.getWinningLottoNumber().checkSameCount(lotto);
            boolean isBonus = lotto.contain(winningLotto.getBonusNumber());
            results.add(LottoRank.checkRanking(matchCount, isBonus));
        }
        return results;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Lotto lotto : lottoList) {
            str.append(lotto.toString());
        }
        return str.toString();
    }
}
