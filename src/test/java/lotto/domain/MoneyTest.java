package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("구입 금액이 정수가 아닌 경우")
    @Test
    void inputNotInteger() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Money("800as"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 음의 정수인 경우")
    @Test
    void inputNegativeInteger() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Money("-8000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않는 경우")
    @Test
    void inputNonLottoMoney() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Money("8001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0원인 경우")
    @Test
    void inputZeroMoney() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThat(new Money("0").getMoney()).isEqualTo(0);
    }
}
