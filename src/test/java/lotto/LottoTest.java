package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {

    @Test
    @DisplayName("주어진 수만큼 로또를 생성하는지 테스트")
    void generateLotteriesTest() {
        assertThat(Lotto.generateLotteries(6).size()).isEqualTo(6);
    }

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

    @DisplayName("로또 번호를 오름차순 문자열로 변환한다.")
    @Test
    void toStringTest() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("로또 당첨 결과를 비교하고 LottoResult를 반환한다.")
    @Test
    void compareWinningNumbersTest() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).compareWinningNumbers(List.of(1, 2, 3, 7, 8, 9), 10)).isEqualTo(LottoResult.Match3);
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).compareWinningNumbers(List.of(1, 2, 3, 7, 8, 9), 4)).isEqualTo(LottoResult.Match3);
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).compareWinningNumbers(List.of(1, 2, 3, 4, 8, 9), 10)).isEqualTo(LottoResult.Match4);
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).compareWinningNumbers(List.of(1, 2, 3, 4, 8, 9), 5)).isEqualTo(LottoResult.Match4);
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).compareWinningNumbers(List.of(1, 2, 3, 4, 5, 9), 10)).isEqualTo(LottoResult.Match5);
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).compareWinningNumbers(List.of(1, 2, 3, 4, 5, 9), 6)).isEqualTo(LottoResult.Match5AndBonus);
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).compareWinningNumbers(List.of(1, 2, 3, 4, 5, 6), 10)).isEqualTo(LottoResult.Match6);
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).compareWinningNumbers(List.of(11, 12, 13, 14, 15, 16), 10)).isEqualTo(LottoResult.None);
    }

}
