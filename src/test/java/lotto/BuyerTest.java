package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import lotto.domain.Buyer;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyerTest {
    @DisplayName("입력된 금액이 1000원 단위가 아니면 예외를 발생시킨다.")
    @Test
    void 구매희망_금액_입력값이_1000원_단위가_아닐_때_테스트() {
        //given
        int case1 = 100;
        int case2 = 1300;

        //when
        Throwable result1 = catchThrowable(() -> {
            new Buyer(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            new Buyer(case2);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 금액이 1000원 미만 혹은 10만원 초과이면 예외를 발생시킨다.")
    @Test
    void 구매희망_금액_입력값이_1000원_미만_혹은_10만원_초과일_때_테스트() {
        //given
        int case1 = 0;
        int case2 = 150_000;

        //when
        Throwable result1 = catchThrowable(() -> {
            new Buyer(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            new Buyer(case2);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매자의 로또 수익률을 계산하는 기능")
    @Test
    void 구매자의_로또_수익률을_계산하는_기능_테스트() {
        //given
        Buyer buyer = new Buyer(76000);
        buyer.getLottoResult().put(Rank.FOURTH,1);
        buyer.getLottoResult().put(Rank.FIFTH,1);

        //when
        double result = buyer.getYield();

        //then
        assertThat(result).isEqualTo(72.4);
    }
}