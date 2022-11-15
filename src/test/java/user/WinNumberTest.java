package user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinNumberTest {

    @DisplayName("사용자로부터 당첨 번호를 입력받으면 올바른 값으로 인해 검증에 통과한다.")
    @Test
    void 올바른_당첨_번호를_입력받아_검증에_통과한다() {
        // given

        // when & then
        assertAll(
                () -> assertThatCode(() -> new WinNumber("1,2,3,4,5,6"))
                        .doesNotThrowAnyException(),
                () -> assertThatCode(() -> new WinNumber("13,24,36,45,1,5"))
                        .doesNotThrowAnyException()
        );
    }

    @DisplayName("사용자로부터 당첨 번호를 입력받으면 잘못된 값으로 인해 예외가 던져진다.")
    @Test
    void 잘못된_당첨_번호를_입력받아_검증에_통과하지_못한다() {
        // given

        // when & then
        IllegalArgumentException underRangeEx = assertThrows(
                IllegalArgumentException.class,
                () -> new WinNumber("0,1,2,3,4,5")
        );
        IllegalArgumentException overRangeEx = assertThrows(
                IllegalArgumentException.class,
                () -> new WinNumber("1,2,3,4,5,46")
        );
        IllegalArgumentException includeNotNumberEx = assertThrows(
                IllegalArgumentException.class,
                () -> new WinNumber("0,1,2,3,4,5")
        );
        IllegalArgumentException duplicatedEx = assertThrows(
                IllegalArgumentException.class,
                () -> new WinNumber("1,2,3,4,5,5")
        );

        assertAll(
                () -> assertThat(underRangeEx.getMessage()).startsWith("[ERROR]"),
                () -> assertThat(overRangeEx.getMessage()).startsWith("[ERROR]"),
                () -> assertThat(includeNotNumberEx.getMessage()).startsWith("[ERROR]"),
                () -> assertThat(duplicatedEx.getMessage()).startsWith("[ERROR]")
        );
    }

}