package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void checkWinning3(){
        List<Integer> winningNUmbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        int rank = lotto.checkWinning(winningNUmbers, bonusNumber);
        int result = 3;
        assertThat(rank).isEqualTo(result);
    }

    @Test
    void checkWinning2(){
        List<Integer> winningNUmbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        int rank = lotto.checkWinning(winningNUmbers, bonusNumber);
        int result = 2;
        assertThat(rank).isEqualTo(result);
    }

    @Test
    void checkWinning1(){
        List<Integer> winningNUmbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int rank = lotto.checkWinning(winningNUmbers, bonusNumber);
        int result = 1;
        assertThat(rank).isEqualTo(result);
    }


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

    @DisplayName("숫자가 1 ~ 45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
}
