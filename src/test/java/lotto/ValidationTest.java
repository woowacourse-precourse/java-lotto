package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {
    /*
    1. 로또 구입 금액을 검증하는 기능
      1. 숫자만 입력했는지 검증
      2. 1000원 단위로 입력했는지 검증
    2. 입력된 당첨번호를 검증하는 기능
      1. 숫자만 입력했는지 검증
      2. 1~45 사이의 숫자인지 검증
      3. 당첨번호가 중복되지 않는지 검증
      4. 번호를 쉼표로 구분했는지 검증
    3. 입력된 보너스 번호를 검증하는 기능
      1. 숫자만 입력했는지 검증
      2. 1~45 사이의 숫자인지 검증
      3. 당첨번호와 중복되지 않는지 검증
    * */

    @Nested
    @DisplayName("숫자만 입력했는지 검증")
    class isDigitTest {
        @Test
        @DisplayName("숫자만 입력하면 예외가 발생하지 않는다.")
        void inputNumber() {
            Validation.isDigit("123");
        }

        @Test
        @DisplayName("숫자가 아닌 값을 입력하면 예외가 발생한다.")
        void inputNotNumber() {
            assertThatThrownBy(() -> Validation.isDigit("a1~#AD>"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("1000원 단위로 입력했는지 검증")
    class isThousandUnitTest {
        @Test
        @DisplayName("1000원 단위로 입력하면 예외가 발생하지 않는다.")
        void inputThousandUnitNumber() {
            Validation.isThousandUnit(123000L);
        }

        @Test
        @DisplayName("1000원 단위로 입력하지 않으면 예외가 발생한다.")
        void inputNotThousandUnitNumber() {
            assertThatThrownBy(() -> Validation.isThousandUnit(1234L))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("1~45 사이의 숫자인지 검증")
    class isRightLottoNumberTest {
        @Test
        @DisplayName("1~45 사이의 숫자를 입력하면 예외가 발생하지 않는다.")
        void rightCase() {
            Validation.isRightLottoNumber(3);
        }

        @Test
        @DisplayName("1000원 단위로 입력하지 않으면 예외가 발생한다.")
        void wrongCase() {
            assertThatThrownBy(() -> Validation.isRightLottoNumber(46))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("당첨번호가 중복되지 않는지 검증")
    class isDuplicatedWinningNumbersTest {
        @Test
        @DisplayName("중복되지 않는 숫자를 입력하면 예외가 발생하지 않는다.")
        void rightCase() {
            Validation.isDuplicatedWinningNumbers(Arrays.asList(1,2,3,4,5));
        }

        @Test
        @DisplayName("중복되는 숫자를 입력하면 예외가 발생한다.")
        void wrongCase() {
            assertThatThrownBy(() -> Validation.isDuplicatedWinningNumbers(Arrays.asList(2,2,3,4,45)))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("번호를 쉼표로 구분했는지 검증")
    class isSplitedWithCommaTest {
        @Test
        @DisplayName("번호를 쉼표로 구분해 입력하면 예외가 발생하지 않는다.")
        void rightCase() {
            Validation.isSplitedWithComma("12,24,31,42,1,6");
        }

        @Test
        @DisplayName("번호를 쉼표로 구분해 입력하지 않으면 예외가 발생한다.")
        void wrongCase() {
            assertThatThrownBy(() -> Validation.isSplitedWithComma("12 24 31 42 1 6"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("번호를 쉼표로 구분해 입력하지 않으면 예외가 발생한다.")
        void wrongCase2() {
            assertThatThrownBy(() -> Validation.isSplitedWithComma("12,24,31,42,1 6"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("번호를 쉼표로 구분해 입력하지 않으면 예외가 발생한다.")
        void wrongCase3() {
            assertThatThrownBy(() -> Validation.isSplitedWithComma("1224314216"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("당첨번호와 중복되지 않는지 검증")
    class isBonusNumberDuplicatedWithWinningNumbersTest {
        @Test
        @DisplayName("당첨번호와 중복되지 않는 숫자를 입력하면 예외가 발생하지 않는다.")
        void rightCase() {
            Validation.isBonusNumberDuplicatedWithWinningNumbers(Arrays.asList(1,2,3,4,5), 25);
        }

        @Test
        @DisplayName("당첨번호와 중복되는 숫자를 입력하면 예외가 발생한다.")
        void wrongCase() {
            assertThatThrownBy(() -> Validation.isBonusNumberDuplicatedWithWinningNumbers(Arrays.asList(1,2,3,4,5), 3))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}


