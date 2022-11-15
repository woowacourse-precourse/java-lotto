package lotto.logic;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    private List<Integer> lottonum;

    public List<Integer> lottoGenerate() {
        lottonum = new ArrayList<>();
        lottonum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottonum = lottonum.stream().sorted().collect(Collectors.toList());
        return lottonum;
    }
}