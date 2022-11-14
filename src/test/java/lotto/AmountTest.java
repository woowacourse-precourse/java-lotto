package lotto;

import lotto.domain.Amount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AmountTest {
    @DisplayName("구입금액이 0원보다 적으면 예외가 발생한다.")
    @Test
    void underZero() {
        assertThatThrownBy(() -> new Amount("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 0원이면 예외가 발생한다.")
    @Test
    void sameZero() {
        assertThatThrownBy(() -> new Amount("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1000단위가 아니면 예외가 발생한다.")
    @Test
    void notThousand() {
        assertThatThrownBy(() -> new Amount("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액에 따른 로또 수가 반환된다.")
    @Test
    void lottoCount() {
        //given
        String inputAmount = "4000";

        //when
        int result = new Amount(inputAmount).getLottoCount();

        //then
        assertThat(result).isEqualTo(4);
    }
}
