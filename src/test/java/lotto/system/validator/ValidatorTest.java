package lotto.system.validator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lotto.system.LottoApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import lotto.vo.Lotto;
import lotto.system.holder.ValidationHolder;
import lotto.vo.LottoAmount;

class ValidatorTest {
    @BeforeEach
    void setup() {
        LottoApplication.initializeValidators();
        LottoApplication.initializeConverters();
    }

    @AfterEach
    void runAfter() {
        LottoApplication.doAfter();
    }

    @Nested
    @DisplayName("StringToLottoAmountValidator 테스트")
    class StringToLottoAmountValidatorTest {
        @Test
        @DisplayName("유효한 String 을 LottoAmount 로 바꾸기 위해 검증 작업을 받으면 검증을 통과한다.")
        void givenValidString_whenValidatingForLottoAmount_thenPassesValidation() {
            //given
            String input = "14000";

            //when & then
            assertDoesNotThrow(() -> ValidationHolder.validate(input, LottoAmount.class));
        }

        @Test
        @DisplayName("한 장도 살 수 없는 금액의 String 을 LottoAmount 로 바꾸기 위해 검증 작업을 받으면 예외가 발생한다.")
        void givenStringLowerThanLotto_whenValidatingForLottoAmount_thenThrowsException() {
            //given
            String input = "0";

            //when & then
            assertThatThrownBy(() -> ValidationHolder.validate(input, LottoAmount.class))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(StringToLottoAmountValidator.LOWER_THEN_MIN_VALUE_MESSAGE);
        }

        @Test
        @DisplayName("1,000 으로 나누어지지 않는 금액의 String 을 LottoAmount 로 바꾸기 위해 검증 작업을 받으면 예외가 발생한다.")
        void givenStringNotDividedIn1000_whenValidatingForLottoAmount_thenThrowsException() {
            //given
            String input = "14500";

            //when & then
            assertThatThrownBy(() -> ValidationHolder.validate(input, LottoAmount.class))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(StringToLottoAmountValidator.NOT_DIVIDED_VALUE_MESSAGE);
        }

        @Test
        @DisplayName("정수가 아닌 값이 적힌 String 을 LottoAmount 로 바꾸기 위해 검증 작업을 받으면 예외가 발생한다.")
        void givenStringNotOnlyInteger_whenValidatingForLottoAmount_thenThrowsException() {
            //given
            String input = "45.000";

            //when & then
            assertThatThrownBy(() -> ValidationHolder.validate(input, LottoAmount.class))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(StringToLottoAmountValidator.NOT_NATURAL_NUMBER_MESSAGE);
        }

        @Test
        @DisplayName("숫자 사이에 , 을 넣는 것은 예외적으로 입력을 허용해준다.")
        void givenStringWithRest_whenValidatingForLottoAmount_thenPassesValidation() {
            //given
            String input = "45,000,000";

            //when & then
            assertDoesNotThrow(() -> ValidationHolder.validate(input, LottoAmount.class));
        }
    }

    @Nested
    @DisplayName("IntegerListToLottoValidator 테스트")
    class IntegerListToLottoValidatorTest {
        @Test
        @DisplayName("유효한 Integer List 를 Lotto 로 바꾸기 위해 검증 작업을 하면 통과한다.")
        void givenIntegerList_whenValidatingForLotto_thenPassesValidation() {
            //given
            List<Integer> numbers = Arrays.asList(2, 4, 5, 16, 42, 45);

            //when && then
            assertDoesNotThrow(() -> ValidationHolder.validate(numbers, Lotto.class));
        }

        @Test
        @DisplayName("사이즈가 6이 아닌 Integer List 를 Lotto 로 바꾸기 위해 검증 작업을 하면 예외가 발생한다.")
        void givenIntegerListSizeNot6_whenValidatingForLotto_thenThrowsException() {
            //given
            List<Integer> numbers = Arrays.asList(2, 4, 5, 10, 16, 42, 45);

            //when && then
            assertThatThrownBy(() -> ValidationHolder.validate(numbers, Lotto.class))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(IntegerListToLottoValidator.INVALID_LIST_SIZE_MESSAGE);
        }

        @Test
        @DisplayName("1~45 범위를 벗어나는 Integer List 를 Lotto 로 바꾸기 위해 검증 작업을 하면 예외가 발생한다.")
        void givenIntegerListWithInvalidNumberRange_whenValidatingForLotto_thenThrowsException() {
            //given
            List<Integer> numbers = Arrays.asList(2, 4, 5, 42, 45, 47);

            //when && then
            assertThatThrownBy(() -> ValidationHolder.validate(numbers, Lotto.class))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(IntegerListToLottoValidator.INVALID_NUMBER_RANGE_MESSAGE);
        }

        @Test
        @DisplayName("중복된 숫자가 있는 Integer List 를 Lotto 로 바꾸기 위해 검증 작업을 하면 예외가 발생한다.")
        void givenIntegerListWithDuplicatingNumber_whenValidatingForLotto_thenThrowsException() {
            //given
            List<Integer> numbers = Arrays.asList(2, 5, 5, 32, 43, 44);

            //when && then
            assertThatThrownBy(() -> ValidationHolder.validate(numbers, Lotto.class))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(IntegerListToLottoValidator.DUPLICATING_NUMBER_MESSAGE);
        }

        @Test
        @DisplayName("오름차순 정렬되어있지 않은 Integer List 를 Lotto 로 바꾸기 위해 검증 작업을 하면 오름차순으로 정렬이 되어있다.")
        void givenIntegerListNotSortedAsc_whenValidatingForLotto_thenThrowsException() {
            //given
            List<Integer> target = Arrays.asList(2, 4, 42, 11, 23, 44);
            List<Integer> orderedNumbers = new ArrayList<>(target);
            Collections.sort(orderedNumbers);

            assertThat(target)
                    .as("주어진 리스트는 오름차순 정렬이 안 되어있다.")
                    .isNotEqualTo(orderedNumbers);

            //when
            ValidationHolder.validate(target, Lotto.class);

            //then
            assertThat(target)
                    .as("검증 과정을 거친 후에는 오름차순 정렬이 되어 있다.")
                    .isEqualTo(orderedNumbers);
        }
    }
}