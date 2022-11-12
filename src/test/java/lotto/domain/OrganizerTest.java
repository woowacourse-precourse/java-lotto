package lotto.domain;

import java.util.List;
import lotto.exception.ExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OrganizerTest {
    @Test
    @DisplayName("입력 문자열을 숫자 리스트로 변환한다.")
    void getNumberListFromStringInput() {
        Organizer organizer = new Organizer();
        assertThat(organizer.getWinningNumbersFromInput("1,2,3,4,5,6"))
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("입력 문자열에 띄어쓰기가 존재해도 숫자 리스트로 변환한다.")
    void getNumberListFromStringInputWithSpaces() {
        Organizer organizer = new Organizer();
        assertThat(organizer.getWinningNumbersFromInput("1 , 2,3 ,4 ,5 ,6"))
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("입력 문자열에 숫자가 아닌 문자를 포함하면 예외 처리한다.")
    void throwsExceptionWhenInputIncludesNonNumeric() {
        Organizer organizer = new Organizer();
        assertThatThrownBy(() -> organizer.getWinningNumbersFromInput("1,2,3,b,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 숫자 개수가 6이 아니면 예외 처리한다.")
    void throwsExceptionWhenInputIncludesMoreThan6() {
        Organizer organizer = new Organizer();
        assertThatThrownBy(() -> organizer.setWinningNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 숫자 범위가 1~45 사이가 아니면 예외 처리한다.")
    void throwsExceptionWhenWinningNumbersNotInRange() {
        Organizer organizer = new Organizer();
        assertThatThrownBy(() -> organizer.setWinningNumbers("1,2,3,4,99,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 숫자 중 중복이 존재하면 예외 처리한다.")
    void throwsExceptionWhenExistsWinningNumbersDuplicate() {
        Organizer organizer = new Organizer();
        assertThatThrownBy(() -> organizer.setWinningNumbers("1,2,3,4,6,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 숫자 범위가 1~45 사이가 아니면 예외 처리한다.")
    void throwsExceptionWhenBonusNotInRange() {
        Organizer organizer = new Organizer();
        organizer.setWinningNumbers("1,2,3,4,5,6");
        assertThatThrownBy(() -> organizer.setBonusNumber("65"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 숫자와 보너스 숫자 중 중복이 있으면 예외 처리한다.")
    void throwsExceptionWhenExistsDuplicate() {
        Organizer organizer = new Organizer();
        organizer.setWinningNumbers("1,2,3,4,5,6");
        assertThatThrownBy(() -> organizer.setBonusNumber("3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
