package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

import static lotto.Valid.validCreateLotto;

public class Generator {

    public Lotto createLottoNumber() {
        int MIN_NUMBER = 1;
        int MAX_NUMBER = 45;
        int LOTTO_SIZE = 6;
        return createLotto(new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE)));
    }

    private Lotto createLotto(List<Integer> lottoNumbers) {
        lottoNumbers.sort(Comparator.naturalOrder());
        validCreateLotto(lottoNumbers);
        return new Lotto(lottoNumbers);
    }



}
