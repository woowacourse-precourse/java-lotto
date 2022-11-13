package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class LottoNumbers {
    private List<Integer> lottoNumbers;

    public List<Integer> createRandomNumbers() {
        lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }


}
