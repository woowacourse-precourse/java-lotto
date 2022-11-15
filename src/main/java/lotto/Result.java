package lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Result {


     static HashMap<Integer, Integer> resultLotto(List<Integer> lotto, HashSet<List> listLotto, int bonusNum) {

        HashMap<Integer, Integer> result = new HashMap<>();
        List<Integer> numLotto = null;

        result.put(5000, 0);
        result.put(50000, 0);
        result.put(1500000, 0);
        result.put(30000000, 0);
        result.put(2000000000, 0);

        for (List i : listLotto) {
            numLotto = i;

            i.removeAll(lotto);

            if (i.size() == 3) {
                result.put(5000, result.get(5000) + 1);

            }
            if ((i.size() == 2)) {
                result.put(50000, result.get(50000) + 1);
            }


            if (i.size() == 1 && !(numLotto.contains(bonusNum))) {
                result.put(1500000, result.get(1500000) + 1);

            }
            if ((i.size() == 1) && (numLotto.contains(bonusNum))) {
                result.put(30000000, result.get(30000000) + 1);
            }
            if (i.size() == 0) {
                result.put(2000000000, result.get(2000000000) + 1);
            }

        }
        return result;
    }

    static double resultPercentage(HashMap<Integer, Integer> result, int money) {
        double sumReward = 0;

        for (Map.Entry<Integer, Integer> reward : result.entrySet()) {
            sumReward += reward.getKey() * reward.getValue();
        }

        return (sumReward / money) * 100;

    }
}
