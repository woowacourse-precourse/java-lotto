package lotto.service;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class LottoServiceTest {

    @Test
    void case1() {
        LottoService lottoService = new LottoService();
        lottoService.setLotto(1000);
        lottoService.getWinningHistory(List.of(1, 2, 3, 4, 5, 6), 7);
        System.out.println(WinningHistory.FIRST_PLACE.getQuantity());
        System.out.println(WinningHistory.SECOND_PLACE.getQuantity());
        System.out.println(WinningHistory.THIRD_PLACE.getQuantity());
        System.out.println(WinningHistory.FOURTH_PLACE.getQuantity());
        System.out.println(WinningHistory.FIFTH_PLACE.getQuantity());
        System.out.println(lottoService.getReturn(1000));
    }

    @Nested
    @DisplayName("로또 수량 테스트")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class lottoQuantityTest {
        @ParameterizedTest
        @MethodSource("data")
        void case1(int quantity, int lottoQuantity) {
            LottoService lottoService = new LottoService();
            lottoService.setLotto(quantity);
            int size = lottoService.getLottoNumbers().size();
            Assertions.assertThat(size).isEqualTo(lottoQuantity);
        }

        Stream<Arguments> data() {
            return Stream.of(
                    Arguments.of(1, 1),
                    Arguments.of(10, 10),
                    Arguments.of(123, 123)
            );
        }
    }
}
