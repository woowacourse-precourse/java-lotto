package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

public interface LottoIssueService {

    List<Lotto> issueLotto(PurchaseAmount purchaseAmount);

}
