package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 로또 숫자는 중복되어선 안됩니다.");
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호 중 1개라도 1부터 45 사이의 범위를 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber(){
        //given
        List<Integer> hasZeroList = List.of(0, 1 ,2, 3, 4, 5);
        List<Integer> hasOutOfMinimumList = List.of(1, -5 ,2, 3, 4, 5);
        List<Integer> hasOutOfMaximumList = List.of(1, 46 ,2, 3, 4, 5);

        //when, then
        assertThatThrownBy(() -> new Lotto(hasZeroList))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 로또 숫자의 범위는 1부터 45 사이의 숫자여야 합니다.");
        assertThatThrownBy(() -> new Lotto(hasOutOfMinimumList))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 로또 숫자의 범위는 1부터 45 사이의 숫자여야 합니다.");
        assertThatThrownBy(() -> new Lotto(hasOutOfMaximumList))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 로또 숫자의 범위는 1부터 45 사이의 숫자여야 합니다.");
    }
}
