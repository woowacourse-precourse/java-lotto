package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.entity.Lotto;
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

    // 아래에 추가 테스트 작성 가능

    @DisplayName("로또 번호가 정해진 시작 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfStartRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 정해진 끝 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfEndRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 중복되는 번호를 가지고 있으면 true 반환한다.")
    @Test
    void containsDuplicateNumber() {
        //given
        int number = 1;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        boolean result = lotto.contains(number);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("로또 번호와 중복되는 번호 가지고 있지 않으면 false 반환한다.")
    @Test
    void containsNotDuplicateNumber() {
        //given
        int number = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        boolean result = lotto.contains(number);

        //then
        assertThat(result).isFalse();
    }

}
