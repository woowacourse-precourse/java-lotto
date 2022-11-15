package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberOfLottosTest {

    private NumberOfLottos numberOfLottos;

    @ParameterizedTest
    @CsvSource({"5000,3000,1.6666666666666667", "5000,5000,1.0"})
    @DisplayName("로또 수익률 계산 기능 테스트")
    void calculateYield(long rankMoney, int price, double expected) {
        numberOfLottos = new NumberOfLottos(price);
        double actual = numberOfLottos.calculateYield(rankMoney);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"3000,3", "4000,4"})
    @DisplayName("로또 수량 계산 기능 테스트")
    void calculateNumberOfLottos(int price, int expected) {
        numberOfLottos = new NumberOfLottos(price);
        int actual = numberOfLottos.calculateNumberOfLottos(price);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"3001,[ERROR] 화폐 단위가 옳지 않습니다.", "0,[ERROR] 금액은 최소 1,000원이어야 합니다."})
    @DisplayName("로또 수량 계산 기능 예외 테스트")
    void calculateNumberOfLottos(int price, String expected) {
        assertThatThrownBy(() -> numberOfLottos = new NumberOfLottos(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }
}