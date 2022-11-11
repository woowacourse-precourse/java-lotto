package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LottoValidator Unit Test")
class LottoValidatorTest {

    @Test
    @DisplayName("로또 번호가 6개가 아니면 IllegalArgumentException을 발생시킵니다.")
    void testHasSixNumbers_IllegalArgumentException() throws Exception {
        //when & then
        assertThrows(IllegalArgumentException.class,
                     () -> LottoValidator.validate(List.of(1, 2, 3, 4, 5)));

        assertThrows(IllegalArgumentException.class,
                     () -> LottoValidator.validate(List.of(1, 2, 3, 4, 5, 6, 7)));
    }
}