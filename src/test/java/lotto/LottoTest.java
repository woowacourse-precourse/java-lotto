package lotto;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Result;
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
    @DisplayName("로또 번호에 1부터 45까지의 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 보너스 번호를 입력 받았을 때 일치하는 결과가 잘 반환되는지 테스트한다.")
    @Test
    void generateResult() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);
        Bonus bonus = new Bonus(7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        //when
        Result result = lotto.generateResult(winningLotto, bonus);
        //then
        assertThat(result.getMatchCount()).isEqualTo(5);
        assertThat(result.isBonus()).isTrue();
    }
}
