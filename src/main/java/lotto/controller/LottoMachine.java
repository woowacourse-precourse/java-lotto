package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.info.Rule.*;

public class LottoMachine {
    public static Lotto publishLotto() {
        List<Integer> lottoNumbers = getLottoNumber();

        return new Lotto(sort(lottoNumbers));
    }

    private static List<Integer> getLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER.getNumber(), END_NUMBER.getNumber(), NUMBER_COUNT.getNumber());
    }

    private static List<Integer> sort(List<Integer> lottoNumbers) {
        return lottoNumbers.stream().sorted().collect(Collectors.toList());
    }
}
