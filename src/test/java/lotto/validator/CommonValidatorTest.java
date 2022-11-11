package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("CommonValidator Unit Test")
class CommonValidatorTest {

    @Test
    @DisplayName("숫자가 아닌 다른 것을 입력하면 IllegalArgumentException을 발생시킵니다.")
    void testIsAllNumber_IllegalArgumentException() throws Exception {
        //when & then
        assertThrows(IllegalArgumentException.class,
                     () -> CommonValidator.isAllNumber("김현우"));

        assertThrows(IllegalArgumentException.class,
                     () -> CommonValidator.isAllNumber("dfc123"));

        assertThrows(IllegalArgumentException.class,
                     () -> CommonValidator.isAllNumber(""));
    }
}