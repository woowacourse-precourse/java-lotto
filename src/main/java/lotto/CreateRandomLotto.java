package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateRandomLotto {
    public void randomLotto(int counts){
        LottoPaper [] lottoPaper= new LottoPaper[counts];
       for(int i = 0; i < counts; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoPaper[i] = new LottoPaper(numbers);
        }
    }
}
