package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {


    @DisplayName("두 로또를 비교하여 일치 한 숫자개수를 반환한다.")
    @Test
    void count_match_numbers_two_lotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto zeroMatchLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        assertThat(lotto.countMathNumbers(zeroMatchLotto)).isEqualTo(0);

        Lotto allMatchLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.countMathNumbers(allMatchLotto)).isEqualTo(6);

        Lotto threeMatchLotto = new Lotto(List.of(4, 6, 11, 12, 13, 5));
        assertThat(lotto.countMathNumbers(threeMatchLotto)).isEqualTo(3);
    }

    @DisplayName("번호 포함 여부")
    @Test
    void contains_number() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.containsNumber(7)).isFalse();

        assertThat(lotto.containsNumber(1)).isTrue();
    }

    @DisplayName("로또 번호 오름차순으로 출력")
    @Test
    void print_sorted_lotto() {
        Lotto lotto = new Lotto(List.of(6, 3, 5, 1, 2, 8));
        List<Integer> sortedList = List.of(1, 2, 3, 5, 6, 8);
        assertThat(lotto.toString()).isEqualTo(sortedList.toString());
    }

    @DisplayName("당첨 번호와 비교하여 로또 상태 반환")
    @Test
    void match_target_lotto() {
        Lotto targetLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto fiveMatchLotto = new Lotto(List.of(6, 3, 5, 1, 2, 8));
        int notMatchBonusNumber = 9;
        assertThat(fiveMatchLotto.matchLotto(targetLotto, notMatchBonusNumber)).isEqualTo(LottoStatus.MATCH_FIVE);
        int MatchBonusNumber = 8;
        assertThat(fiveMatchLotto.matchLotto(targetLotto, MatchBonusNumber)).isEqualTo(
                LottoStatus.MATCH_FIVE_ADD_BONUS);

        Lotto twoMathLotto = new Lotto(List.of(1, 2, 7, 8, 11, 10));
        assertThat(twoMathLotto.matchLotto(targetLotto, notMatchBonusNumber)).isEqualTo(LottoStatus.MATCH_UNSATISFIED);
    }


    @DisplayName("유효하지 않는 로또 번호 예외처리")
    @Test
    void is_valid_number() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5))).isInstanceOf(IllegalArgumentException.class);
    }
}
