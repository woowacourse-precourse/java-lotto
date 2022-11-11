package lotto.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constants.Message.*;
import static org.assertj.core.api.Assertions.*;

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
    @DisplayName("로또 번호 크기가 5이하면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        // given : 로또 번호 크기가 5이하로 주어진다.
        final List<Integer> NOT_ENOUGH_LOTTO_SIZE = List.of(1, 2, 3, 4, 5);

        // when : 위 번호들로 로또 객체가 생성될 때
        // then : 유효하지 않은 로또 번호 크기이기에 에러 메세지를 출력한다.
        assertThatThrownBy(() -> new Lotto(NOT_ENOUGH_LOTTO_SIZE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_INVALID_LOTTO_LENGTH);
    }

    @DisplayName("로또 번호가 모두 1~45 사이가 아니라면 예외가 발생한다.")
    @Test
    void createLottoByInvalidNumberRange() {
        // given : 1~45 사이의 값이 아닌 요소가 존재하는 로또 번호가 주어진다.
        final List<Integer> INVALID_LOTTO_NUMBER_RANGE = List.of(0, 1, 2, 3, 4, 5);

        // when : 위 번호들로 로또 객체가 생성될 때
        // then : 유효하지 않은 로또 번호 요소이기데 에러 메세지를 출력한다.
        assertThatThrownBy(() -> new Lotto(INVALID_LOTTO_NUMBER_RANGE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_HAS_INVALID_LOTTO_NUMBER_VALUE);
    }

    @DisplayName("로또 번호는 중복없이 6개의 숫자로써 모두 1~45 사이의 숫자라면 알맞은 로또 번호이다.")
    @Test
    void createValidLottoNumber() {
        // given : 알맞은 로또 번호가 주어진다.
        final List<Integer> VALID_LOTTO_NUMBER = List.of(1, 5, 2, 9, 44, 39);

        // when : 위 번호들로 알맞은 로또 객체가 생성될 때
        // then : 어떠한 에러도 발생하면 안된다.
        assertThatNoException().isThrownBy(() -> new Lotto(VALID_LOTTO_NUMBER));
    }
}
