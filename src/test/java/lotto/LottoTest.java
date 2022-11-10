package lotto;

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
    @DisplayName("로또 번호의 개수가 6개가 안되면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성된 로또가 오름차순으로 정렬이 되어있는지 확인")
    @Test
    void isSorted() {
        List<Integer> unSorted = List.of(5, 3, 2, 1, 4, 6);

        Lotto lotto = new Lotto(unSorted);

        assertThat(List.of(1, 2, 3, 4, 5, 6)).isEqualTo(lotto.getNumbers());
    }

    @DisplayName("두 개의 로또를 비교하여 일치하는 번호 개수를 반환하는지 확인")
    @Test
    void compare() {
        Lotto buy = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto equalFour = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        Lotto equalSix = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(buy.compare(equalFour)).isEqualTo(4);
        assertThat(buy.compare(equalSix)).isEqualTo(6);
    }

    @DisplayName("보너스 번호 확인이 제대로 되는지 검증")
    @Test
    void compareBonus() {
        int containedBonus = 3;
        int unContainedBonus = 6;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));

        assertThat(lotto.isValidBonus(containedBonus)).isTrue();
        assertThat(lotto.isValidBonus(unContainedBonus)).isFalse();
    }
}
