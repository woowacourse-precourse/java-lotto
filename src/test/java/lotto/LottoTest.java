package lotto;

import camp.nextstep.edu.missionutils.Randoms;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("camp.nextstep.edu.missionutils.Randoms 테스트")
    @Test
    void createRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("발행번호, 당첨번호 일치 개수 세기")
    @Test
    void 발행번호_당첨번호_일치_개수_테스트() {
        Lotto input = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);
        Referee referee = new Referee();
        int count = referee.correctNumberCount(input, numbers);
        assertThat(5).isEqualTo(count);
    }
}
