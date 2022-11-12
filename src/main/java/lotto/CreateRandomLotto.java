package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class CreateRandomLotto {

    public List<LottoPaper> randomLotto(long counts){
        List<LottoPaper> lottoPaper= new ArrayList<>();
        for(int i = 0; i < counts; i++){
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lotto);
            LottoPaper eachNumber = new LottoPaper();
            eachNumber.setNumber(lotto);
            lottoPaper.add(eachNumber);
        }
        return lottoPaper;
    }
}
