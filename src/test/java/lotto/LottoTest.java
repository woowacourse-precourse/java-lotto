package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("로또의 길이가 6보다 작을 때")
    @Test
    void lessThan6() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 오름차순으로 정렬하여 보여줌")
    @Test
    void sortLottoNumber() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        String actual = lotto.toString();
        assertThat(actual).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("보너스 번호는 로또 번호와 중복될 수 없다")
    @Test
    void duplicatedBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lotto.isDuplicateBonusNumber(6)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("등수 확인")
    @ParameterizedTest(name = "{displayName} : {6}")
    @CsvSource({"1, 2, 3, 4, 5, 6, 1", "1, 2, 3, 4, 5, 7, 2", "1, 2, 3, 4, 5, 8, 3", "1, 2, 3, 4, 8, 9, 4",
            "1, 2, 3, 8, 9, 10, 5", "1, 2, 11, 12, 13, 14, 0", "1, 11, 12, 13, 14, 15, 0", "11, 12, 13, 14, 15, 16, 0"})
    void checkRanking(int n1, int n2, int n3, int n4, int n5, int n6, int expected) {
        List<Integer> luckyNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> integers = List.of(n1, n2, n3, n4, n5, n6);
        Lotto lucky = new Lotto(luckyNumbers);
        Lotto target = new Lotto(integers);
        int actual = lucky.getRanking(target, 7);
        assertThat(actual).isEqualTo(expected);
    }
}
