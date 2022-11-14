package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
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

    @DisplayName("로또 번호 중 1~45 숫자 범위 내에 없는 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoByExceedNumberRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 생성 시 오름차순으로 정렬된다.")
    @Test
    void createLottoByAscendingOrder() {
        Lotto lotto = new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1));
        assertThat(lotto.getNumbers()).isSortedAccordingTo(Comparator.naturalOrder());
    }

    @DisplayName("로또 번호 리스트의 보너스 번호 포함 여부를 알 수 있다.")
    @Test
    void containsBonusNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;
        assertThat(lotto.containsBonusNumber(bonusNumber)).isTrue();
    }

    @DisplayName("로또 번호 리스트를 조회할 수 있다.")
    @Test
    void getLottoNumbers() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> numbers = lotto.getNumbers();
        assertThat(numbers).contains(1, 2, 3, 4, 5, 6);
    }
}
