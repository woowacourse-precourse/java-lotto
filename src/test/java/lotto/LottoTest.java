package lotto;

import java.util.Arrays;
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

    @DisplayName("로또 번호에 따라서 올바른 Prize가 나오는지 여부 확인")
    @Test
    public void checkPrize() {
        // Given
        List<Integer> winning = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        Lotto case1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto case2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto case3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9));
        Lotto case4 = new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11));
        Lotto case5 = new Lotto(Arrays.asList(1, 2, 3, 12, 13, 14));
        Lotto case6 = new Lotto(Arrays.asList(1, 2, 10, 11, 12, 13));

        // When
        Prize prize1 = case1.getPrize(winning, bonus);
        Prize prize2 = case2.getPrize(winning, bonus);
        Prize prize3 = case3.getPrize(winning, bonus);
        Prize prize4 = case4.getPrize(winning, bonus);
        Prize prize5 = case5.getPrize(winning, bonus);
        Prize prize6 = case6.getPrize(winning, bonus);

        // Then
        assertThat(prize1).isEqualTo(Prize.FIRST);
        assertThat(prize2).isEqualTo(Prize.SECOND);
        assertThat(prize3).isEqualTo(Prize.THIRD);
        assertThat(prize4).isEqualTo(Prize.FORTH);
        assertThat(prize5).isEqualTo(Prize.FIFTH);
        assertThat(prize6).isEqualTo(Prize.NOTHING);
    }
}
