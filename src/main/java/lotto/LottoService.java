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


}
