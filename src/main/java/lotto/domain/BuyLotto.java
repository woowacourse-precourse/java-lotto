package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.Range;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuyLotto {
    private final List<Lotto> lottos;

    public BuyLotto() {
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
        List<Integer> numbers = Randoms
                .pickUniqueNumbersInRange(Range.MIN_RANGE.get(), Range.MAX_RANGE.get(), Range.DIGIT.get());
        sortLotto(numbers);
        lottos.add(new Lotto(numbers));
    }

    private void sortLotto(List<Integer> numbers){
        Collections.sort(numbers);
    }



}
