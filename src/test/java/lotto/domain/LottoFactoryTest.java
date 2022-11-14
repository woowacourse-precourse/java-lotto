package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


class LottoFactoryTest {

    @DisplayName("입력한 돈만큼 로또 번호 생성")
    @Test
    void generateLottos() {
        // given
        int inputMoney = 3000;
        Money money = new Money(inputMoney);
        Numbers numbers = Mockito.mock(Numbers.class);
        LottoFactory factory = new LottoFactory(numbers);

        // when
        when(numbers.generate()).thenReturn(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
        List<Lotto> lottos = factory.generateLottos(money);

        // then
        assertThat(lottos.size()).isEqualTo(inputMoney / Config.LOTTO_PRICE);
    }
}
