package lotto;

import lotto.numbers.WinningNumbers;
import lotto.winningNumbersGenerator.WinningNumbersGenerator;
import lotto.winningNumbersGenerator.WinningNumbersGeneratorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.ExceptionMessage.NOT_INTEGER;
import static lotto.constants.ExceptionMessage.NULL_POINTER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class WinningNumbersGeneratorTest {
    WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGeneratorImpl();

    private List<Integer> convertToIntegerList(String mainNumbers) {
        if (mainNumbers == null || mainNumbers.length() == 0) {
            throw new IllegalArgumentException(NULL_POINTER);
        }

        String[] numbersArr = mainNumbers.split(",");

        List<Integer> convertedNumbers;
        try {
            convertedNumbers = Arrays.stream(numbersArr)
                    .map(str -> Integer.parseInt(str))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
        return convertedNumbers;
    }

    private int convertToInteger(String bonusNumber) {
        int num = 0;
        try {
            num = Integer.parseInt(bonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
        return num;
    }

    @Nested
    @DisplayName("GenerateTest")
    public class GenerateTest {
        @Test
        void 중간에_빈칸이_있는_경우_테스트() {
            //given
            String mainNumbers = "1,2,,3,4,5";
            String bonusNumber = "7";
            //when
            Throwable throwable = catchThrowable(() -> {
                WinningNumbers winningNumbers = winningNumbersGenerator.generateWinningNumbers(mainNumbers, bonusNumber);
            });
            //then
            assertThat(throwable)
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @Test
        void null_테스트() {
            //given
            String mainNumbers = "1,2,7,3,4,5";
            String bonusNumber = null;
            //when
            Throwable throwable = catchThrowable(() -> {
                WinningNumbers winningNumbers = winningNumbersGenerator.generateWinningNumbers(mainNumbers, bonusNumber);
            });
            //then
            assertThat(throwable)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 소수점_테스트() {
            //given
            String mainNumbers = "1,2,7.5,3,4,5";
            String bonusNumber = "7";
            //when
            Throwable throwable = catchThrowable(() -> {
                WinningNumbers winningNumbers = winningNumbersGenerator.generateWinningNumbers(mainNumbers, bonusNumber);
            });
            //then
            assertThat(throwable)
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @Test
        void 정상_테스트() {
            //given
            String mainNumbers = "1,2,3,4,5,6";
            String bonusNumber = "7";
            //when
            WinningNumbers winningNumbers = winningNumbersGenerator.generateWinningNumbers(mainNumbers, bonusNumber);
            //then
            assertThat(winningNumbers.getNumbers())
                    .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
            assertThat(winningNumbers.getBonusNumber())
                    .isEqualTo(7);
        }
    }

    //private method이기에, 밑에서 복사해서 테스트
    @Nested
    @DisplayName("String을 Integer List로 전환하는 기능 테스트")
    public class ConvertToIntegerListTest {
        @Test
        void 쉽표가_없을_경우_빈칸_전환_테스트() {
            //given
            String input = "";
            //when
            Throwable throwable = catchThrowable(() -> {
                List<Integer> convertedList = convertToIntegerList(input);
            });
            //then
            assertThat(throwable)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 쉽표가_없을_경우_null_전환_테스트() {
            //given
            String input = null;
            //when
            Throwable throwable = catchThrowable(() -> {
                List<Integer> convertedList = convertToIntegerList(input);
            });
            //then
            assertThat(throwable)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 숫자가_아닌_경우_전환_테스트() {
            //given
            String input = "1,2,ㄹ";
            //when
            Throwable throwable = catchThrowable(() -> {
                List<Integer> convertedList = convertToIntegerList(input);
            });
            //then
            assertThat(throwable)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 숫자가_아닌_경우2_전환_테스트() {
            //given
            String input = "1,,ㄹ";
            //when
            Throwable throwable = catchThrowable(() -> {
                List<Integer> convertedList = convertToIntegerList(input);
            });
            //then
            assertThat(throwable)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 실수_전환_테스트() {
            //given
            String input = "1,2.5";
            //when
            Throwable throwable = catchThrowable(() -> {
                List<Integer> convertedList = convertToIntegerList(input);
            });
            //then
            assertThat(throwable)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 정상_테스트() {
            //given
            String input = "1,2,3";
            //when
            List<Integer> convertedList = convertToIntegerList(input);
            //then
            assertThat(convertedList)
                    .isEqualTo(List.of(1, 2, 3));
        }
    }

    @Nested
    @DisplayName("String을 Integer로 전환하는 기능 테스트")
    public class ConvertToIntegerTest {
        @Test
        void null_Test() {
            //given
            String input = null;
            //when
            Throwable throwable = catchThrowable(() -> {
                int convertedList = convertToInteger(input);
            });
            //then
            assertThat(throwable)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 공백_Test() {
            //given
            String input = "";
            //when
            Throwable throwable = catchThrowable(() -> {
                int convertedList = convertToInteger(input);
            });
            //then
            assertThat(throwable)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 공백2_Test() {
            //given
            String input = " ";
            //when
            Throwable throwable = catchThrowable(() -> {
                int convertedList = convertToInteger(input);
            });
            //then
            assertThat(throwable)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 다른_소숫점_Test() {
            //given
            String input = "1.5";
            //when
            Throwable throwable = catchThrowable(() -> {
                int convertedList = convertToInteger(input);
            });
            //then
            assertThat(throwable)
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }
}
