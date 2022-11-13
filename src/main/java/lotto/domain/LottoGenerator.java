package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoGenerator {
    private static final int BEGIN_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int REQUIRED_NUMBER_COUNT = 6;
    private static final int PRICE_PER_LOTTO = 1000;

    private final int lottoCount;

    private List<Lotto> lottoTicket = new ArrayList<>();

    public LottoGenerator(Price price) {
        this.lottoCount = price.getPurchasePrice() / PRICE_PER_LOTTO;
    }

    public List<Lotto> generateLotto() {
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(BEGIN_NUMBER, END_NUMBER, REQUIRED_NUMBER_COUNT));
            lottoTicket.add(lotto);
        }
        return lottoTicket;
    }
}
