package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoNumberTest {

    @DisplayName("로또 번호가 1-45의 수가 아니면 예외가 발생한다.")
    @Test
    void createOutOfRange() {
        assertThatThrownBy(() -> LottoNumber.generateFromRawValue(897))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1-45의 수이면 정상 생성한다")
    @Test
    void createInOfRange() {
        assertThat(LottoNumber.generateFromRawValue(41))
                .isInstanceOf(LottoNumber.class);
    }
}