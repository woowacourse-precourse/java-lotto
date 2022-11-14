package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.Range;

import java.util.ArrayList;
import java.util.List;

public class LottoChoice {
    private List<Lotto> lottos;

    public LottoChoice() {
        lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void createLottos(int n){
        for(int i=0;i<n;i++){
            makeLotto();
        }
    }

    private void makeLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Range.MIN_RANGE.get(), Range.MAX_RANGE.get(), Range.DIGIT.get());
        lottos.add(new Lotto(numbers));
    }


}
