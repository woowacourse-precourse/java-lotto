package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {
    @DisplayName("금액이 유효하지 않으면 예외 발생")
    @ParameterizedTest()
    @ValueSource(ints = {-1000, 1200, 10100})
    void test_when_money_is_not_valid(int money) {
        LottoGenerator generator = LottoGenerator.getInstance();
        assertThatThrownBy(() -> generator.generateLottos(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 로또 가격의 배수여야 합니다");
    }

    @DisplayName("올바른 금액이면 구입 가능한 개수 만큼 로또 발행")
    @ParameterizedTest()
    @CsvSource({"1000,1", "5000,5", "10000,10"})
    void test_when_money_is_not_valid(int money, int expectedSize) {
        LottoGenerator generator = LottoGenerator.getInstance();
        assertThat(generator.generateLottos(money).size())
                .isEqualTo(expectedSize);
    }

}