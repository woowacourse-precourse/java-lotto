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

@DisplayName("Test about Validation of LottoNumber Input")
@TestMethodOrder(OrderAnnotation.class)
class LottoNumberValidatorTest {

    private LottoNumberValidator validator;

    @BeforeEach
    void testSetting(){
        validator = new LottoNumberValidator();
    }

    @Order(1)
    @DisplayName("when wrong separator")
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
    @DisplayName("when contains not number")
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