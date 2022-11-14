package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.resource.Constant;

public class LottoGenerator {
    private final int lottoCount;

    private List<Lotto> lottoTicket = new ArrayList<>();

    public LottoGenerator(Price price) {
        this.lottoCount = price.getPurchasePrice() / Constant.PRICE_PER_LOTTO.getValue();
    }

    public List<Lotto> generateLotto() {
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(Constant.BEGIN_NUMBER.getValue(),
                    Constant.END_NUMBER.getValue(), Constant.REQUIRED_NUMBER_COUNT.getValue()));
            lottoTicket.add(lotto);
        }
        return lottoTicket;
    }
}
