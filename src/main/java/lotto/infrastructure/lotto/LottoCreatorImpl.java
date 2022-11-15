package lotto.infrastructure.lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.service.LottoCreator;
import lotto.domain.money.Money;
import lotto.global.message.Number;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoCreatorImpl implements LottoCreator {

    @Override
    public Lottos buyLottos(Money money) {
        final Integer count = money.getCount();
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            final Lotto lotto = Lotto.create(new ArrayList<>(Randoms.pickUniqueNumbersInRange(Number.MIN_NUMBER_RANGE, Number.MAX_NUMBER_RANGE, Number.LOTTO_SIZE)));
            lottoList.add(lotto);
        }

        return new Lottos(lottoList);
    }
}
