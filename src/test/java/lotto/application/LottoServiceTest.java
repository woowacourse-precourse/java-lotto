package lotto.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Nested
    @DisplayName("로또 판매 테스트")
    class SellLottoTest {

        @Nested
        @DisplayName("정상 동작")
        class NormalTest {

            @Test
            @DisplayName("구매 금액이 0일때 0개의 로또를 구매할 수 있다.")
            void sellLotto1() {
                LottoService lottoService = LottoService.getInstance();
                assertThat(lottoService.sellLotto(0).size()).isEqualTo(0);
            }

            @Test
            @DisplayName("구매 금액이 5,000일때 5개의 로또를 구매할 수 있다.")
            void sellLotto2() {
                LottoService lottoService = LottoService.getInstance();
                assertThat(lottoService.sellLotto(5000L).size()).isEqualTo(5);
            }

            @Test
            @DisplayName("구매 금액이 22억일때 220만개의 로또를 구매할 수 있다.")
            void sellLotto3() {
                LottoService lottoService = LottoService.getInstance();
                assertThat(lottoService.sellLotto(2_200_000_000L).size()).isEqualTo(2_200_000);
            }
        }

        @Nested
        @DisplayName("예외 테스트")
        class ExceptionTest {

            @Test
            @DisplayName("1,000 단위가 아닌 금액이 들어오면 예외가 발생한다.")
            void amountException() {
                LottoService lottoService = LottoService.getInstance();
                assertThatThrownBy(() -> lottoService.sellLotto(1))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    @DisplayName("로또 비교 테스트")
    class CompareLottoTest {

        @Nested
        @DisplayName("정상 동작 테스트")
        class NormalTest {

            @Test
            @DisplayName("로또 구매시 Result 클래스의 인스턴스가 반환된다.")
            void compareLotto() {
                LottoService lottoService = LottoService.getInstance();
                WinNumbers winNumbers = new WinNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
                List<Lotto> lottos = lottoService.sellLotto(1000);

                List<Result> results = lottoService.compareLottos(winNumbers, lottos);

                assertThat(results.get(0)).isInstanceOf(Result.class);
            }
        }

        /**
         * compare 부분의 Exception 은 domain 에서 검증됨
         */
    }
}
