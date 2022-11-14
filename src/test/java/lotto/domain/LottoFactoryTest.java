package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


class LottoFactoryTest {

    int inputMoney;
    Money money;
    Numbers numbers;
    LottoFactory factory;

    @BeforeEach
    void init() {
        inputMoney = 3000;
        money = new Money(inputMoney);
        numbers = Mockito.mock(Numbers.class);
        factory = new LottoFactory(numbers);
    }

    @DisplayName("입력한 돈만큼 로또 번호 생성")
    @Test
    void generateLottos() {

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

    @DisplayName("중복된 숫자가 주어지면 로또에 추가하지 않는다.")
    @Test
    void generateLottosWithDuplicateNumbers() {

        // when
        when(numbers.generate()).thenReturn(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
        List<Lotto> lottos = factory.generateLottos(money);

        // then
        assertThat(lottos.size()).isEqualTo(inputMoney / Config.LOTTO_PRICE);
    }
}
