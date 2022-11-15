package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
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

    @DisplayName("정답 로또와 랜덤 로또 비교 테스트")
    @Test
    void countHitNumberTest() {
        Assertions.assertThat(new Lotto(Arrays.asList(1,2,3,4,5,6))
                .countHitNumber(new Lotto(Arrays.asList(1,2,3,4,5,6)))).isEqualTo(6);
    }

    @DisplayName("로또 숫자의 범위 테스트")
    @Test
    void validateNumbersRangeTest() {
        Assertions.assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
