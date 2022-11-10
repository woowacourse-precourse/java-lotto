package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Nested
    class duplicateNumberTest {
        @Test
        void createLottoByDuplicatedNumber() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void createWinningLottoByDuplicatedNumber() {
            assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 2))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("범위를 벗어난 번호가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 4, 2 ,3, 50, 11)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위를 벗어날 시 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfRange() {
        assertThatThrownBy(() -> Lotto.setBonusNumber(55))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 없이 로또 번호가 생성되는지 확인한다.")
    @Test
    void createLottosWithNoExcpetion() {
        assertDoesNotThrow(() -> {
            Lotto lotto = Lotto.generate();
            List<Integer> numbers = lotto.getNumbers();
        });
    }

    @DisplayName("올바른 당첨 내역을 반환하는지 확인한다.")
    @Nested
    class checkWinningCTest {
        @BeforeEach
        void initWinningLotto() {
            Lotto winningLotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        }

        @Test
        void winFirstPlace() {
            Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        }
    }
}
