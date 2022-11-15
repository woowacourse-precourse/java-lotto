package lotto;

import lotto.domain.CompareResult;
import lotto.instance.matchType;
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

    @DisplayName("로또 번호를 잘 가져오는지 확인한다.")
    @Test
    void getLottoNumbers() {
        List<Integer> numbers = List.of(4, 5, 6, 7, 8, 9);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @DisplayName("로또에 번호가 잘 할당되었는지 확인한다.")
    @Test
    void createLotto(){
        List<Integer> numbers = List.of(3, 4, 5, 6, 7, 8);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto).hasFieldOrPropertyWithValue("numbers", numbers);
    }

    @DisplayName("당첨 번호가 주어지면 몇 개가 매치되는지 확인한다.")
    @Test
    void match() {
        List<Integer> numbers = List.of(3, 4, 5, 6, 7, 8);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        CompareResult compareResult =new CompareResult(lotto, winning, bonus);
        assertThat(compareResult.getType()).isEqualTo(matchType.FOUR);
    }

}
