package lotto;

import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Create {
    public static List<Integer> lotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return sortLotto(numbers);
    }
    
    public static List<Integer> sortLotto(List<Integer> numbers){
        Collections.sort(numbers);
        return numbers;
    }
}
