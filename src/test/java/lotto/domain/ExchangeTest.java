package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static lotto.domain.Exchange.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ExchangeTest {

    @Test
    void isMatch() {
        // given
        int match = 3;

        // when
        boolean isMatch = FIVE.isMatch(match);
        // then
        assertThat(isMatch).isTrue();
    }

    @Test
    void isBonus() {
        // given
        boolean flag = true;

        // when
        boolean isBonus = TWO.isBonus(flag);

        // then
        assertThat(isBonus).isTrue();
    }

    @Test
    void getPrice() {
        // given
        long price = 2000000000;

        // when

        // then
        assertThat(ONE.getPrice()).isEqualTo(price);
    }

    @Test
    void getMessage() {
        // given
        String message = "6개 일치 (2,000,000,000원) - ";

        // when


        // then
        assertThat(ONE.getMessage()).isEqualTo(message);
    }
}
