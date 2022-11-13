package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.validator.MoneyValidator;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.LottoInformation.*;

public class Ticket {
    private final int lottoCount;
    private List<Lotto> lottos;

    public Ticket(int money) {
        MoneyValidator.checkUnitOf1000Won(money);
        lottoCount = getLottoCount(money);
        getLottos(lottoCount);
    }

    private int getLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    private void getLottos(int lottoCount) {
        lottos = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++) {
            lottos.add(createLotto());
        }
    }

    private Lotto createLotto() {
        Lotto lotto = new Lotto(
                Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_SELECTION_COUNT)
        );
        lotto.sortNumbers();
        return lotto;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto).append('\n');
        }
        return stringBuilder.toString();
    }
}
