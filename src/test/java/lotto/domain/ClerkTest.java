package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClerkTest {
    Clerk clerk = new Clerk();

    @DisplayName("1000원당 한 장씩 로또를 발행한다.")
    @Test
    void 금액에_맞는_수의_로또_발행() {
        int money = 5000;
        List<Lotto> lottos = clerk.issueLottos(money);

        assertThat(lottos)
                .hasSize(5);
    }

    @DisplayName("금액이 1000원 단위로 들어오지 않으면 예외가 발생한다.")
    @Test
    void 금액_예외1() {
        int money = 4500;

        assertThatThrownBy(() -> clerk.issueLottos(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원");
    }

    @DisplayName("양수의 금액이 들어오지 않으면 예외가 발생한다.")
    @Test
    void 금액_예외2() {
        int money = 0;

        assertThatThrownBy(() -> clerk.issueLottos(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수");
    }
}