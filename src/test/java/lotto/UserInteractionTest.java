package lotto;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInteractionTest {

    UserInteraction testUserInteraction;

    @BeforeEach
    void setUp() {
        testUserInteraction = new UserInteraction();
    }

    @DisplayName("(tryParseInt) 입력 받은 문자열을 정수형으로 변환 시도1")
    @Test
    void tryParseInt_exception_test_1() {
        assertThatThrownBy(() -> testUserInteraction.tryParseInt("800 0"))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("(tryParseInt) 입력 받은 문자열을 정수형으로 변환 시도2")
    @Test
    void tryParseInt_exception_test_2() {
        assertThatThrownBy(() -> testUserInteraction.tryParseInt("1,2,3"))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("(tryParseInt) 의도한 입력이 들어온 경우, 정수형으로 변환이 이루어지는지 확인")
    @Test
    void tryParseInt_test() {
        String testInput = "8000";
        int result = testUserInteraction.tryParseInt(testInput);
        assertThat(result).isEqualTo(8000);
    }

    @DisplayName("(tryParseIntegers) 쉼표로 구분된 문자열이 숫자들로만 이루어져있는지 확인")
    @Test
    void tryParseIntegers_exception_test() {
        assertThatThrownBy(() -> testUserInteraction.tryParseInt("1,a,3"))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("(tryParseIntegers) 의도한 입력이 들어온 경우, 정수형으로 변환이 이루어지는지 확인")
    @Test
    void tryParseIntegers_test() {
        String testInput = "1,2, 3, 4,5,6";
        List<Integer> result = testUserInteraction.tryParseIntegers(testInput);
        assertThat(result).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("(checkNumbers) 중복 없이 6개의 숫자가 아닌경우 에러 확인")
    @Test
    void checkNumbers_exception_test_1() {
        assertThatThrownBy(() -> testUserInteraction.checkNumbers(List.of(1, 1, 1, 4, 5, 6)))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("(checkNumbers) 1~45 사이를 벗어나는 숫자를 입력으로 받은 경우 에러 확인")
    @Test
    void checkNumbers_exception_test_2() {
        assertThatThrownBy(() -> testUserInteraction.checkNumbers(List.of(-1, 1, 1, 4, 5, 46)))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("(checkBonusNumber) 당첨 번호와 보너스 번호가 중복되는 경우 에러 확인")
    @Test
    void checkBonusNumber_exception_test() {
        assertThatThrownBy(() -> testUserInteraction.checkBonusNumber(List.of(1, 2, 3, 4, 5, 6), 2))
                .isInstanceOf(NoSuchElementException.class);
    }
    @DisplayName("(isNumberInRange) 번호가 범위안에 있는지 에러 확인")
    @Test
    void isNumberInRange_exception_test() {
        assertThatThrownBy(() -> testUserInteraction.isNumberInRange(-10, 1,45))
                .isInstanceOf(NoSuchElementException.class);
    }
}