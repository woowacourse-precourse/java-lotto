package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilsTest {
    @DisplayName("로또 번호가 1 ~ 45 범위를 넘으면 에러 발생")
    @Test
    void 로또_번호_유효_범위_넘으면_에러() {
        List<Integer> numbers = List.of(1, 2, 3, 48, 5, 6);
        assertThatThrownBy(() -> Utils.validateLottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6개가 아니면 에러 발생")
    @Test
    void 로또_번호_6개_아니면_에러() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> Utils.validateLottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤 숫자 6개 확인")
    @Test
    void 랜덤_숫자_6개() {
        List<Integer> numbers = Utils.pickUnique6Numbers();
        Set<Integer> check = new HashSet<>(numbers);
        assertThat(check.size()).isEqualTo(6);
    }
}