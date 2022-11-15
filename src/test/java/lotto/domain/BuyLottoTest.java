package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BuyLottoTest {

    @DisplayName("금액에 맞는 개수의 로또를 구입했는지 체크")
    @Test
    void case1() {
        BuyLotto buyLotto = new BuyLotto(8000);
        assertThat(buyLotto.getCount()).isEqualTo(8);
    }

    @DisplayName("금액에 맞는 개수의 로또를 구입했는지 체크")
    @Test
    void case2() {
        BuyLotto buyLotto = new BuyLotto(4000);
        assertThat(buyLotto.getCount()).isEqualTo(4);
    }

    @DisplayName("금액이 1,000원 단위가 아닐 때")
    @Test
    void case3() {
        assertThatThrownBy(() -> new BuyLotto(1230))
                .isInstanceOf(IllegalArgumentException.class);
    }

}