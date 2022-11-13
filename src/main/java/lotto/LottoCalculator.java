package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoCalculator {
    public List<List<Integer>> checkLuckyNumbers(List<Lotto> lottoList, List<List<Integer>> userLottoList) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<List<Integer>> total = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            int count = 0;
            int count2 = 0;
            for (int i = 0; i < lotto.getNumbers().size(); i++) {
                if(lotto.getNumbers().get(i)==userLottoList.get(1).get(0)) {
                    ++count2;
                }
                    for (int j = 0; j < lotto.getNumbers().size(); j++) {
                    if(lotto.getNumbers().get(i)==userLottoList.get(0).get(j)){
                        System.out.println(lotto.getNumbers());
                        System.out.println(userLottoList);
                        ++count;
                    }
                }
            }
            l1.add(count);
            l2.add(count2);
        }
        total.add(l1);
        total.add(l2);
        return total;
    }
}