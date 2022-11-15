package lotto.infrastructure;

import camp.nextstep.edu.missionutils.Randoms;
import constants.LottoGame;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;

public class LottoProviderImpl implements LottoProvider{

    public List<Lotto> createLottos(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> createLotto())
                .collect(Collectors.toList());
    }

    public Lotto createLotto() {
        List<Integer> lottoNumbers =
                new ArrayList<>(Randoms.pickUniqueNumbersInRange(LottoGame.LOTTO_MIN_RANGE, LottoGame.LOTTO_MAX_RANGE, LottoGame.LOTTO_COUNT));
        return new Lotto(lottoNumbers);
    }

}
