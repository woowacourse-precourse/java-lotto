package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.IssuedLotto;
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
    void testIssueLotto() {
        String price = "10000";
        PurchaseAmount purchaseAmount = new PurchaseAmount(price);

        IssuedLotto issuedLotto = lottoIssueService.issueLotto(purchaseAmount);

        assertThat(issuedLotto.getAmount()).isEqualTo((int) purchaseAmount.getLottoAmount());
    }

    @DisplayName("빈 로또 는 생성 불가")
    @Test
    void testEmptyLotto() {

        List<Lotto> lottos = List.of();

        assertThatThrownBy(() -> IssuedLotto.issue(lottos)).isInstanceOf(IllegalArgumentException.class);
    }

}
