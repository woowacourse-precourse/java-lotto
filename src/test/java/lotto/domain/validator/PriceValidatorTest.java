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
}