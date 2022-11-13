package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.validator.MoneyValidator;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.LottoInformation.*;

public class Ticket {
    private final int lottoCount;
    private final int price;
    private List<Lotto> lottos;

    public Ticket(int money) {
        MoneyValidator.checkUnitOf1000Won(money);
        price = money;
        lottoCount = setLottoCount(money);
        setLottos(lottoCount);
    }

    private int setLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    private void setLottos(int lottoCount) {
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

    public int getPrice() {
        return price;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toString()).append('\n');
        }
        return stringBuilder.toString();
    }
}