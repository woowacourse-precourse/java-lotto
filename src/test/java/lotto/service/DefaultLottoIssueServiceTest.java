package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DefaultLottoIssueServiceTest {

    LottoIssueService lottoIssueService;

    @BeforeEach
    void setUp() {
        this.lottoIssueService = new DefaultLottoIssueService();
    }

    @DisplayName("사용자 구매금액에 따른 로또 생성")
    @Test
    void issueLotto() {
        String price = "10000";
        PurchaseAmount purchaseAmount = new PurchaseAmount(price);

        List<Lotto> issuedLotto = lottoIssueService.issueLotto(purchaseAmount);

        assertThat(issuedLotto).hasSize((int) purchaseAmount.getLottoAmount());
    }

}
