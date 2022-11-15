package lotto.service;

import lotto.Prize;
import lotto.domain.Lotto;

import java.util.*;

public class ResultPrize {

    private final CompareNumber compareNumber = new CompareNumber();
    HashMap<Integer, Integer> sameMap = new HashMap<>();    // index, amount
    HashMap<Integer, Boolean> bonusMap = new HashMap<>();   //

    public void setHashMap() {
        sameMap.put(3, 0);
        sameMap.put(4, 0);
        sameMap.put(5, 0);
        sameMap.put(6, 0);
        bonusMap.put(3, false);
        bonusMap.put(4, false);
        bonusMap.put(5, false);
        bonusMap.put(6, false);
    }

    public ResultPrize(List<Lotto> lottoList, List<Integer> winningNumber, int bonusNumber) {
        setHashMap();
        for (Lotto lotto : lottoList) {
            int count;
            if ((count = compareNumber.CompareLotto(lotto.getNumbers(), winningNumber))>2)
                sameMap.put(count, sameMap.get(count)+1);
            if ((compareNumber.CompareBonuseLotto(bonusNumber, lotto.getNumbers()))&&(count>2))
                bonusMap.put(count, true);
        }
    }

    public HashMap<String, Integer> CalResult() {
        Set<Integer> keySet = sameMap.keySet();
        HashMap<String, Integer> prizeMap = new HashMap<>();
        for (int key : keySet) {
            prizeMap.put(Prize.valueOf(key, bonusMap.get(key)), sameMap.get(key));
        }
        prizeMap.put("1", 0);
        if ((Prize.valueOf(5, bonusMap.get(5)))=="1")
            prizeMap.put("1", 1);
        prizeMap = SortMap(prizeMap);
        return prizeMap;
    }

    private HashMap<String, Integer> SortMap(HashMap<String, Integer> prizeMap){
        List<String> keySet = new ArrayList<>(prizeMap.keySet());
        keySet.sort(Collections.reverseOrder());
        System.out.println(prizeMap);
        return prizeMap;
    }

}
