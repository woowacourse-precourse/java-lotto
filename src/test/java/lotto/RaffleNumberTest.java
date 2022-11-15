package lotto;

import lotto.domain.RaffleNumber;
import lotto.ui.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaffleNumberTest {

    @DisplayName("당첨 번호는 쉼표 기준으로 구분한다")
    @Test
    void setWinningNumberTest() {
        String input = "1,2,3,4,5,6";
        RaffleNumber raffleNumber = new RaffleNumber();
        raffleNumber.setWinningNumber(input);
        assertThat(raffleNumber.winningNumber).contains(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("당첨 번호의 범위가 1~45를 벗어난 경우 예외 처리한다")
    @Test
    void invalidRange() {
        assertThatThrownBy(() -> new RaffleNumber().setWinningNumber("0,1,2,3,4,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.WINNING_RANGE_ERROR);
    }

    @DisplayName("당첨 번호가 서로 중복인 경우 예외 처리한다")
    @Test
    void hasSameNumber() {
        assertThatThrownBy(() -> new RaffleNumber().setWinningNumber("1,1,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.WINNING_OVERLAP_ERROR);
    }

    @DisplayName("당첨 번호가 6개가 아닌 경우 예외 처리한다")
    @Test
    void invalidSize() {
        assertThatThrownBy(() -> new RaffleNumber().setWinningNumber("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.WINNING_SIZE_ERROR);
    }

    @DisplayName("보너스 번호가 당첨 번호와 같은 경우 예외 처리한다")
    @Test
    void validateNumber() {
        assertThatThrownBy(() -> new RaffleNumber().validateNumber(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.BONUS_NUMBER_ERROR);
    }
}
