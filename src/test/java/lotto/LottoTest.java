package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    public static Lotto lotto;

    @BeforeAll
    static void setLotto() {
        try {
            lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        } catch (Exception e) {
        }
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하여 일치하는 숫자의 개수를 확인한다.")
    @Test
    void compareWithWinNumbers() {
        try {
            assertThat(lotto.compareWithWinNumber(new WinNumber("42,44,45,6,7,8"))).isEqualTo(1);
            assertThat(lotto.compareWithWinNumber(new WinNumber("3,4,5,6,7,8"))).isEqualTo(4);
            assertThat(lotto.compareWithWinNumber(new WinNumber("33,34,35,36,37,38"))).isEqualTo(0);
        } catch (Exception e) {
        }
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하여 일치하는 숫자의 개수를 확인한다.")
    @Test
    void compareWithBonusNumber() {
        try {
            WinNumber winNumbers = new WinNumber("6,7,8,9,10,11");
            assertThat(lotto.compareWithBonusNumber(new BonusNumber("4", winNumbers))).isEqualTo(true);
            assertThat(lotto.compareWithBonusNumber(new BonusNumber("12", winNumbers))).isEqualTo(false);
        } catch (Exception e) {
        }
    }
}
