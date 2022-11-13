package lotto;

import lotto.enums.ErrorMessage;
import lotto.util.ValidationUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputValidation {

    @DisplayName("사용자가 입력한 가격을 검증한다.")
    @Nested
    class InputAmountTest {

        @DisplayName("1000단위의 가격이 아닐 때")
        @Test
        void case1() {
            assertThatThrownBy(() -> ValidationUtil.isValidAmount("1001"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_AMOUNT_INPUT.getValue());

            assertThatThrownBy(() -> ValidationUtil.isValidAmount("999"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_AMOUNT_INPUT.getValue());
        }

        @DisplayName("입력값이 숫자가 아닐 때")
        @Test
        void case2() {
            assertThatThrownBy(() -> ValidationUtil.isValidAmount("안녕"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_AMOUNT_INPUT.getValue());
        }

        @DisplayName("입력값이 빈 문자열일 때")
        @Test
        void case3() {
            assertThatThrownBy(() -> ValidationUtil.isValidAmount(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_AMOUNT_INPUT.getValue());
        }
    }


    @DisplayName("사용자가 입력한 로또 번호를 검증한다.")
    @Nested
    class InputWinNumberTest {

        @DisplayName("성공하는 테스트 케이스")
        @Test
        void case1() {
            ValidationUtil.isValidWinNumbers("1,2,3,4,5,6");
            ValidationUtil.isValidWinNumbers("1, 2, 3 ,4 ,5 , 6");
        }

        @DisplayName("쉼표 사이에 빈 값이 들어올 때")
        @Test
        void case2() {
            assertThatThrownBy(() -> ValidationUtil.isValidWinNumbers("1,,3,4,5"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_WIN_NUMBERS_INPUT.getValue());
        }

        @DisplayName("숫자 혹은 쉼표 이외의 문자가 들어올 때")
        @Test
        void case3() {
            assertThatThrownBy(() -> ValidationUtil.isValidWinNumbers("1,2,3,4,#"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_WIN_NUMBERS_INPUT.getValue());

            assertThatThrownBy(() -> ValidationUtil.isValidWinNumbers("1,2,3,4,-1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_WIN_NUMBERS_INPUT.getValue());

            assertThatThrownBy(() -> ValidationUtil.isValidWinNumbers("1.2.3,4,-1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_WIN_NUMBERS_INPUT.getValue());

            assertThatThrownBy(() -> ValidationUtil.isValidWinNumbers("*"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_WIN_NUMBERS_INPUT.getValue());
        }

        @DisplayName("입력값이 빈 문자열일 때")
        @Test
        void case4() {
            assertThatThrownBy(() -> ValidationUtil.isValidWinNumbers(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_WIN_NUMBERS_INPUT.getValue());
        }

        @DisplayName("허용하는 범위를 초과하는 숫자가 들어올 때")
        @Test
        void case5() {
            assertThatThrownBy(() -> ValidationUtil.isValidWinNumbers("1,2,3,4,46"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_NUMBER.getValue());
        }
    }
}
