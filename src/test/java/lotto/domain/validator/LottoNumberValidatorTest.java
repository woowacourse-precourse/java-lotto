package lotto.domain.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.util.ErrorMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("로또 번호 입력 유효성 검사 테스트")
@TestMethodOrder(OrderAnnotation.class)
class LottoNumberValidatorTest {

    private LottoNumberValidator validator;

    @BeforeEach
    void testSetting(){
        validator = new LottoNumberValidator();
    }

    @Order(1)
    @DisplayName("1차:잘못된 구분자")
    @Test
    void separatorExceptionTest(){
        String inputValue = "1, 2, 3, 4. 5. 6";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkingSeparator(inputValue))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        Exception exception = assertThrows(IllegalArgumentException.class, () ->validator.checkingSeparator(inputValue));
        assertThat(exception.getMessage()).isEqualTo(ErrorMessages.WRONG_SEPARATOR.getMessage()) ;
    }

    @Order(2)
    @DisplayName("2차:숫자가 아닌 값 입력")
    @Test
    void notNumberExceptionTest(){
        String inputValue = "1, 2, 3, a, b, 5";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkingNotNumber(inputValue))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        Exception exception = assertThrows(IllegalArgumentException.class, () ->validator.checkingNotNumber(inputValue));
        assertThat(exception.getMessage()).isEqualTo(ErrorMessages.NOT_NUMBER_EXIST.getMessage()) ;
    }
}