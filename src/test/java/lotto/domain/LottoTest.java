package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @DisplayName("맞춘 번호의 개수를 올바르게 리턴")
    @Test
    void compareNumbers_case1() {
        List<Integer> winningNumber = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());
        WinningLotto winningLotto = new WinningLotto(winningNumber, 7);
        List<Integer> myNumber = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());

        assertThat(winningLotto.compareNumbers(myNumber)).isEqualTo(6);
    }
}
