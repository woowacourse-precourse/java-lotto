package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoShop {

    private List<Integer> pickLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
            .stream().sorted()
            .collect(Collectors.toList());
    }

}
