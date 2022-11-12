package lotto.domain.lotto.lottocompany;

import java.util.List;
import lotto.domain.lotto.lotto.PublishedLotto;
import lotto.domain.lotto.lotto.Lotto;

public class LottoCompanyImpl implements LottoCompany {

    private final LottoMachine lottoMachine;

    public LottoCompanyImpl(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    @Override

    public List<Lotto> publishNLotto(int publishLottoCount) {
        PublishedLotto publishedLotto = new PublishedLotto();

        for (int i = 0; i < publishLottoCount; i++) {
            publishedLotto.addPublishedLotto(lottoMachine.createLotto());
        }

        return publishedLotto.getPublishedLotto();
    }
}
