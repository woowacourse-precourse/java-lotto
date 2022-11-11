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

    @Order(3)
    @DisplayName("3차:범위에서 벗어난 값 입력")
    @Test
    void outOfBoundExceptionTest(){
        String inputValue1 = "-1, 2, 3, 4, 6, 5";
        String inputValue2 = "1, 2, 3, 4, 5, 47";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkingRange(inputValue1))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkingRange(inputValue2))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        Exception exception1 = assertThrows(IllegalArgumentException.class, () ->validator.checkingRange(inputValue1));
        Exception exception2 = assertThrows(IllegalArgumentException.class, () ->validator.checkingRange(inputValue2));

        assertThat(exception1.getMessage()).isEqualTo(ErrorMessages.OUT_OF_BOUND.getMessage()) ;
        assertThat(exception2.getMessage()).isEqualTo(ErrorMessages.OUT_OF_BOUND.getMessage()) ;
    }

    @Order(4)
    @DisplayName("4차:6개보다 많거나 적게 숫자 입력")
    @Test
    void hasLessOrMoreNumber(){
        String inputValueMore = "1, 2, 3, 4, 5, 6, 7";
        String inputValueLess = "1, 2, 3, 4, 5";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkingQuantity(inputValueMore))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkingQuantity(inputValueLess))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        Exception exceptionMore = assertThrows(IllegalArgumentException.class, () ->validator.checkingQuantity(inputValueMore));
        Exception exceptionLess = assertThrows(IllegalArgumentException.class, () ->validator.checkingQuantity(inputValueLess));
        assertThat(exceptionMore.getMessage()).isEqualTo(ErrorMessages.MORE_THAN_SIX.getMessage()) ;
        assertThat(exceptionLess.getMessage()).isEqualTo(ErrorMessages.LESS_THAN_SIX.getMessage()) ;
    }

    @Order(5)
    @DisplayName("5차:중복 값 입력")
    @Test
    void hasOverlapNumber(){
        String inputValue = "1, 2, 2, 4, 7, 5";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkingOverlap(inputValue))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        Exception exception = assertThrows(IllegalArgumentException.class, () ->validator.checkingOverlap(inputValue));
        assertThat(exception.getMessage()).isEqualTo(ErrorMessages.HAS_OVERLAP_NUMBER.getMessage()) ;
    }
}