package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45가 아닐 때 예외가 발생한다.")
    @Test
    void createLottoNotRangeNumber() {
        assertThatThrownBy(()-> new Lotto(List.of(1,2,33,46,47,12)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("toString 사용 시 List 형태로 반환")
    @Test
    void toStringTest() {
        assertThat(new Lotto(List.of(12,13,22,34,35,45)).toString())
                .isEqualTo("[12, 13, 22, 34, 35, 45]");
    }

    @DisplayName("로또 번호 정상일 시, 에러를 던지지 않음")
    @Test
    void createValidLottoNumber() {
        assertThatCode(() -> new Lotto(List.of(2,3,4,43,44,45)))
                .doesNotThrowAnyException();
    }
}
