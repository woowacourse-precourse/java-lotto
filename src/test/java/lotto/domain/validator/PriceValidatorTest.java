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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("구매 금액 입력 유효성 검사 테스트")
@TestMethodOrder(OrderAnnotation.class)
class PriceValidatorTest {
    private PriceValidator validator ;

    @BeforeEach
    void testSetting(){
        validator = new PriceValidator();
    }

    @Order(1)
    @DisplayName("최저 구매 금액 미달 액수 입력")
    @Test
    void belowPriceThresholdException(){
        int inputMoney = 999 ;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkingPurchasable(inputMoney))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> validator.checkingPurchasable(inputMoney));
        assertThat(exception.getMessage()).isEqualTo(ErrorMessages.BELOW_THE_PRICE_THRESHOLD.getMessage());
    }
    @Order(2)
    @DisplayName("나누어 떨어지지 않는 값 입력")
    @Test
    void undividedMoneyException() {
        int inputMoney = 10_111;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkingDividable(inputMoney))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> validator.checkingDividable(inputMoney));
        assertThat(exception.getMessage()).isEqualTo(ErrorMessages.MONEY_UNDIVIDED.getMessage());
    }

    @Order(3)
    @DisplayName("구매 금액 입력값 통합 검사 ")
    @Test
    void moneyInputIntegrationTest(){
        String inputMoney1 = "abcde";
        String inputMoney2 = "1000004";
        String inputMoney3 = "1";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.validateMoneyInput(inputMoney1))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        Exception exception1 = assertThrows(IllegalArgumentException.class,
                () -> validator.validateMoneyInput(inputMoney1));
        assertThat(exception1.getMessage()).isEqualTo(ErrorMessages.NOT_NUMBER_EXIST.getMessage());

        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.validateMoneyInput(inputMoney2))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        Exception exception2 = assertThrows(IllegalArgumentException.class,
                () -> validator.validateMoneyInput(inputMoney2));
        assertThat(exception2.getMessage()).isEqualTo(ErrorMessages.MONEY_UNDIVIDED.getMessage());

        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.validateMoneyInput(inputMoney3))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        Exception exception3 = assertThrows(IllegalArgumentException.class,
                () -> validator.validateMoneyInput(inputMoney3));
        assertThat(exception3.getMessage()).isEqualTo(ErrorMessages.BELOW_THE_PRICE_THRESHOLD.getMessage());
    }
}