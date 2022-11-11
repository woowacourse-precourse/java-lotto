package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private Map<Rank, Integer> lottoResult;

    private Statistics(List<Lotto> lottos, WinningLotto winningLotto) {
        lottoResult = new HashMap<>();
        initLottoResult();
    }

    private void initLottoResult() {
        for(Rank rank : Rank.values()){
            lottoResult.put(rank, 0);
        }
    }

    private void getLottosResult(List<Lotto> lottos, WinningLotto winningLotto) {
        for(Lotto lotto : lottos){

        }
    }

    private void getLottoResult(Lotto lotto, WinningLotto winningLotto){
        int matchingCnt = compareNumbers(lotto, winningLotto);
    }

    private int compareNumbers(Lotto lotto, WinningLotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }
}
