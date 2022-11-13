package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 범위가 벗어난 숫자가 있으면 예외 발생.")
    @Test
    void 범위_벗어난_로또() {
        // given
        List<Integer> lst = List.of(1, 2, 48);
        // when
        // then
        assertThatThrownBy(() -> new Lotto(lst))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성된 로또 번호 오름차순 정렬 검증")
    @Test
    void 로또_정렬_검증() {
        // given
        List<Integer> lst = Arrays.asList(4, 11,9, 2, 5, 10);
        // when
        Lotto lotto = new Lotto(lst);
        // then
        assertThat(lotto.getNumbersString())
                .isEqualTo(List.of(2, 4, 5, 9, 10, 11).toString());
    }
}
