package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 번호에 없는 숫자를 찾으면 False를 반환한다.")
    @Test
    void checkNumberNotInLotto() {
        assertFalse(new Lotto(List.of(1, 2, 3, 4, 5, 6)).hasNumber(7));
    }

    @DisplayName("로또 번호에 없는 숫자를 찾으면 True를 반환한다.")
    @Test
    void checkNumberInLotto() {
        assertTrue(new Lotto(List.of(1, 2, 3, 4, 5, 6)).hasNumber(1));
    }

    @DisplayName("같은 번호를 가지는 로또는 오름차순으로 정렬된 번호 문자열이 같다.")
    @Test
    void checkEqualNumberLotto() {
        assertThat(new Lotto(List.of(1, 3, 5, 2, 4, 6)).sortedNumbersToString()).isEqualTo(
            new Lotto(List.of(6, 5, 4, 1, 2, 3)).sortedNumbersToString());
    }
}
