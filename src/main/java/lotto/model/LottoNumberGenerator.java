package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoNumberGenerator {
    public Lotto generate() {
        return new Lotto(createLottoNumbers());
    }

    private Set<LottoNumber> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER, Lotto.NUMBERS_SIZE)
                .stream().map(LottoNumber::new).collect(Collectors.toCollection(TreeSet::new));
    }
}
