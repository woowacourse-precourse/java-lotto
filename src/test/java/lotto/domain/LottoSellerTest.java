package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class LottoSellerTest {
    @DisplayName("발행한 로또 개수와 주어진 개수 일치 여부 테스트")
    @ParameterizedTest()
    @CsvSource({"1", "2", "3", "100"})
    void issueLottosByAmount(int amount) {
        assertThat(LottoSeller.issueLottosByAmount(amount))
                .isNotNull()
                .isInstanceOf(List.class)
                .hasSize(amount);
    }

    @DisplayName("발행할 로또 개수가 1보다 작으면 예외가 발생")
    @ParameterizedTest
    @CsvSource({"-1", "0"})
    void issueLottosByAmountLessThan1(int amount) {
        assertThatThrownBy(() -> LottoSeller.issueLottosByAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.AMOUNT_INSUFFICIENT.getValue());
    }
}