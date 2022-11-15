package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private List<Lotto> myLotto = new ArrayList<>();

    public void lotto(Integer cost){
        LottoValidation.costValidation(cost);
        Integer count = cost / 1000;
        while(count != 0) {
            myLotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(LottoValidation.RANGE_START, LottoValidation.RANGE_END, LottoValidation.LOTTO_COUNT)));
            count -=1;
        }
    }
    public Integer getCost(){
        return myLotto.size() * 1000;
    }

    public List<Lotto> getMyLotto(){
        return myLotto;
    }

}
