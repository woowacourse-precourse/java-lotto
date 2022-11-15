package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumberGenerator {

    private List<List<Integer>> lottoNumbersList = new ArrayList<>();


    public List<List<Integer>> makeRandomLottoNumberList(int count) {
        for(int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottoNumbersList.add(numbers);
        }
        return this.lottoNumbersList;
    }

}
