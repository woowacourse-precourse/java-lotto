package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {

    public List<Integer> generateLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }
}
