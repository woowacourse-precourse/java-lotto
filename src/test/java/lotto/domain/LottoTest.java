package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호의 개수가 정해진 개수보다 많으면 예외가 발생한다.")
    @Test
    void should_ThrowIllegalArgumentException_When_CreateByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 규칙 범위를 벗어나면 예외가 발생한다.")
    @Test
    void should_ThrowIllegalArgumentException_When_HaveNumberInOuterRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 46, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void should_ThrowIllegalArgumentException_When_HaveDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
