package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

public class DefaultLottoIssueService implements LottoIssueService {

    @Override
    public IssuedLotto issueLotto(PurchaseAmount purchaseAmount) {

        long amount = purchaseAmount.getLottoAmount();
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottos.add(Lotto.issue());
        }

        return IssuedLotto.issue(lottos);
    }

}
