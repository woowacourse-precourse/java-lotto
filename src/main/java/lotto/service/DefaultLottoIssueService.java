package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

public class DefaultLottoIssueService implements LottoIssueService {

    @Override
    public List<Lotto> issueLotto(PurchaseAmount purchaseAmount) {

        long amount = purchaseAmount.getLottoAmount();
        List<Lotto> issuedLotto = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            issuedLotto.add(Lotto.issue());
        }

        return issuedLotto;
    }

}
