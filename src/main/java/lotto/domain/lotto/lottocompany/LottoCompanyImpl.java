package lotto.domain.lotto.lottocompany;

import java.util.List;
import lotto.domain.lotto.lotto.PublishedLotto;
import lotto.domain.lotto.lotto.Lotto;

public class LottoCompanyImpl implements LottoCompany {

    private final LottoMachine lottoMachine;
    private final PublishedLotto publishedLotto;

    public LottoCompanyImpl(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
        this.publishedLotto = new PublishedLotto();
    }

    @Override

    public List<Lotto> publishNLotto(int publishLottoCount) {
        for (int i = 0; i < publishLottoCount; i++) {
            publishedLotto.addPublishedLotto(lottoMachine.createLotto());
        }

        return publishedLotto.getPublishedLotto();
    }
}
