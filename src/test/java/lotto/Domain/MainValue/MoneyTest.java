package lotto.Domain.MainValue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("1000원으로 나눠지지 않으면 에러가 발생한다")
    @Test
    void createMoneyNotThousand() {
        String str = "100";
        assertThatThrownBy(() -> new Money(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자가 입력되면 에러가 발생한다")
    @Test
    void createMoneyChar() {
        String str = "10000a";
        assertThatThrownBy(() -> new Money(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈을 입력하면 로또 발행수량이 리턴되는지 확인")
    @Test
    void checkReturnValue() {
        String str = "7000";

        assertThat(new Money(str).getUserlottonum()).isEqualTo(7);
    }
}
