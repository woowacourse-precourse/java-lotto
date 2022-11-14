package lotto.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OrganizerTest {
    @Test
    @DisplayName("입력 문자열을 숫자 리스트로 변환한다.")
    void getNumberListFromStringInput() {
        Organizer organizer = new Organizer();
        assertThat(organizer.transformStringToWinningNumbers("1,2,3,4,5,6"))
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("입력 문자열에 띄어쓰기와 무관하게 숫자 리스트로 변환한다.")
    void getNumberListFromStringInputWithSpaces() {
        Organizer organizer = new Organizer();
        assertThat(organizer.transformStringToWinningNumbers("1 , 2,3 ,4 ,5 ,6"))
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("입력 문자열에 숫자가 아닌 문자를 포함하면 예외 처리한다.")
    void throwsExceptionWhenInputIncludesNonNumeric() {
        Organizer organizer = new Organizer();
        assertThatThrownBy(() -> organizer.transformStringToWinningNumbers("1,2,3,b,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 숫자와 보너스 숫자 중 중복이 있으면 예외 처리한다.")
    void throwsExceptionWhenExistsDuplicate() {
        Organizer organizer = new Organizer();
        assertThatThrownBy(() -> organizer.checkDuplicate(List.of(1,2,3,4,5,6), 3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
