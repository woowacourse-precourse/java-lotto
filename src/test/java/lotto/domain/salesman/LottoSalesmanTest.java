package lotto.domain.salesman;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;
import lotto.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LottoSalesmanTest {

    @DisplayName("로또 판매 테스트 [A원을 받으면 B원 짜리 로또 C장을 판매한다.]")
    @ParameterizedTest(name = "{displayName} {argumentsWithNames}")
    @CsvSource({"8_000, 1_000, 8", "26_000, 2_000, 13", "1_000, 1_000, 1"})
    void lottoSale(final int payment, final int lottoPrice, final int count) {
        // given
        LottoGenerator mockGenerator = mock(LottoGenerator.class);
        LottoSalesman lottoSalesman = new LottoSalesman(Money.valueOf(lottoPrice), mockGenerator);

        when(mockGenerator.generateByCount(count))
                .thenReturn(IntStream.range(0, count)
                        .mapToObj(i -> mock(Lotto.class))
                        .collect(Collectors.toList()));
        // when
        List<Lotto> lottos = lottoSalesman.salesLotto(Money.valueOf(payment));

        // then
        assertThat(lottos.size()).isEqualTo(count);
    }

    @DisplayName("로또 판매 예외 테스트 [A원이 B원으로 나눠지지 않으면 예외를 발생한다.]")
    @ParameterizedTest(name = "{displayName} {argumentsWithNames}")
    @CsvSource({"8_500, 1_000", "26_050, 1_000", "1_005, 1_000"})
    void lottoSaleByIndivisible(final int payment, final int lottoPrice) {
        // given
        LottoGenerator mockGenerator = mock(LottoGenerator.class);
        LottoSalesman lottoSalesman = new LottoSalesman(Money.valueOf(lottoPrice), mockGenerator);

        // when, then
        assertThatThrownBy(() -> lottoSalesman.salesLotto(Money.valueOf(payment)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}