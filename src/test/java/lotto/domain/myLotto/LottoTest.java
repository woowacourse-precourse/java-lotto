package lotto.domain.myLotto;

import lotto.domain.myLotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("예외처리확인 - 로또 번호의 개수 6개 이상 입력")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외처리확인 - 로또 번호의 개수 6개 이하 입력")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외처리확인 - 중복된 숫자 존재 확인")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외처리확인 - 올바른 범위의 숫자인지")
    @Test
    void validateInputNumberIsBetween(){
        assertThatThrownBy(()-> new Lotto(List.of(100, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
