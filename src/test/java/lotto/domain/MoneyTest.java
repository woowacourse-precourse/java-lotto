package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    void create() {
        Money actual = new Money(1000);

        assertThat(actual).isEqualTo(new Money(1000));
    }

    @DisplayName("1미만일 경우 에러를 반환한다.")
    @Test
    void createMoneyLessOne() {
        assertAll(
                () -> assertThatThrownBy(() -> new Money(0)).isInstanceOf(IllegalArgumentException.class),
                () -> assertDoesNotThrow(() -> new Money(1))
        );
    }
}
