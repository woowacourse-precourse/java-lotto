package lotto;

import domain.Lotto;
import domain.NumberGenerator;
import domain.WinningNumber;
import domain.Winnings;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("NumberGenerator 테스트")
    @Test
    void createLottoNumber() {
        Lotto lottoNumber = NumberGenerator.createLottoNumber();
        List<Integer> numbers = lottoNumber.getNumbers();
        for (int tst = 0; tst < 10000000; ++tst) {
            for (int i = 1; i < numbers.size(); ++i) {
                if (numbers.get(i) < numbers.get(i - 1)) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    @DisplayName("count() 테스트")
    @Test
    void countTest() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(lotto.count(winningNumber)).isEqualTo(5);
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.count(winningNumber)).isEqualTo(6);
        lotto = new Lotto(List.of(7, 2, 3, 8, 5, 6));
        assertThat(lotto.count(winningNumber)).isEqualTo(4);
        lotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        assertThat(lotto.count(winningNumber)).isEqualTo(3);
        lotto = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        assertThat(lotto.count(winningNumber)).isEqualTo(0);
    }

    @DisplayName("compareBonusNumber() 테스트")
    @Test
    void compareBonusNumberTest() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(lotto.compareBonusNumber(winningNumber)).isEqualTo(true);
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.compareBonusNumber(winningNumber)).isEqualTo(false);
    }

    @DisplayName("toString() 테스트")
    @Test
    void toStringTest() {
        Lotto lotto = new Lotto(List.of(4, 7, 5, 3, 2, 1));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 7]");
        lotto = new Lotto(List.of(31, 33, 35, 37, 39, 41));
        assertThat(lotto.toString()).isEqualTo("[31, 33, 35, 37, 39, 41]");
    }

    @DisplayName("compare() 테스트")
    @Test
    void compareTest() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.compare(winningNumber)).isEqualTo(Winnings.FIRST);
        lotto = new Lotto(List.of(1, 2, 3, 4, 6, 7));
        assertThat(lotto.compare(winningNumber)).isEqualTo(Winnings.SECOND);
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 41));
        assertThat(lotto.compare(winningNumber)).isEqualTo(Winnings.THIRD);
        lotto = new Lotto(List.of(1, 2, 3, 4, 31, 33));
        assertThat(lotto.compare(winningNumber)).isEqualTo(Winnings.FOURTH);
        lotto = new Lotto(List.of(1, 31, 36, 21, 5, 6));
        assertThat(lotto.compare(winningNumber)).isEqualTo(Winnings.FIFTH);
        lotto = new Lotto(List.of(1, 31, 32, 33, 34, 35));
        assertThat(lotto.compare(winningNumber)).isEqualTo(Winnings.NONE);
    }
}
