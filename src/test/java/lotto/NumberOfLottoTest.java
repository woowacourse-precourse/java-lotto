package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfLottoTest {
    @DisplayName("금액에 맞게 로또 개수가 발생되는지 확인한다.")
    @Test
    void checkNumberOfLotto() {
        assertThat(new NumberOfLotto(123_000).getNumberOfLotto()).isEqualTo(123);
    }

    @DisplayName("금액에 맞게 로또 개수가 발생되는지 확인한다.")
    @Test
    void checkNumberOfLotto2() {
        assertThat(new NumberOfLotto(100_000_000).getNumberOfLotto()).isEqualTo(100_000);
    }
}
