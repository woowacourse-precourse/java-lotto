package lotto;

import lotto.model.Lotto;
import lotto.util.Validate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void NULL값_체크() {
        assertThatThrownBy(() -> Validate.isNull(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_체크() {
        assertThatThrownBy(() -> Validate.isNumber("123j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_리스트_체크() {
        assertThatThrownBy(() -> Validate.isNumbers(List.of("1","2","j")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이_체크() {
        assertThatThrownBy(() -> Validate.length(List.of(1,2,3,4),3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복_체크() {
        assertThatThrownBy(() -> Validate.duplication(List.of(1,2,3,4,4)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
