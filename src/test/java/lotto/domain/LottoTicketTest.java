package lotto.domain;

import static lotto.domain.LottoPrize._1ST_PRIZE;
import static lotto.domain.LottoPrize._2ND_PRIZE;
import static lotto.domain.LottoPrize._3RD_PRIZE;
import static lotto.domain.LottoPrize._4TH_PRIZE;
import static lotto.domain.LottoPrize._5TH_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("LottoTicket 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoTicketTest {

    private LottoTicket lottoTicket;

    @BeforeEach
    void setup() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(10, 20, 30, 40, 44, 45))
        );
        lottoTicket = new LottoTicket(lottos);
    }

    @Test
    void value_메서드는_로또_번호_리스트들을_반환한다() {
        assertThat(lottoTicket.value()).contains(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 7, 8, 9),
                List.of(10, 20, 30, 40, 44, 45)
        );
    }

    @ParameterizedTest
    @MethodSource("winningNumbersAndBonusNumber")
    void check_메서드는_당첨_번호와_보너스_번호를_받아_LottoResult를_반환한다(
            Lotto winningNumbers,
            LottoNumber bonusNumber,
            List<Integer> prizeCount) {
        LottoResult result = lottoTicket.check(winningNumbers, bonusNumber);

        assertThat(result.getCount(_1ST_PRIZE)).isEqualTo(prizeCount.get(0));
        assertThat(result.getCount(_2ND_PRIZE)).isEqualTo(prizeCount.get(1));
        assertThat(result.getCount(_3RD_PRIZE)).isEqualTo(prizeCount.get(2));
        assertThat(result.getCount(_4TH_PRIZE)).isEqualTo(prizeCount.get(3));
        assertThat(result.getCount(_5TH_PRIZE)).isEqualTo(prizeCount.get(4));
    }

    static List<Arguments> winningNumbersAndBonusNumber() {
        return Arrays.asList(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.valueOf(7), List.of(1, 0, 0, 0, 1)),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 43)), LottoNumber.valueOf(6), List.of(0, 1, 0, 0, 1)),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)), LottoNumber.valueOf(7), List.of(0, 0, 1, 1, 0)),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 40, 41)), LottoNumber.valueOf(7), List.of(0, 0, 0, 1, 1)),
                Arguments.of(new Lotto(List.of(1, 2, 3, 40, 41, 42)), LottoNumber.valueOf(7), List.of(0, 0, 0, 0, 2)),
                Arguments.of(new Lotto(List.of(37, 38, 39, 40, 41, 42)), LottoNumber.valueOf(7), List.of(0, 0, 0, 0, 0))
        );
    }

}
