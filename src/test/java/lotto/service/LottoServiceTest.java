package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.entity.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @DisplayName("금액에 알맞은 로또 목록을 생성한다.")
    @Test
    void generateLottos() {
        //given
        int count = 5;
        int price = LottoService.PRICE * count;

        //when
        List<Lotto> result = lottoService.generateLottos(price);

        //then
        assertThat(result.size()).isEqualTo(5);
    }

    @DisplayName("금액이 정해진 가격으로 나누어떨어지지 않으면 IllegalArgumentException이 발생한다.")
    @Test
    void generateLottosFail() {
        //given
        int price = LottoService.PRICE / 2;

        //then
        assertThatThrownBy(() -> lottoService.generateLottos(price)).isInstanceOf(
            IllegalArgumentException.class);
    }

}