package lotto.infrastructure;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;

public class LottoProvider {

    public static List<Lotto> createLottos(int lottoCount) {
        return IntStream.range(0,lottoCount)
                .mapToObj(i -> createLotto())
                .collect(Collectors.toList());
    }

    public static Lotto createLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return new Lotto(lottoNumbers);
    }
}
