package study;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class JavaTest {
    @Test
    void sortImmutableListValues(){
        List<Integer> numbers= new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45,6));
        Collections.sort(numbers);
        System.out.println(numbers);
    }
}
