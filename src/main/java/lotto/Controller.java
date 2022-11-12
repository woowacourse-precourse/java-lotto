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
        int count = money / MONEY_UNIT;
        Set<Lotto> lottoSet = new HashSet<>();

        while (lottoSet.size() == count) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoSet.add(lotto);
        }

        return lottoSet;
    }


    // 당첨된 로또 개수 맵 만들기 {등수:개수}
    public Map<String, Integer> createResultMap(Set<Lotto> lottoSet, List<Integer> winningLotto, int bonusNumber) {
        Map<String, Integer> resultMap = new HashMap<>();

        for (Lotto eachLotto : lottoSet) {
            eachLotto.setRank(winningLotto, bonusNumber);
            String rank = eachLotto.getRank();
            addToResultMap(resultMap, rank);
        }
        return resultMap;
    }

    //당첨 기준별 로또 개수 세기 기능.
    public void addToResultMap(Map<String, Integer> resultMap, String rank) {
        //putIfAbsent나 다른 것 사용해보기
        int winningCount = resultMap.getOrDefault(rank, 0);
        resultMap.put(rank, winningCount + 1);
    }

    //수익률 계산하기
    private final List<String> ranks = List.of("FITFH","FOURTH","THIRD","SECOND","FIRST");
    public double calculateYield(double money, Map<String, Integer> resultMap) {
        int totalPrize = 0;
        for(String rank : ranks) {
            int count = resultMap.getOrDefault(rank,0);
            int prize = Rank.valueOf(rank).getPrize();
            totalPrize += count*prize;
        }
        return Math.round(totalPrize/money*1000)/10.0;
    }

    //당첨 내역 출력하기
    public void printResult(int money, Map<String, Integer> resultMap) {
        for(int i = ranks.size()-1 ; i > 0 ; i--) {
            String rank = ranks.get(i);
            int count = resultMap.getOrDefault(rank, 0);
            System.out.println(Rank.valueOf(rank).toString()+count+"개");
        }
    }

}
