package lotto.function;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tools {
    public static List<Integer> makeNumbers(){
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return numbers;
    }

    public static void showNumbers(List<Integer> numbers){
        Collections.sort(numbers);
        System.out.println(numbers);
    }
}
