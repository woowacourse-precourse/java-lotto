package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandom {
    private final int MIN_LOTTO_NUM = 1;
    private final int MAX_LOTTO_NUM = 45;
    private final int LOTTO_COUNT = 6;

    public List<List<Integer>> generateRandomLottoNumberList(int purchaseCount){
        List<List<Integer>> lottoRandomList  = new ArrayList<>();;
        List<Integer> numbers;

        for(int i = 0; i < purchaseCount; i ++){
            numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_COUNT);
            Collections.sort(numbers);
            lottoRandomList.add(numbers);
        }
        return lottoRandomList;
    }
}
