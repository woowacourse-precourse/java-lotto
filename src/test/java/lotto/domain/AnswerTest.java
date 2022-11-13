package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AnswerTest {
    private Answer answer;

    @BeforeEach
    void setUp() {
        answer = new Answer();
    }

    @DisplayName("중복된 번호가 있으면 예외가 발생한다.")
    @Test
    void setWinningNumbersByDuplicatedNumber() {
        assertThatThrownBy(() -> answer.setWinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 아닌 숫자가 있으면 예외가 발생한다.")
    @Test
    void setWinningNumbersByContainedNotLottoNumber() {
        assertThatThrownBy(() -> answer.setWinningNumbers(List.of(1,2,3,4,5,46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void setWinningNumbersByUnderSize() {
        assertThatThrownBy(() -> answer.setWinningNumbers(List.of(1,2,3,4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있으면 예외가 발생한다.")
    @Test
    void setBonusNumberByContainedWinningNumbers() {
        answer.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> answer.setBonusNumber(1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}