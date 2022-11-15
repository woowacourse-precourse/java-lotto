package lotto.service;

import lotto.domain.IssuedLotto;
import lotto.domain.PurchaseAmount;

public interface LottoIssueService {

    IssuedLotto issueLotto(PurchaseAmount purchaseAmount);

}
