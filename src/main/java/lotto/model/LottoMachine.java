package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.model.Lotto.*;

public class LottoMachine {

    public List<Integer> createNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_SIZE));

        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
