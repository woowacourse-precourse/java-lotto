package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoShopTest {
    @ParameterizedTest(name = "금액: {0}, 생성 개수:{1}")
    @DisplayName("지불한 금액에 맞게 로또를 발급한다.")
    @CsvSource({"5000,5", "14500,14","100,0"})
    void sellLottery(int money, int expected) {
        LottoTicket lotteryTicket = LottoShop.buyLottos(money);
        assertThat(lotteryTicket.exportLottoNumbers()).hasSize(expected);
    }
}