package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private static final int FIVE_MATCHING_LOTTO_NUMBERS = 5;

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

    private Rank getLottoResult(Lotto lotto, WinningLotto winningLotto){
        int matchingCnt = compareNumbers(lotto, winningLotto);
        boolean bonusBall = false;
        if(matchingCnt == FIVE_MATCHING_LOTTO_NUMBERS){
            bonusBall = compareBonusNumber(lotto, winningLotto.getBonusBall());
        }
        return Rank.getRank(matchingCnt, bonusBall);
    }

    private boolean compareBonusNumber(Lotto lotto, int bonusBall){
        return lotto.getNumbers().contains(bonusBall);
    }

    private int compareNumbers(Lotto lotto, WinningLotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }
}
