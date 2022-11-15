package domain;

import lotto.Lotto;
import lotto.WinningTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningTicketTest {

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복일 때 예외가 발생한다.")
    void checkBonusNumber() {
        assertThatThrownBy(() -> new WinningTicket(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1부터 45사이의 범위를 벗어났을 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void checkWinningTicketRange(int bonus) {
        assertThatThrownBy(() -> new WinningTicket(List.of(1, 2, 3, 4, 5, 6), bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("발행한 로또와 비교")
    void match() {
        WinningTicket winningTicket = new WinningTicket(List.of(1, 2, 3, 4, 5, 6), 7);

        Lotto lotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        assertThat(lotto.countMatchingNumbers(winningTicket)).isEqualTo(0);
    }
}
