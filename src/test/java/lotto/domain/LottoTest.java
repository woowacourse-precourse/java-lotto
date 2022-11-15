package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("번호가 1 ~ 45 범위를 벗어나면 예외가 발생한다")
    @Test
    void createLottoOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 ~ 45 사이의 숫자만 가능합니다.");
    }

    @DisplayName("로또에 해당하는 숫자가 있느면 true를 반환한다")
    @Test
    void checkMatchedNumber() {
        // given
        int checkNumber = 3;
        boolean expected = true;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean matchedFlag = lotto.hasMatchedNumber(checkNumber);

        // then
        assertThat(matchedFlag).isEqualTo(expected);
    }

    @DisplayName("로또에 해당하는 숫자가 없으면 false를 반환한다")
    @Test
    void checkUnmatchedNumber() {
        // given
        int checkNumber = 45;
        boolean expected = false;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean matchedFlag = lotto.hasMatchedNumber(checkNumber);

        // then
        assertThat(matchedFlag).isEqualTo(expected);
    }
}
