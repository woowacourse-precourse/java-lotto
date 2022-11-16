package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningTicketTest {
    WinningTicket winningTicket = new WinningTicket();

    @Test
    void validate_notNum() {
        String[] wrongInput = new String[]{"1", "2", "3", "4", "5", "a"};

        assertThatThrownBy(() -> winningTicket.validateIsNum(wrongInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력하세요");
    }

    @Test
    void intoNumbers() {
        String[] testSubject = new String[]{"7", "8", "9", "23", "45", "11"};
        List<Integer> result = winningTicket.intoNumbers(testSubject);
        List<Integer> expected = List.of(7, 8, 9, 23, 45, 11);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void adjustUserInput() {
        String testSubject = "3,6,9,12,15,18";
        List<Integer> result = winningTicket.adjustUserInput(testSubject);
        List<Integer> expected = List.of(3, 6, 9, 12, 15, 18);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void validateBonus_notNum() {
        assertThatThrownBy(() -> winningTicket.validateBonusNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력하세요");
    }
}