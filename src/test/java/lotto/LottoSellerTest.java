package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoSellerTest {

    @Nested
    @DisplayName("정상 동작")
    class NormalTest {

        @Test
        @DisplayName("구매 금액이 0일때 0개의 로또를 구매할 수 있다.")
        void sellLotto0() {
            LottoSeller lottoSeller = LottoSeller.getInstance();
            assertThat(lottoSeller.sellLotto(0).size()).isEqualTo(0);
        }

        @Test
        @DisplayName("구매 금액이 5,000일때 5개의 로또를 구매할 수 있다.")
        void sellLotto5() {
            LottoSeller lottoSeller = LottoSeller.getInstance();
            assertThat(lottoSeller.sellLotto(5000L).size()).isEqualTo(5);
        }

        @Test
        @DisplayName("구매 금액이 22억일때 220만개의 로또를 구매할 수 있다.")
        void amountException1() {
            LottoSeller lottoSeller = LottoSeller.getInstance();
            assertThat(lottoSeller.sellLotto(2_200_000_000L).size()).isEqualTo(2_200_000);
        }
    }

    @Nested
    @DisplayName("예외 처리")
    class ExceptionTest {

        @Test
        @DisplayName("1,000 단위가 아닌 금액이 들어오면 예외가 발생한다.")
        void amountException() {
            LottoSeller lottoSeller = LottoSeller.getInstance();
            assertThatThrownBy(() -> lottoSeller.sellLotto(1))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
