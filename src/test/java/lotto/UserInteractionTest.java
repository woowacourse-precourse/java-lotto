package lotto;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInteractionTest {

    UserInteraction testUserInteraction;

    @BeforeEach
    void setUp() {
        testUserInteraction = new UserInteraction();
    }
    @DisplayName("입력 받은 문자열을 정수형으로 변환 시도1")
    @Test
    void tryParseInt_exception_test_1() {
        assertThatThrownBy(() -> testUserInteraction.tryParseInt("800 0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력 받은 문자열을 정수형으로 변환 시도2")
    @Test
    void tryParseInt_exception_test_2() {
        assertThatThrownBy(() -> testUserInteraction.tryParseInt("1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("의도한 입력이 들어온 경우, 정수형으로 변환이 이루어지는지 확인")
    @Test
    void tryParseInt_test(){
        String testInput="8000";
        int result = testUserInteraction.tryParseInt(testInput);
        assertThat(result).isEqualTo(8000);
    }
}