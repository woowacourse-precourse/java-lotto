package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {

    public List<Lotto> issueLottoNumbers(long count) {

        List<Lotto> lottoNumbers = Stream.generate(() -> new Lotto(getLottoNumber()))
                .limit(count)
                .collect(Collectors.toList());

        return lottoNumbers;
    }

    public List<Integer> getLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
