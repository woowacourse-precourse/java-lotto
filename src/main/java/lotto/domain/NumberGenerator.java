package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.text.CollationElementIterator;
import java.util.*;

public class NumberGenerator {

    public static List<Integer> GenerateNumbers(){
        Set<Integer> result = new HashSet<>();

        while (result.size() < 6){
            int number = Randoms.pickNumberInRange(1, 45);
            result.add(number);
        }

        List<Integer> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult);

        return sortedResult;
    }
}
