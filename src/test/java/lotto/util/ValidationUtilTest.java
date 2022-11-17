package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static lotto.constant.message.ErrorOutputMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationUtilTest {

    @Test
    @DisplayName("구매 금액에 숫자가 아닌 다른 문자가 들어오면 예외가 발생한다.")
    void 구매_금액_숫자_테스트() throws Exception {
        //given
        ValidationUtil validationUtil = new ValidationUtil();
        Method method = validationUtil.getClass().getDeclaredMethod("validateNumberType", String.class);
        method.setAccessible(true);

        //when
        String purchaseAmount = "10abc";

        // then
        try {
            method.invoke(validationUtil, purchaseAmount);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(PURCHASE_TYPE);
        }
    }

    @Test
    @DisplayName("구매 금액이 1000 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    void 구매_금액_나머지_테스트() throws Exception {
        //given
        ValidationUtil validationUtil = new ValidationUtil();
        Method method = validationUtil.getClass().getDeclaredMethod("validateRemainder", String.class);
        method.setAccessible(true);

        //when
        String purchaseAmount = "1234";

        //then
        try {
            method.invoke(validationUtil, purchaseAmount);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(PURCHASE_REMAINDER);
        }
    }

    @Test
    @DisplayName("구매 금액에 대한 통합 테스트를 진행한다.")
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

    @Test
    @DisplayName("당첨 번호를 6개 입력하지 않으면 예외가 발생한다.")
    void 당첨_번호_개수_테스트() throws Exception {
        //given
        ValidationUtil validationUtil = new ValidationUtil();
        Method method = validationUtil.getClass().getDeclaredMethod("validateWinningCount", String[].class);
        method.setAccessible(true);

        //when
        String[] winningNums = {"1", "2", "3", "4", "5"};

        //then
        try {
            method.invoke(validationUtil, new Object[]{winningNums});
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NUMBER_COUNT);
        }
    }

    @Test
    @DisplayName("당첨 번호에 공백값이 들어있으면 예외가 발생한다.")
    void 당첨_번호_공백_테스트() throws Exception {
        //given
        ValidationUtil validationUtil = new ValidationUtil();
        Method method = validationUtil.getClass().getDeclaredMethod("validateBlank", String[].class);
        method.setAccessible(true);

        //when
        String[] wrongNumsWithBlank = {"1", "2", "3", "4", " ", "6"};
        String[] wrongNumsWithEmpty = {"1", "2", "3", "4", "", "6"};

        //then
        try {
            method.invoke(validationUtil, new Object[]{wrongNumsWithBlank});
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NUMBER_BLANK);
        }

        try {
            method.invoke(validationUtil, new Object[]{wrongNumsWithEmpty});
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NUMBER_BLANK);
        }
    }

    @Test
    @DisplayName("당첨 번호에 중복된 값이 들어오면 예외가 발생한다.")
    void 당첨_번호_중복_테스트() throws Exception {
        //given
        ValidationUtil validationUtil = new ValidationUtil();
        Method method = validationUtil.getClass().getDeclaredMethod("validateDuplicate", String[].class);
        method.setAccessible(true);

        //when
        String[] wrongNums = {"1", "2", "3", "4", "5", "5"};

        //then
        try {
            method.invoke(validationUtil, new Object[]{wrongNums});
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NUMBER_DUPLICATE);
        }
    }

    @Test
    @DisplayName("로또 번호의 범위가 1~45를 벗어나면 예외가 발생한다.")
    void 로또_번호_범위_테스트() throws Exception {
        //given
        ValidationUtil validationUtil = new ValidationUtil();
        Method method = validationUtil.getClass().getDeclaredMethod("validateWinningRange", String[].class);
        method.setAccessible(true);

        //when
        String[] wrongMinNums = {"0", "2", "3", "4", "5", "6"};
        String[] wrongMaxNums = {"1", "2", "3", "4", "46", "6"};

        //then
        try {
            method.invoke(validationUtil, new Object[]{wrongMinNums});
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NUMBER_RANGE);
        }

        try {
            method.invoke(validationUtil, new Object[]{wrongMaxNums});
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NUMBER_RANGE);
        }
    }
    @Test
    @DisplayName("당첨 번호에 대한 통합 테스트를 진행한다.")
    void 당첨_번호_통합_테스트() throws Exception {
        //given
        ValidationUtil validationUtil = new ValidationUtil();

        //when
        String correctNums = "1,2,3,4,5,6";
        String wrongBlankNums = "1,,3,4,5,6";
        String wrongCountNums = "1, 2, 3, 4, 5,";
        String wrongDuplicatedNums = "1,2,3,4,5,5";
        String wrongRangeNums = "1,2,3,47,5,6";

        //then
        String[] correctResult = validationUtil.validateWinningAmount(correctNums);
        assertThat(correctResult).isEqualTo(new String[]{"1", "2", "3", "4", "5", "6"});

        assertThatThrownBy(() -> validationUtil.validateWinningAmount(wrongBlankNums))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_BLANK);

        assertThatThrownBy(() -> validationUtil.validateWinningAmount(wrongCountNums))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_COUNT);

        assertThatThrownBy(() -> validationUtil.validateWinningAmount(wrongDuplicatedNums))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_DUPLICATE);

        assertThatThrownBy(() -> validationUtil.validateWinningAmount(wrongRangeNums))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_RANGE);
    }

}