package lotto.result;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCompareTest {

    @DisplayName("중복된 보너스 번호가 들어오면 에러가 발생한다")
    @Test
    void duplicatedBonusNumber() {
        assertThatThrownBy(() -> new LottoCompare(List.of(List.of(1, 2, 3, 4, 5, 6)), List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("1~45 범위에서 벗어난 보너스 번호가 들어오면 에러가 발생한다")
    @Test
    void outOfBoundBonusNumber() {
        assertThatThrownBy(() -> new LottoCompare(List.of(List.of(1, 2, 3, 4, 5, 6)), List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoCompare(List.of(List.of(1, 2, 3, 4, 5, 6)), List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("1등 확인")
    @Test
    void firstPrize() {
        LottoCompare lottoPrizes = new LottoCompare(List.of(List.of(1, 2, 3, 4, 5, 6)), List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(lottoPrizes.getPrizesMap()).contains(entry("FIRST", 1));

    }
    @DisplayName("1등 2명 확인")
    @Test
    void twoFirstPrize() {
        LottoCompare lottoPrizes = new LottoCompare(
                List.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6)),
                List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(lottoPrizes.getPrizesMap()).contains(entry("FIRST", 2));
    }
    @DisplayName("2등 확인")
    @Test
    void secondPrize() {
        LottoCompare lottoPrizes = new LottoCompare(
                List.of(List.of(1, 2, 3, 4, 5, 7), List.of(1, 2, 3, 4, 5, 6)),
                List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(lottoPrizes.getPrizesMap()).contains(entry("SECOND", 1));
    }
    @DisplayName("3등 확인")
    @Test
    void thirdPrize() {
        LottoCompare lottoPrizes = new LottoCompare(
                List.of(List.of(1, 2, 3, 4, 5, 8), List.of(1, 2, 3, 4, 5, 9)),
                List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(lottoPrizes.getPrizesMap()).contains(entry("THIRD", 2));
    }
    @DisplayName("4등 확인")
    @Test
    void fourthPrize() {
        LottoCompare lottoPrizes = new LottoCompare(
                List.of(List.of(1, 2, 3, 4, 9, 10), List.of(1, 2, 3, 4, 7, 9)),
                List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(lottoPrizes.getPrizesMap()).contains(entry("FOURTH", 2));
    }
    @DisplayName("5등 확인")
    @Test
    void fifthPrize() {
        LottoCompare lottoPrizes = new LottoCompare(
                List.of(List.of(1, 2, 3, 8, 9, 10), List.of(3, 4, 5, 7, 8, 9)),
                List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(lottoPrizes.getPrizesMap()).contains(entry("FIFTH", 2));
    }
    @DisplayName("중복된 보너스 번호가 들어오면 에러 메세지가 출력되고 에러가 발생한다.")
    @Test
    void duplicatedBonusNumberForPrint() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThatThrownBy(() -> new LottoCompare(List.of(List.of(1, 2, 3, 4, 5, 6)), List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(out.toString()).isEqualTo("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }
    @DisplayName("1~45 범위에서 벗어난 보너스 번호가 들어오면 메세지가 출력되고 에러가 발생한다")
    @Test
    void outOfBoundBonusNumberForPrint() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThatThrownBy(() -> new LottoCompare(List.of(List.of(1, 2, 3, 4, 5, 6)), List.of(1, 2, 3, 4, 5, 6), 47))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(out.toString()).isEqualTo("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
    }
}
