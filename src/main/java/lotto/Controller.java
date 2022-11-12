package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Controller {
    private final int MONEY_UNIT = 1000;

    public void generate() {
        //1. 금액에 해당하는 로또 생성
        //2. 당첨번호, 보너스 번호 입력
        //3. 당첨된 로또 개수 맵 만들기 {등수:개수}
        //4.
    }

    public Set<Lotto> createLottos(int money) {
        int count = money/MONEY_UNIT;
        Set<Lotto> lottoSet = new HashSet<>();

        while(lottoSet.size() == count) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
            lottoSet.add(lotto);
        }

        return lottoSet;
    }


    // 당첨된 로또 개수 맵 만들기 {등수:개수}
    public void createResultMap(Set<Lotto> lottoSet, List<Integer> winningLotto, int bonusNumber) {
        Map<String, Integer> resultMap = new HashMap<>();

        for(Lotto eachLotto : lottoSet){
            eachLotto.setRank(winningLotto, bonusNumber);
            String rank = eachLotto.getRank();
        }

    }

    //당첨 기준별 로또 개수 세기 기능.
    public void addToResultMap(Map<Integer, Integer> statistics, int matchCount) {
        //putIfAbsent나 다른 것 사용해보기
        int winningCount = statistics.getOrDefault(matchCount, 0);
        statistics.put(matchCount, winningCount);
    }

}
