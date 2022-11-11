package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.ArrayList;

import static lotto.constValue.Constants.LottoInfo.*;

public class LottoGenerator {

    public List<Lotto> createLottoNumbers(int lottoAmount) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottoAmount > 0) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, COUNT_RANGE);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
            lottoAmount--;
        }
        return lottos;
    }


}
