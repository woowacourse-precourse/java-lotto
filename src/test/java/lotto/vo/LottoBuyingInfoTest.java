package lotto.vo;

import lotto.system.validator.ConvertingToLottoBuyingInfoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("LottoBuyingInfo 테스트")
class LottoBuyingInfoTest {
    @Nested
    @DisplayName("LottoBuyingInfo 생성자 테스트")
    class LottoBuyingInfoConstructorTest {
        @Test
        @DisplayName("유효한 금액을 이용해 LottoBuyingInfo 객체를 만들 수 있다.")
        void givenValidMoney_whenCreatingLottoBuyingInfo_thenReturnsLottoBuyingInfo() {
            //given
            String input = "14000";

            //when & then
            LottoBuyingInfo target = new LottoBuyingInfo(input);
            assertThat(target.getMoney()).isEqualTo(14000);
            assertThat(target.getAmount()).isEqualTo(14);
        }

        @Test
        @DisplayName("정수가 아닌 값이 적힌 금액을 이용해 LottoBuyingInfo 객체를 만드려고 하면 예외가 발생한다.")
        void givenStringNotOnlyNumber_whenCreatingLottoBuyingInfo_thenThrowsException() {
            //given
            String input = "45.000";

            //when & then
            assertThatThrownBy(() -> new LottoBuyingInfo(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ConvertingToLottoBuyingInfoValidator.NOT_NATURAL_NUMBER_MESSAGE);
        }

        @Test
        @DisplayName("입력한 숫자 사이에 , 을 넣는 것은 예외적으로 입력을 허용해준다.")
        void givenLetterWithRest_whenCreatingLottoBuyingInfo_thenPassesValidation() {
            //given
            String input = "45,000,000";

            //when & then
            assertDoesNotThrow(() -> new LottoBuyingInfo(input));
        }

        @Test
        @DisplayName("한 장도 살 수 없는 금액을 이용해 LottoBuyingInfo 객체를 만드려고 하면 예외가 발생한다.")
        void givenLetterOfNumberLowerThanLotto_whenCreatingLottoBuyingInfo_thenThrowsException() {
            //given
            String input = "500";

            //when & then
            assertThatThrownBy(() -> new LottoBuyingInfo(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ConvertingToLottoBuyingInfoValidator.LOWER_THEN_MIN_VALUE_MESSAGE);
        }

        @Test
        @DisplayName("1,000 으로 나누어지지 않는 금액을 이용해 LottoBuyingInfo 객체를 만드려고 하면 예외가 발생한다.")
        void givenLetterOfNumberNotDividedIn1000_whenCreatingLottoBuyingInfo_thenThrowsException() {
            //given
            String input = "14500";

            //when & then
            assertThatThrownBy(() -> new LottoBuyingInfo(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ConvertingToLottoBuyingInfoValidator.NOT_DIVIDED_VALUE_MESSAGE);
        }
    }
}