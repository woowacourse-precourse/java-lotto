package lotto.domain.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import lotto.util.ErrorMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 번호 입력 유효성 검사 테스트")
@TestMethodOrder(OrderAnnotation.class)
class LottoNumberValidatorTest {

    private LottoNumberValidator validator;

    @BeforeEach
    void testSetting() {
        validator = new LottoNumberValidator();
    }

    @Order(1)
    @DisplayName("1차:잘못된 구분자")
    @ParameterizedTest(name = "{displayName} ({index}) : {0}")
    @ValueSource(strings = {
            "1, 2,  3&4,5.6",
            "1, 2, 3, 4. 5. 6",
            "1 /2 /3/ 4/ 5/ 6"
    })
    @TestFactory
    void separatorExceptionTest(String inputValue) {
        LottoNumberValidator validator = new LottoNumberValidator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkingSeparator(inputValue))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.checkingSeparator(inputValue))
                .withMessage(ErrorMessages.WRONG_SEPARATOR.getMessage());
    }

    @Order(2)
    @DisplayName("2차:숫자가 아닌 값 입력")
    @ParameterizedTest(name = "{displayName} ({index}) : {0}")
    @ValueSource(strings = {
            "1, 2, 3, a, b, 5",
            "a, b, c, d, e, f",
            "1ab ,2 ,3, 4, 5, 6"
    })
    @TestFactory
    void notNumberExceptionTest(String inputValue) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkingNotNumber(inputValue))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.checkingNotNumber(inputValue))
                .withMessage(ErrorMessages.NOT_NUMBER_EXIST.getMessage());
    }

    @Order(3)
    @DisplayName("3차:범위에서 벗어난 값 입력")
    @ParameterizedTest(name = "{displayName} ({index}) : {0}")
    @ValueSource(strings = {
            "-1, 2, 3, 4, 6, 5",
            "1, 2, 3, 4, 5, 47"
    })
    @TestFactory
    void outOfBoundExceptionTest(String inputValue) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkingRange(inputValue))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.checkingRange(inputValue))
                .withMessage(ErrorMessages.OUT_OF_BOUND.getMessage());
    }

    @Order(4)
    @DisplayName("4차:6개보다 많거나 적게 숫자 입력")
    @ParameterizedTest(name = "{displayName} ({index}) : {0}")
    @ValueSource(strings = {
            "1, 2, 3, 4, 5, 6, 7",
            "1, 2, 3, 4, 5"
    })
    @TestFactory
    void hasLessOrMoreNumber(String inputValue) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkingQuantity(inputValue))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.checkingQuantity(inputValue))
                .withMessage(inputValue.equals("1, 2, 3, 4, 5, 6, 7")
                        ? ErrorMessages.MORE_THAN_SIX.getMessage()
                        : ErrorMessages.LESS_THAN_SIX.getMessage()
                );

    }

    @Order(5)
    @DisplayName("5차:중복 값 입력")
    @ParameterizedTest(name = "{displayName} ({index}) : {0}")
    @ValueSource(strings = {
            "1, 2, 2, 4, 7, 5"
    })
    @TestFactory
    void hasOverlapNumber(String inputValue) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkingOverlap(inputValue))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.checkingOverlap(inputValue))
                .withMessage(ErrorMessages.HAS_OVERLAP_NUMBER.getMessage());
    }

    @Order(6)
    @DisplayName("보너스 번호 입력 검증")
    @ParameterizedTest(name = "{displayName} ({index}) : {0}")
    @ValueSource(strings = {
            "4   23",
            "2, 5, 6",
            "1   .  3"
    })
    @TestFactory
    void notSingleNumber(String inputValue) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkingQuantity(inputValue))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.checkingSingleNumber(inputValue))
                .withMessage(ErrorMessages.NOT_SINGLE_NUMBER.getMessage());
    }

    @Order(7)
    @DisplayName("validateFomula 통합 테스트")
    @ParameterizedTest(name = "{displayName} ({index}) : {0}")
    @MethodSource("paramsForFomulaNumberIntegrationTest")
    @TestFactory
    void fomulaNumberIntegrationTest(String inputValue, String message) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validateFomula(inputValue))
                .withMessage(message);
    }
    private static Stream<Arguments> paramsForFomulaNumberIntegrationTest(){
        return Stream.of(
                Arguments.of("1,2,3,4.5.6", ErrorMessages.WRONG_SEPARATOR.getMessage()),
                Arguments.of("1,2,3,4,5,a", ErrorMessages.NOT_NUMBER_EXIST.getMessage()),
                Arguments.of("1,2,3,4,5,47", ErrorMessages.OUT_OF_BOUND.getMessage()),
                Arguments.of("1,2,3,4,5,6,7", ErrorMessages.MORE_THAN_SIX.getMessage()),
                Arguments.of("1,2,2,3,4,5", ErrorMessages.HAS_OVERLAP_NUMBER.getMessage())
        );
    }

    @Order(8)
    @DisplayName("validateBonus 통합 테스트")
    @ParameterizedTest(name = "{displayName} ({index}) : {0}")
    @MethodSource("paramsForbonusNumberIntegrationTest")
    @TestFactory
    void bonusNumberIntegrationTest(String inputValue, String message) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validateBonus(inputValue))
                .withMessage(message);
    }
    private static Stream<Arguments> paramsForbonusNumberIntegrationTest(){
        return Stream.of(
                Arguments.of("4   23", ErrorMessages.NOT_SINGLE_NUMBER.getMessage()),
                Arguments.of("a", ErrorMessages.NOT_NUMBER_EXIST.getMessage()),
                Arguments.of("47", ErrorMessages.OUT_OF_BOUND.getMessage())
                );
    }
}