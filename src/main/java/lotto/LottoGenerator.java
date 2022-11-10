package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {
    private final Integer lottoCount;
    private final List<List<Integer>> lottos;

    public LottoGenerator(Integer lottoCount) {
        this.lottoCount = lottoCount;
        this.lottos = createLottoList(lottoCount);
    }

    public List<List<Integer>> createLottoList(Integer cnt) {
        List<List<Integer>> lottosList = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            List<Integer> lottos = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottosList.add(lottos);
        }
        return lottosList;
    }
}