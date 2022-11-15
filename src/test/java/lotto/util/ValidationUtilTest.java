package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static lotto.constant.ErrorOutputMessage.PURCHASE_REMAINDER;
import static lotto.constant.ErrorOutputMessage.PURCHASE_TYPE;
import static org.assertj.core.api.Assertions.*;

class ValidationUtilTest {

    @Test
    @DisplayName("구매 금액에 숫자만 들어가있는지 테스트")
    void 구매_금액_숫자_테스트() throws Exception {
        //given
        ValidationUtil validationUtil = new ValidationUtil();
        Method method = validationUtil.getClass().getDeclaredMethod("validateNumberType", String.class);
        method.setAccessible(true);

        //when
        String correctAmount = "5000";
        String wrongAmount = "10abc";

        // then
        assertThatCode(() ->
                method.invoke(validationUtil, correctAmount))
                .doesNotThrowAnyException();

        try {
            method.invoke(validationUtil, wrongAmount);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(PURCHASE_TYPE);
        }
    }

    @Test
    @DisplayName("구매 금액이 1000 단위로 나누어 떨어지는지 테스트")
    void 구매_금액_나머지_테스트() throws Exception {
        //given
        ValidationUtil validationUtil = new ValidationUtil();
        Method method = validationUtil.getClass().getDeclaredMethod("validateRemainder", String.class);
        method.setAccessible(true);

        //when
        String correctAmount = "3000";
        String wrongAmount = "1234";

        //then
        int purchaseAmount = (int) method.invoke(validationUtil, correctAmount);
        assertThat(purchaseAmount).isEqualTo(3000);

        try {
            method.invoke(validationUtil, wrongAmount);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(PURCHASE_REMAINDER);
        }
    }

    @Test
    @DisplayName("구매 금액에 대한 통합 테스트")
    void 구매_금액_통합_테스트() throws Exception {
        //given
        ValidationUtil validationUtil = new ValidationUtil();

        //when
        String wrongTypeAmount = "1234j";
        String remainderAmount =  "1234";
        String correctAmount = "8000";

        //then
        assertThatThrownBy(() ->
                validationUtil.validatePurchase(wrongTypeAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_TYPE);

        assertThatThrownBy(() ->
                validationUtil.validatePurchase(remainderAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_REMAINDER);

        int purchaseAmount = validationUtil.validatePurchase(correctAmount);
        assertThat(purchaseAmount).isEqualTo(8000);
    }
}