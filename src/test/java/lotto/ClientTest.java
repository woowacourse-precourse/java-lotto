package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClientTest {

    @DisplayName("로또 구입시 문자열 5000을 입력받으면 숫자 5000이 반환된다")
    @Test
    void buyLottoString5000ThenReturnInt5000() {
        Assertions.assertThat(new Client(()->"5000").buy()).isEqualTo(5000);
    }

    @DisplayName("로또 구입시 숫자 입력이 아니라면 IllegalArgumentException을 발생시킨다")
    @Test
    void buyLotto오천원ThenIllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> new Client(()->"오천원").buy())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입시 1000원 단위가 아니라면 IllegalArgumentException을 발생시킨다")
    @Test
    void buyLottoString5123ThenIllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> new Client(()->"5123").buy())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
