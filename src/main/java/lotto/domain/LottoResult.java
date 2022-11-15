package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LottoResult {
    private final double money;
    private final double yield;
    private final Map<Rank, Integer> resultMap;

    public LottoResult(UserLottos userLottos, WinningLotto winningLotto) {
        money = userLottos.getUserLottosMoney();
        resultMap = setResultMap(userLottos, winningLotto);
        yield = calculateYield(money);
    }

    //당첨 로또 맵만들기 {등수(enum):개수}
    public Map<Rank, Integer> setResultMap(UserLottos userLottos, WinningLotto winningLotto) {
        Map<Rank, Integer> resultMap = new HashMap<>();
        Set<Lotto> lottoSet = userLottos.getUserLottos();

        for (Lotto eachLotto : lottoSet) {
            Rank rank = winningLotto.getRankof(eachLotto);
            addToResultMap(rank, resultMap);
        }
        return resultMap;
    }

    //당첨 기준별 로또 개수 세기 기능
    public void addToResultMap(Rank rank, Map<Rank, Integer> resultMap) {
        if (rank == null) {
            return;
        }

        int winningCount = resultMap.getOrDefault(rank, 0);
        resultMap.put(rank, winningCount + 1);
    }

    //수익률 계산하기
    public double calculateYield(double money) {
        long totalPrize = 0;
        for (Rank rank : Rank.values()) {
            int count = resultMap.getOrDefault(rank, 0);
            long prize = rank.getPrize();
            totalPrize += count * prize;
        }

        return Math.round((totalPrize / money) * 1000) / 10.0;
    }

    //getter 모음
    public Map<Rank, Integer> getResultMap() {
        return this.resultMap;
    }

    public double getYield() {
        return this.yield;
    }

    //서비스로직 - 문자열로 형변환
    public String getResultString() {
        StringBuffer sb = new StringBuffer();

        for (Rank rank : Rank.values()) {
            int count = resultMap.getOrDefault(rank, 0);
            sb.append(String.format(rank.getSentence() + "\n", count));
        }

        return sb.toString().trim();
    }

}
