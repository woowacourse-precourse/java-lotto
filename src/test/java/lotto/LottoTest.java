package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호는 오름차순으로 정렬된다")
    @Test
    void sortNumbers() {
        //given
        List<Integer> numbers = List.of(42,35,45,32,34,21);

        //when
        Lotto lotto = new Lotto(numbers);

        //then
        assertThat(lotto.toString()).isEqualTo("[21, 32, 34, 35, 42, 45]");
    }

    @DisplayName("로또가 생성된다.")
    @Test
    void createLotto() {
        //given

        //when
        Lotto lotto = Lotto.createLotto();

        //then
        assertThat(lotto.getNumbers().isEmpty()).isFalse();
    }
}
