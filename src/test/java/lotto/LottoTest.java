package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningPrize;
import lotto.utils.ErrorMessage;
import org.junit.jupiter.api.*;

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

    @DisplayName("1보다 작거나 45보다 큰 숫자가 포함되면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumbers() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 3, 0, 46, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBERS_OUT_OF_RANGE);
    }

    @DisplayName("로또 번호와 보너스 번호를 비교하는 기능")
    @Test
    void createLottoContainsBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertThat(lotto.contains(bonusNumber)).isTrue();
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하는 기능")
    @Test
    void createLottoContains3WinningNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 3, 5 ,7, 9, 11));

        assertThat(lotto.countSameNumbers(winningLotto)).isEqualTo(3);
    }

    @DisplayName("로또에 당첨됐을 때")
    @Nested
    class WhenWinningLottery {
        Lotto winningLotto;
        int bonusNumber = 7;

        @BeforeEach
        void setUp() {
            winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        }

        @DisplayName("숫자 6개가 모두 일치하면 1등")
        @Test
        void createFirstPlaceLotto() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

            assertThat(lotto.getWinningPrize(winningLotto, bonusNumber)).isEqualTo(WinningPrize.FIRST_PLACE);
        }

        @DisplayName("숫자 5개가 일치하고 보너스 숫자가 일치하면 2등")
        @Test
        void createSecondPlaceLotto() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

            assertThat(lotto.getWinningPrize(winningLotto, bonusNumber)).isEqualTo(WinningPrize.SECOND_PLACE);
        }

        @DisplayName("숫자 5개가 일치하고 보너스 숫자가 일치하지 않으면 3등")
        @Test
        void createThirdPlaceLotto() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

            assertThat(lotto.getWinningPrize(winningLotto, bonusNumber)).isEqualTo(WinningPrize.THIRD_PLACE);
        }

        @DisplayName("숫자 4개가 일치하면 4등")
        @Test
        void createFourthPlaceLotto() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));

            assertThat(lotto.getWinningPrize(winningLotto, bonusNumber)).isEqualTo(WinningPrize.FOURTH_PLACE);
        }

        @DisplayName("숫자 3개가 일치하면 5등")
        @Test
        void createFifthPlaceLotto() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

            assertThat(lotto.getWinningPrize(winningLotto, bonusNumber)).isEqualTo(WinningPrize.FIFTH_PLACE);
        }

        @DisplayName("숫자가 3개 이상 일치하지 않으면 꼴등")
        @Test
        void createLastPlaceLotto() {
            Lotto lotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));

            assertThat(lotto.getWinningPrize(winningLotto, bonusNumber)).isEqualTo(WinningPrize.LAST_PLACE);
        }
    }
}
