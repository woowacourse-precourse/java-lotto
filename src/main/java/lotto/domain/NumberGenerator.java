package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class NumberService {

    public static Set<Integer> GenerateNumbers(){
        Set<Integer> result = new HashSet<>();

        while (result.size() < 7){
            int number = Randoms.pickNumberInRange(1, 45);
            result.add(number);
        }

        return result;
    }
}
