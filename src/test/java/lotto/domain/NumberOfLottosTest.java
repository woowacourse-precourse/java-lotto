package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberOfLottosTest {

    private NumberOfLottos numberOfLottos;

    @BeforeEach
    void setUp() {
        numberOfLottos = new NumberOfLottos();
    }

    @ParameterizedTest
    @CsvSource({"8000,8", "1000,1", "14000,14"})
    @DisplayName("입력한 금액으로 구입 가능한 로또의 개수를 구하는 기능")
    void calculateNumberOfLottos(int price, int expected) {
        int actual = numberOfLottos.calculateNumberOfLottos(price);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"8100,[ERROR] 화폐 단위가 옳지 않습니다.", "0,[ERROR] 금액은 최소 1,000원이어야 합니다."})
    @DisplayName("입력 금액 예외처리 기능")
    void validatePriceAmount(int price, String errorMessage) {
        assertThatThrownBy(() -> numberOfLottos.calculateNumberOfLottos(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }
}