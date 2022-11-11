package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class CreateRandomLotto {

    public void randomLotto(long counts){
        List<LottoPaper> lottoPaper= new ArrayList<>();
        for(int i = 0; i < counts; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            LottoPaper eachNumber = new LottoPaper();
            eachNumber.setNumber(numbers);
            lottoPaper.add(eachNumber);
        }
    }
}
