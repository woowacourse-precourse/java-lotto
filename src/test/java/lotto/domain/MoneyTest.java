package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoneyTest {
    @DisplayName("Money 는 양수이고,MoneyUnit(기본은 1000) 의 배수일 때 잘 생성된다")
    @ParameterizedTest
    @ValueSource(ints = {1000, 50000, 2342000})
    void case1(int amount) {
        assertDoesNotThrow(() -> new Money(amount));
    }

    @DisplayName("Money 는 양수이고,MoneyUnit(기본은 1000) 의 배수가 아니면 IEA 예외")
    @ParameterizedTest
    @ValueSource(ints = {0, -1000, 2342})
    void case2(int amount) {
        assertThrows(IllegalArgumentException.class, () -> new Money(amount));
    }

    @DisplayName("ableToBuy 메서드는 구매 가능한 로또의 수를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 50, 2342})
    void case3(int count) {
        assertThat(new Money(count * 1000).ableToBuy()).isEqualTo(count);
    }
}
