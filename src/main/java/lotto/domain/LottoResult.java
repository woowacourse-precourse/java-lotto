package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LottoResult {
    private final Map<Rank, Integer> resultMap = new HashMap<>(); //생성자로 만들어버리기

    public LottoResult(UserLottos userLottos, WinningLotto winningLotto) {
        setResultMap(userLottos, winningLotto);
    }

    //당첨 로또 맵만들기 {등수(enum):개수}
    public void setResultMap(UserLottos userLottos, WinningLotto winningLotto) {
        Set<Lotto> lottoSet = userLottos.getUserLottos();

        for (Lotto eachLotto : lottoSet) {
            Rank rank = winningLotto.getRankof(eachLotto);
            addToResultMap(rank);
        }
    }

    //당첨 기준별 로또 개수 세기 기능.
    public void addToResultMap(Rank rank) {
        if(rank == null) {
            return;
        }

        int winningCount = resultMap.getOrDefault(rank, 0);
        resultMap.put(rank, winningCount + 1);
    }
}
