package lotto;

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

    @DisplayName("로또 번호에 1-45범위가 아닌 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOufOfLottoBoundNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 46, 4, 5, 8)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 다른 로또 번호를 비교해 일치하는 수 개수를 리턴한다.")
    @Test
    void compareWithOtherLotto() {
        //given
        Lotto winningLotto = new Lotto(Arrays.asList(2,5,9,43,27,32));

        //when
        Lotto correct4Lotto = new Lotto(Arrays.asList(2,5,9,4,25,32));  //4개일치
        Lotto correct5Lotto = new Lotto(Arrays.asList(2, 9, 22, 43, 32, 27));  // 5개일치

        //then
        assertThat(winningLotto.compare(correct4Lotto)).isEqualTo(4);
        assertThat(winningLotto.compare(correct5Lotto)).isEqualTo(5);
    }
}
