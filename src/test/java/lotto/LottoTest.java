package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("로또 번호가 1부터 45사이가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 65)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외 문구가 출력된다.")
    @Test
    void printCommentLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호 개수는 6개여야 합니다.");
    }

    @DisplayName("로또 번호를 오름차순으로 정렬한다.")
    @Test
    void sortLottoNumbers() {
        Lotto lotto = new Lotto(List.of(40, 30, 7, 4, 5, 8));
        assertThat(lotto.getLotto()).containsExactly(4, 5, 7, 8, 30, 40);
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,4,5,6,40,FIRST", "1,2,3,4,5,9,6,SECOND", "1,2,3,4,5,9,40,THIRD", "1,2,3,4,7,8,9,FOURTH",
            "1,2,3,9,8,7,10,FIFTH", "1,11,12,13,14,15,16,NOTHING"})
    void getRankOfLotto(int number1, int number2, int number3, int number4, int number5, int number6, int bonus, String rank) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.rankOfLotto(List.of(number1, number2, number3, number4, number5, number6), bonus).toString())
                .isEqualTo(rank);
    }
}
