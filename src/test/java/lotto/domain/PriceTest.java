package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PriceTest {
    @DisplayName("천 원 단위가 아닌 금액인 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"700", "1100", "1111111111", "795210", "5"})
    void inputPriceByNonUnitsOfOneThousandWon(Integer inputPrice) {
        assertThatThrownBy(() -> new Price(inputPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }
}