package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningTicketTest {

    @Test
    @DisplayName("당첨 번호의 숫자 범위가 1 ~ 45가 벗어나면 IllegalArgumentException 발생한다.")
    void 당첨번호범위_벗어나면_예외발생() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new lotto.domain.WinningTicket(Arrays.asList(1, 2, 3, 4, 5, 46), 7));
    }

    @Test
    @DisplayName("당첨 번호의 숫자 리스트 길이가 6이 아니면 IllegalArgumentException 발생한다.")
    void 당첨번호리스트_길이가_6을_벗어나면_예외발생() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new lotto.domain.WinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 8));
    }

    @Test
    @DisplayName("당첨번호 리스트에 중복이 존재하면 IllegalArgumentException 발생한다.")
    void 당첨번호리스트_중복있으면_예외발생() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new lotto.domain.WinningTicket(Arrays.asList(1, 2, 3, 4, 6, 6), 8));
    }

    @Test
    @DisplayName("보너스 번호가 당첨번호 리스트에 존재하면 IllegalArgumentException 발생한다.")
    void 보너스번호_중복이면_예외발생() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new lotto.domain.WinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 6));
    }

    @Test
    @DisplayName("보너스 번호가 당첨번호 리스트에 존재하면 IllegalArgumentException 발생한다.")
    void 보너스번호_1에서45_벗어나면_예외발생() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new lotto.domain.WinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 46));
    }
}
