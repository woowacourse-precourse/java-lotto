package lotto.model;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutputView;

public class LottoFactory {

    List<List<Integer>> lottos;

    public LottoFactory(int lottoAmout){

        List<List<Integer>> lottos = new ArrayList<>();

        for(int i = 0; i < lottoAmout; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(numbers);
        }

        this.lottos = lottos;
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }

}
