package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Buyer;
import lotto.domain.LottoVendor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BuyerTest {
    private LottoVendor lottoVendor = new LottoVendor();
    private Buyer buyer;

    @BeforeEach
    void initBuyer() {
        buyer = new Buyer();
    }

    @DisplayName("1000으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"100", "1001", "99999"})
    void purchaseMoneyNotDividedBy1000(int purchaseMoney) {
        assertThatThrownBy(() -> buyer.purchase(lottoVendor, purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
    }

}