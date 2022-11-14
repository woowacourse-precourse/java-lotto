package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LottoResult {
    private Map<Rank, Integer> resultMap = new HashMap<>(); //생성자로 만들어버리기
    private double yield;

    public LottoResult(double money, UserLottos userLottos, WinningLotto winningLotto) {
        setResultMap(userLottos, winningLotto);
        calculateYield(money);
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

    //수익률 계산하기
    public void calculateYield(double money) {
        int totalPrize = 0;
        for(Rank rank : Rank.values()) {
            int count = resultMap.getOrDefault(rank,0);
            long prize = rank.getPrize();
            totalPrize += count*prize;
        }

        yield = Math.round(totalPrize/money*1000)/10.0;
    }

    public Map<Rank, Integer> getResultMap() {
        return this.resultMap;
    }

    public double getYield() {
        return this.yield;
    }

    //서비스로직 - 문자열로 형변환
    public String getResultString() {
        StringBuffer sb = new StringBuffer();

        for(Rank rank : Rank.values()) {
            int count = resultMap.getOrDefault(rank, 0);
            sb.append(String.format(rank.getSentence()+"\n",count));
        }

        return sb.toString().trim();
    }

}
