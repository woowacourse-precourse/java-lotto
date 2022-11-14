package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private List<Lotto> myLotto = new ArrayList<>();

    public void lotto(Integer cost){
        Validation.costValidation(cost);
        Integer count = cost / 1000;
        while(count != 0) {
            myLotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(Validation.RANGE_START, Validation.RANGE_END, Validation.LOTTO_COUNT)));
            count -=1;
        }
    }

    public List<Lotto> getMyLotto(){
        return myLotto;
    }

}
