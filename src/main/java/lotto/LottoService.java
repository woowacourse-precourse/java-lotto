package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LottoService {

    public static HashMap<Integer, List<Integer>> makeLotto(int count){
        HashMap<Integer, List<Integer>> lotties = new HashMap<>();
        for (int i = 0; i < count; i++) {
            lotties.put(i, makeRandomNumber());
        }
        return lotties;
    }

    public static List<Integer> makeRandomNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45,6);
        Collections.sort(numbers);
        return numbers;
    }

    public static int calculateLotto(int money){
        if (money%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력 가능합니다");
        }
        return money/1000;
    }
    public static List<Integer> compare(List<Integer> lotto, List<Integer> winningNumbers, int bonusNumber){
        List<Integer> result = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < winningNumbers.size(); i++) {
            if (lotto.contains(winningNumbers.get(i))){
                count++;
            }
        }
        result.add(count);
        result.add(0);
        if (lotto.contains(bonusNumber)){
            result.set(1, 1);
        }
        return result;
    }

    public static HashMap<Integer, List<Integer>> calculateCompareResult(int count, HashMap<Integer, List<Integer>> lotties, List<Integer> winningNumbers, int bonusNumber) {
        HashMap<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < count; i++) {
            result.put(i, compare(lotties.get(i), winningNumbers, bonusNumber));
        }
        return result;
    }


}
