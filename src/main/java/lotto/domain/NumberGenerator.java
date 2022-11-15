package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.text.CollationElementIterator;
import java.util.*;

public class NumberGenerator {

    public static List<Integer> GenerateNumbers(){
        List<Integer> result = Randoms.pickUniqueNumbersInRange(1,45,6);

        return result;
    }
}
