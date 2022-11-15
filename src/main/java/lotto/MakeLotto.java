package lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class MakeLotto {
    public static List<List<Integer>> totallotto(int cnt){
        List<List<Integer>> total = new ArrayList<>();
        for(int i=0;i<cnt;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            List<Integer> list = new ArrayList<>(numbers);
            Collections.sort(list);
            System.out.println(list);
            total.add(list);
        }
        return total;
    }
}
