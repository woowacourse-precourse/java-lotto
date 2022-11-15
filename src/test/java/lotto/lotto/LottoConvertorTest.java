package lotto.lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoConvertorTest {
    LottoConvertor convertor = new LottoConvertor();

    @Nested
    class ConvertorTest {
        @DisplayName("입력 값을 쉼표를 기준으로 분할하여 String[] 반환")
        @Test
        void splitNumbersTest_1() {
            // given
            String input = "1,2,3,4,5,6";
            String[] result = {"1", "2", "3", "4", "5", "6"};

            // when
            String[] splitNumbers = convertor.splitNumbers(input);

            // then
            Assertions.assertThat(splitNumbers)
                    .containsExactly(result);
        }

        @DisplayName("String[] 값을 List<Integer>로 변환한다")
        @Test
        void convertNumbersTest() {
            String[] numbers = {"1", "2", "3", "4", "5", "6"};
            List<Integer> result = List.of(1, 2, 3, 4, 5, 6);

            // when
            List<Integer> convertNumbers = convertor.convertNumbers(numbers);

            // then
            Assertions.assertThat(convertNumbers)
                    .containsAll(result);
        }

        @DisplayName("List로 변환 중 정수가 아닌 값이 있으면 -1을 배열에 저장하고 예외 매세지를 발생시킨다.")
        @Test
        void convertNumbersTest_exception() {
            // given
            String[] numbers = {"1", "2", "3", "4", "5", "LOL"};
            int result = -1;

            // when
            List<Integer> convertNumbers = convertor.convertNumbers(numbers);

            // then
            Assertions.assertThat(convertNumbers)
                    .contains(result);
        }

    }

}