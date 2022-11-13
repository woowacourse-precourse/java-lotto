package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 중복 검사 테스트")
    @Test
    void 로또_번호_중복_검사() {

        Domain domain = new Domain();
        List<String> input = Arrays.asList("1", "2", "3", "4", "5", "5");

        Assertions.assertThrows(RuntimeException.class, () -> {
            domain.validateOverlapping(input);
        });
    }
    @DisplayName("로또 번호 중복 검사 테스트: 중복 없을 때")
    @Test
    void 로또_번호_중복_검사2() {
        Domain domain = new Domain();
        List<String> input = Arrays.asList("1", "2", "3", "4", "5", "6");

        domain.validateOverlapping(input);
    }
}