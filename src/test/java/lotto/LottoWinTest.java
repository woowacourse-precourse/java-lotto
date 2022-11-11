package lotto;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinTest {

    @DisplayName("중복된 보너스 번호가 들어오면 에러가 발생한다")
    @Test
    void duplicatedBonusNumber() {
        assertThatThrownBy(() -> new LottoWin(List.of(List.of(1, 2, 3, 4, 5, 6)), List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("1~45 범위에서 벗어난 보너스 번호가 들어오면 에러가 발생한다")
    @Test
    void outOfBoundBonusNumber() {
        assertThatThrownBy(() -> new LottoWin(List.of(List.of(1, 2, 3, 4, 5, 6)), List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWin(List.of(List.of(1, 2, 3, 4, 5, 6)), List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("1등 확인")
    @Test
    void firstPrize() {
        LottoWin lottoPrizes = new LottoWin(List.of(List.of(1, 2, 3, 4, 5, 6)), List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(lottoPrizes.getPrizesMap()).contains(entry("1st", 1));

    }
    @DisplayName("1등 2명 확인")
    @Test
    void twoFirstPrize() {
        LottoWin lottoPrizes = new LottoWin(
                List.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6)),
                List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(lottoPrizes.getPrizesMap()).contains(entry("1st", 2));
    }
    @DisplayName("2등 확인")
    @Test
    void secondPrize() {
        LottoWin lottoPrizes = new LottoWin(
                List.of(List.of(1, 2, 3, 4, 5, 7), List.of(1, 2, 3, 4, 5, 6)),
                List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(lottoPrizes.getPrizesMap()).contains(entry("2nd", 1));
    }
    @DisplayName("3등 확인")
    @Test
    void thirdPrize() {
        LottoWin lottoPrizes = new LottoWin(
                List.of(List.of(1, 2, 3, 4, 5, 8), List.of(1, 2, 3, 4, 5, 9)),
                List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(lottoPrizes.getPrizesMap()).contains(entry("3rd", 2));
    }
    @DisplayName("4등 확인")
    @Test
    void fourthPrize() {
        LottoWin lottoPrizes = new LottoWin(
                List.of(List.of(1, 2, 3, 4, 9, 10), List.of(1, 2, 3, 4, 7, 9)),
                List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(lottoPrizes.getPrizesMap()).contains(entry("4th", 2));
    }
    @DisplayName("5등 확인")
    @Test
    void fifthPrize() {
        LottoWin lottoPrizes = new LottoWin(
                List.of(List.of(1, 2, 3, 8, 9, 10), List.of(3, 4, 5, 7, 8, 9)),
                List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(lottoPrizes.getPrizesMap()).contains(entry("5th", 2));
    }
    @DisplayName("중복된 보너스 번호가 들어오면 에러 메세지가 출력되고 에러가 발생한다.")
    @Test
    void duplicatedBonusNumberForPrint() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThatThrownBy(() -> new LottoWin(List.of(List.of(1, 2, 3, 4, 5, 6)), List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(out.toString()).isEqualTo("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }
    @DisplayName("1~45 범위에서 벗어난 보너스 번호가 들어오면 메세지가 출력되고 에러가 발생한다")
    @Test
    void outOfBoundBonusNumberForPrint() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThatThrownBy(() -> new LottoWin(List.of(List.of(1, 2, 3, 4, 5, 6)), List.of(1, 2, 3, 4, 5, 6), 47))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(out.toString()).isEqualTo("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
    }
}
