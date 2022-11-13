package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class MakingLotto {

    public int getLottoCount(int money){
        int lottoCount=money/1000;
        return lottoCount;
    }

    public List<Integer> makeLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public List<List<Integer>> getAllLotto(int LottoCount){
        List<List<Integer>> allLotto=new ArrayList<>();
        for(int index=0;index<LottoCount;index++){
            allLotto.add(makeLotto());
        }
        return allLotto;
    }

}
