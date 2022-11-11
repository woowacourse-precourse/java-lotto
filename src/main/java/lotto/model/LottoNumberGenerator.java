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
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                .map(LottoNumber::new).collect(Collectors.toCollection(TreeSet::new));
    }
}
